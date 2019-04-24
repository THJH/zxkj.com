package com.zxkj.service.impl;

import com.zxkj.entity.Order;
import com.zxkj.dao.OrderDao;
import com.zxkj.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}
