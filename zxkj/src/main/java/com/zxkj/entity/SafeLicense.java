package com.zxkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 酒店营业执照表
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_safe_license")
public class SafeLicense extends Model<SafeLicense> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 证照编号
     */
    private String number;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 法人
     */
    private String boss;

    /**
     * 类型
     */
    private String type;

    /**
     * 经营地址
     */
    private String address;

    /**
     * 经济性质
     */
    private String property;

    /**
     * 经营项目
     */
    private String proj;

    /**
     * 有效期
     */
    private String valid;

    /**
     * 发证日期
     */
    private LocalDateTime issued;

    /**
     * 登记机关
     */
    @TableField("issuedAgency")
    private String issuedAgency;

    /**
     * 执照图片
     */
    private String img;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 最后修改日期
     */
    private LocalDateTime updateTime;

    /**
     * 创建日期
     */
    private LocalDateTime createdTime;

    /**
     * 备注
     */
    private String info;

    /**
     * 宾馆id
     */
    private Integer hotelId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
