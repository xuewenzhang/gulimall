package com.bupt.gulimall.order.dao;

import com.bupt.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zhangxuewen
 * @email 18231366505@163.com
 * @date 2022-03-15 23:05:20
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
