package com.practice.bootintegrate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class MybatisPlusGeneratorTest {

    @Test
    void generate() {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C:\\JavaSpace\\javaProject\\boot-integrate\\src\\main\\java\\com\\practice\\bootintegrate");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("liy");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！

        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
//         gc.setControllerName("%sApi");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
                String t = fieldType.toLowerCase();
                if (t.contains("bigint")) {
                    return DbColumnType.LONG;
                }
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(config, fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345");
        //dburl
        dsc.setUrl("jdbc:mysql://localhost:3306/mysql_demo?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "t_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setFieldPrefix(new String[] { "f_"});//字段前缀
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 需要生成的表
        strategy.setInclude(new String[]{
                "user_info"
        });

        //strategy.setExclude(new String[]{"test"}); // 排除生成的表，与setInclude二选一配置
        // 自定义实体父类
//        strategy.setSuperEntityClass("com.glodon.jjfab.cloud.base.domain.BaseModel");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("localhost");
        // 这里是控制器类名上@RequestMapping("/")中的参数，默认为表名
        //如果模块有公共路径，可以在此处配置，如果没有需要设置为null，否则Controller中@RequestMapping路径会出现双“//”
        //pc.setModuleName("basis");
        pc.setModuleName(null);
        pc.setController("api");// 这里是控制器包名，默认 web
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("domain");// 这里是实体类包名，默认 entity
        pc.setMapper("mapper");// 这里是持久层包名，默认 mapper
        pc.setXml("mapper");// 这里是xml文件名，默认 mapper.xml
        mpg.setPackageInfo(pc);


        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

    }


}
