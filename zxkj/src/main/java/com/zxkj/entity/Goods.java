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
 * 商品
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称（例水的名称）
     */
    private String name;

    /**
     * 单位（例水的瓶数）
     */
    private String unit;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 图片（水、方便面、）
     */
    private String img;

    /**
     * 审核状态：（0：passed审核中，1：auditing审核成功，2：rejected审核失败）
     */
    private Integer state;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
