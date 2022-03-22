package com.bupt.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1 整合Mybatis plus
 *  1）导入依赖
 *  	 <dependency>
			 <groupId>com.baomidou</groupId>
			 <artifactId>mybatis-plus-boot-starter</artifactId>
			 <version>3.2.0</version>
		 </dependency>
 	2）配置
 		1 配置数据源、
 			1）导入数据库的驱动
 			2) 在application.yml配置数据源相关的信息
 		2 配置MybatisPlus
			1) 配置@MapperScan
 			2）告诉Mybatis-Plus sql映射文件位置（在配置文件中配置mybatis-plus:mapper-locations）

    2 逻辑删除
 		1） 配置全局的逻辑删除规则，利用mybatis-plus实现
 		2） 配置逻辑删除的组件Bean（该版本忽略）
 		3） 给Bean加上逻辑删除注解：@TableLogic


 */

@EnableDiscoveryClient
@MapperScan("com.bupt.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
