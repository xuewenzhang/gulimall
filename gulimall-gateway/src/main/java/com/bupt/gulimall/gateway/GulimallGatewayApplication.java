package com.bupt.gulimall.gateway;

import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 网关：路由先经过断言判断是否符合路由规则，若符合，则路由，该路由需经过一系列filter过滤。


/**
 * 1 网关开启服务注册发现
 * 		配置nacos的注册中心地址
 *
 */


// 由于引入了common模块，依赖了Mybatisplus等数据库相关操作，于是先排除掉相关配置信息

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GulimallGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallGatewayApplication.class, args);
	}

}
