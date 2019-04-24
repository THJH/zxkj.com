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
@TableName("tb_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 总价格
     */
    private BigDecimal price;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠券数量
     */
    @TableField("couponAmount")
    private Integer couponAmount;

    /**
     * 来源方式（苹果、安卓、小程序、网站）
     */
    private String source;

    /**
     * 支付方式
     */
    @TableField("payMethod")
    private String payMethod;

    /**
     * 交易状态（0：Transaction交易中；1：Success交易成功；2：Fail交易失败；3：Cancel交易取消）
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
