package com.zxkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 优惠券表
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_coupon")
public class Coupon extends Model<Coupon> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券类型：0：满减券；1：折扣券
     */
    private Integer type;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 宣传图片保存路径
     */
    private String img;

    /**
     * 总数量
     */
    private Integer amount;

    /**
     * 库存数量
     */
    private Integer store;

    /**
     * 满减额中的“满”额
     */
    private Float condition;

    /**
     * 满减额中的“减”额
     */
    private Float discount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String info;

    /**
     * 房型id
     */
    private Integer roomTypeId;

    /**
     * 活动id
     */
    private Integer activityId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
