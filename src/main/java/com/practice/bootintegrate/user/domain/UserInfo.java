package com.practice.bootintegrate.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理平台用户信息表
 * </p>
 *
 * @author liy
 * @since 2022-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 头像url
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 身份证号
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 自然人id
     */
    @TableField("nature_person_id")
    private Long naturePersonId;

    /**
     * 乐观锁
     */
    @TableField("revision")
    private Integer revision;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 是否删除 0正常1删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;

    @TableField("password")
    private String password;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
