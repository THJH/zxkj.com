package com.zxkj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 酒店表
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_hotel")
public class Hotel extends Model<Hotel> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店名称
     */
    private String name;

    /**
     * 酒店类型：1：直营店，2：加盟店，3：协议店
     */
    private Integer type;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 酒店网址
     */
    private String url;

    /**
     * 酒店LOGO
     */
    private String logo;

    /**
     * 区县id
     */
    private Integer districtId;

    /**
     * 街道
     */
    private String street;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 经度
     */
    private Float longitude;

    /**
     * 纬度
     */
    private Float latitude;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 状态（0：Normal正常运营；1：Pause暂停运营；2：Rectify违规整顿；3：Close停业）
     */
    private Integer state;

    /**
     * 开业时间
     */
    @TableField("openTime")
    private LocalDateTime openTime;

    /**
     * 最后装修时间
     */
    @TableField("renovationTime")
    private LocalDateTime renovationTime;

    /**
     * 酒店电话｛qiantai1:11111,qiantai2222,wensheng:22222｝
     */
    private String tels;

    /**
     * 总评分
     */
    private Float rate;

    /**
     * 服务评分
     */
    @TableField("serviceRate")
    private Float serviceRate;

    /**
     * 卫生评分
     */
    @TableField("hygieneRate")
    private Float hygieneRate;

    /**
     * 位置评分 
     */
    @TableField("positionRate")
    private Float positionRate;

    /**
     * 设置评分
     */
    @TableField("deviceRate")
    private Float deviceRate;

    /**
     * 押金
     */
    private Integer deposit;

    /**
     * 最早入住时间
     */
    private LocalDateTime startTime;

    /**
     * 最晚入住时间
     */
    private LocalDateTime endTime;

    /**
     * 最晚离店时间
     */
    private LocalDateTime checkoutTime;



    /**
     * 最晚取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 周末设定 [7,8]
     */
    private String weekend;

    /**
     * 钟点房最早开始时间
     */
    private LocalDateTime hourlyStartTime;

    /**
     * 钟点房最晚结束时间
     */
    private LocalDateTime hourlyEndTime;

    /**
     * 钟点房最少时间
     */
    @TableField("hourlyHours")
    private Integer hourlyHours;

    /**
     * 酒店加盟时间
     */
    private LocalDateTime createTime;

    /**
     * 酒店信息最后一次信息修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 其它
     */
    private String info;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    //////////////////////////////////////////////////////////////
    @TableField(exist = false)
    private String provinceCityDistrict;


    //////////////////////////////////日期相关////////////////////////////////////////////////////////

    public String getOpenTimeStr() {//钟点房最早开始时间
        if (null!=openTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(openTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }

    public String getRenovationTimeStr() {//钟点房最早开始时间
        if (null!=renovationTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(renovationTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }

    public String getStartTimeStr() {//钟点房最早开始时间
        if (null!=startTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(startTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }


    public String getEndTimeStr() {//钟点房最早开始时间
        if (null!=endTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(endTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }


    public String getCheckoutTimeStr() {//钟点房最早开始时间
        if (null!=checkoutTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(checkoutTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }


    public String getCancelTimeStr() {//钟点房最早开始时间
        if (null!=cancelTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(cancelTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }

    public String getHourlyStartTimeStr() {//钟点房最早开始时间
        if (null!=hourlyStartTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(hourlyStartTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }


    public String getHourlyEndTimeStr() {//钟点房最晚结束时间
        if (null!=hourlyEndTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(hourlyEndTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }

    public String getCreateTimeStr() {//创建时间
        if (null!=createTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(createTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }
    public String getUpdateTimeStr() {//跟新时间
        if (null!=updateTime) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
            String localTime = dtf.format(updateTime);
            return localTime.substring(0, localTime.indexOf('日') + 1) + "\r" + localTime.substring(localTime.indexOf('日') + 1);
        }else
            return null;
    }

}
