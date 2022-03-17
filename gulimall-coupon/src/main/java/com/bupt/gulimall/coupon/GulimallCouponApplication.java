package com.bupt.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


// @EnableDiscoveryClient 开启注册服务中心的注解


/**
 * 1 如何使用Nacos作为配置中心统一管理配置
 *   1） 引入依赖
 *			<dependency>
 				<groupId>com.alibaba.cloud</groupId>
 				<artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 			</dependency>
 	 2）  创建bootstrap.properties,给出nacos名字以及地址
 	 3）  配置中心添加数据集Data id，并给出具体配置内容,配置格式和名称还是要统一的
 	 4）  动态获取配置，通过注解@RefreshScope    @Value("${配置项的名}")获取某个配置的值
 			如果配置中心和当前应用的配置文件都配置了相同的项，优先使用配置中心的配置

   2 细节
 	 1） 命名空间： 用作配置隔离
 			默认： public（保留空间），默认所有新增的配置都在public空间
 	 			1、开发、测试、生产：利用命名空间来做环境隔离
 					注：在bootstrap.properties配置要使用的命名空间的值
 					spring.cloud.nacos.config.namespace=43148c51-21fa-48c7-b9bb-13689e4388a7
				2、 若每个环境下有好多配置文件，则可以基于每个微服务进行互相隔离配置，每一个微服务都创建自己的命名空间
 					只加载自己命名空间下的所有配置
     2） 配置集： 所有配置的集合
 	 3） 配置集ID：Data ID
 	 4） 配置分组：默认所有配置都属于DEGAULT_GROUP，可以按照不同业务进行分组配置

   3 同时加载多个配置集
      1） 微服务任何配置信息，任何配置文件都可以放在配置中心
 	  2） 只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
      3） @Value等springboot任何从配置文件中获取值的方法、注解都可以使用，且配置中心中的配置优先级较高
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCouponApplication.class, args);
	}

}
