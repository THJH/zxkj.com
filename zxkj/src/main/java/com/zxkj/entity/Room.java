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
@TableName("tb_room")
public class Room extends Model<Room> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态（0：空闲；1：占用；2：入住；3：打扫；4：维修；5：保留）
     */
    private Integer status;

    /**
     * 建筑
     */
    private String building;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 房间号
     */
    private String door;

    /**
     * 展示图片 {url1,url2,url3}
     */
    private String imgs;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * VR存放地址
     */
    private String vr;

    /**
     * 卫生间类型（独蹲、独坐、公共）
     */
    private String toilet;

    /**
     * 是否有洗漱用品
     */
    private Boolean toiletries;

    /**
     * 洗澡类型（无、淋浴、浴缸）
     */
    @TableField("xiZao")
    private String xiZao;

    /**
     * 热水提供时长（0无、24全天提供）
     */
    @TableField("hotWater")
    private Integer hotWater;

    /**
     * 是否有吹风机
     */
    private Boolean blower;

    /**
     * 是否有空气净化器
     */
    @TableField("airCleaner")
    private Boolean airCleaner;

    /**
     * 是否有电脑
     */
    private Boolean computer;

    /**
     * {名称：密码}
     */
    private String wifi;

    /**
     * 床型（1.2m、1.5m）
     */
    private String bed;

    /**
     * 是否提供免费瓶装水
     */
    @TableField("bottleWater")
    private Boolean bottleWater;

    /**
     * 状态（在住、空闲、打扫、维修）
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
     * 其它信息
     */
    private String info;

    /**
     * 锁编号
     */
    private Integer lockId;

    /**
     * 房间类型
     */
    private Integer typeId;

    /**
     * 酒店编号
     */
    private Integer hotelId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
