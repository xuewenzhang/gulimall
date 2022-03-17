package com.bupt.gulimall.member.feign;

import com.bupt.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


// 要使用name输性指明拟调用微服务的名字
@FeignClient(name = "gulimall-coupon")
public interface CouponFeignService {
    /**
     * 注解@FeignClient指明是远程调用客户端
     *     该接口指明以后在本模块有人调用membercoupons方法，
     *     则去注册中心nacos中找注册名为FeignClient服务，执行/coupon/coupon/member/list方法
     * @return
     */

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
