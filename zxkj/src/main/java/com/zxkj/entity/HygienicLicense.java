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
@TableName("tb_hygienic_license")
public class HygienicLicense extends Model<HygienicLicense> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 负责人名称
     */
    private String boss;

    /**
     * 地址
     */
    private String addr;

    /**
     * 许可项目  旅店
     */
    @TableField("allowType")
    private String allowType;

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
     * 有效期开始
     */
    @TableField("validStart")
    private LocalDateTime validStart;

    /**
     * 有效期结束
     */
    @TableField("validEnd")
    private LocalDateTime validEnd;

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
