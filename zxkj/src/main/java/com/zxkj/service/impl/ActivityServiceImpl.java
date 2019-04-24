package com.zxkj.service.impl;

import com.zxkj.entity.Activity;
import com.zxkj.dao.ActivityDao;
import com.zxkj.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表

暂定，所有的活动都以发放优惠券的形式实施

活动需要人工干预 服务实现类
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityDao, Activity> implements ActivityService {

}
