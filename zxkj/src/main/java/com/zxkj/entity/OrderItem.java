package com.zxkj.entity;

import java.math.BigDecimal;
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
@TableName("tb_order_item")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店id
     */
    private Integer hotelId;

    /**
     * 房间id
     */
    private Integer roomId;

    /**
     * 所订房间数量
     */
    @TableField("dayAmount")
    private Integer dayAmount;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 入住时间
     */
    @TableField("inTime")
    private LocalDateTime inTime;

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
     * 订单id
     */
    private Integer orderId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
