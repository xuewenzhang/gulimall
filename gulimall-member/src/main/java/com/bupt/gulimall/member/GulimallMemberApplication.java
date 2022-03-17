package com.bupt.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.bupt.gulimall.member.feign")
public class GulimallMemberApplication {

	/**
	 * 想要远程调用其他模块服务的步骤
	 *     1） 该模块pom引入spring-cloud-starter-openfeign
	 *     2） 编写接口，告诉SpringCloud这个接口需要调用远程服务：见CouponFeignService类
	 *     		1 声明接口的每一个方法都是调用远程服务的哪个请求
	 *     3） 使用注解开启远程调用功能@EnableFeignClients
	 */

	public static void main(String[] args) {
		SpringApplication.run(GulimallMemberApplication.class, args);
	}

}
