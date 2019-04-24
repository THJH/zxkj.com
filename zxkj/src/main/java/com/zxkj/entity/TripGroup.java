package com.zxkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tb_trip_group")
public class TripGroup extends Model<TripGroup> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 路线
     */
    private String route;

    /**
     * 总的人数
     */
    @TableField("personAmount")
    private Integer personAmount;

    /**
     * 用房量
     */
    @TableField("roomAmount")
    private Integer roomAmount;

    /**
     * 导游
     */
    private String guider;

    /**
     * 导游联系电话
     */
    private String tel;

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
