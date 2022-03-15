package com.bupt.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.common.utils.PageUtils;
import com.bupt.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author zhangxuewen
 * @email 18231366505@163.com
 * @date 2022-03-15 22:39:49
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

