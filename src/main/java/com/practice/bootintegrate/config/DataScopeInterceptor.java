package com.practice.bootintegrate.config;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

@Slf4j
@AllArgsConstructor
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
//@Component
public class DataScopeInterceptor  extends AbstractSqlParserHandler implements Interceptor {
    private DataSource dataSource;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 先判断是不是SELECT操作 不是直接过滤
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return invocation.proceed();
        }

        this.sqlParser(metaObject);
        //
        appendOrderBy(metaObject);
        return invocation.proceed();
    }

    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * mybatis配置的属性
     *
     * @param properties mybatis配置的属性
     */
    @Override
    public void setProperties(Properties properties) {

    }







    private void appendOrderBy(MetaObject metaObject) {
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        // 执行的SQL语句
        String originalSql = boundSql.getSql();
        //如果sql中已经有where条件，则在where条件后添加 未删除条件，如果没有where条件，则在最后添加 未删除条件
        if (originalSql.toLowerCase().indexOf("where") == -1) {
            originalSql += " where is_delete = 0";
        } else {
            originalSql += " and is_delete = 0";
        }
        //如果sql语句中左关联或者右关联或者内关联了多张表，则每张表都需要添加未删除条件
        if (originalSql.toLowerCase().indexOf("left join") != -1 || originalSql.toLowerCase().indexOf("right join") != -1 || originalSql.toLowerCase().indexOf("inner join") != -1) {
            String[] split = originalSql.split("join");
            for (String s : split) {
                if (s.toLowerCase().indexOf("where") == -1) {
                    s += " where is_delete = 0";
                } else {
                    s += " and is_delete = 0";
                }
            }
            originalSql = String.join("join", split);
        }


        metaObject.setValue("delegate.boundSql.sql", originalSql);
    }

    // SQL语句的参数
    //Object parameterObject = boundSql.getParameterObject();

//        int index = originalSql.indexOf("LIMIT");
//        if ( index != -1) {
//
//            String[] ary = originalSql.split("LIMIT");
//            originalSql = ary [0] + " order by create_time desc limit" + ary[1];
//        } else {
//
//            originalSql += " order by create_time desc";
//        }
}
