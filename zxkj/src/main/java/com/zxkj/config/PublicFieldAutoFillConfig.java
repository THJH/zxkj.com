package com.zxkj.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 配置公共字段自动填充功能
 */

@Component
public class PublicFieldAutoFillConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (createTime == null)
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null)
            setFieldValByName("updateTime",LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);//mybatis-plus版本2.0.9+
        }
    }
}