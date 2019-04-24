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
 * 
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_fire_license")
public class FireLicense extends Model<FireLicense> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 场所名称
     */
    private String name;

    /**
     * 消防负责人 
     */
    private String boss;

    /**
     * 地址
     */
    private String addr;

    /**
     * 使用性质
     */
    @TableField("allowType")
    private String allowType;

    /**
     * 场所所在建筑名称
     */
    private String building;

    /**
     * 场所所在层数
     */
    private String floor;

    /**
     * 场所所在建筑面积
     */
    private Integer area;

    /**
     * 现有消防设施
     */
    private String facility;

    /**
     * 发证机关
     */
    @TableField("issuedAgency")
    private String issuedAgency;

    /**
     * 发证日期
     */
    private LocalDateTime issued;

    /**
     * 证件照片图片保存路径
     */
    private String img;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime upadteTime;

    /**
     * 其它
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
