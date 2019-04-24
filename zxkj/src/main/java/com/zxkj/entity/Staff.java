package com.zxkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_staff")
public class Staff extends Model<Staff> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String tel;

    /**
     * 紧急联系人
     */
    @TableField("emergencyContact")
    private String emergencyContact;

    /**
     * 紧急联系电话
     */
    @TableField("emergencyTel")
    private String emergencyTel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 生日
     */
    private LocalDate birth;

    /**
     * 住址
     */
    private String addr;

    /**
     * 身份证号
     */
    private String num;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 其它信息
     */
    private String info;

    /**
     * 所属宾馆id
     */
    private Integer hotelId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
