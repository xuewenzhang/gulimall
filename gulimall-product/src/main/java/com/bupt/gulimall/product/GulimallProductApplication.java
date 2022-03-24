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


 	3 JSR303后端校验： 前端表单校验数据合法性后，后端也要进行校验
 		1） 给Bean添加校验注解:javax.validation.constraints，并定义自己的message提示
 		2)  开启校验功能@Valid
 		3） 给校验的bean后跟一个BindingResult，就可以获取到校验结果
		4） 分组校验（可完成多场景地复杂校验）
 			1) @NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
			给校验注解标注什么情况需要进行校验
 			2）在controller上标注：@Validated({AddGroup.class}),指定校验那一组
 			3）默认没有指定分组校验的注解@NotBlank，在分组校验的情况下不生效，只会在@Validated无校验分组情况下生效

 		5） 自定义校验
 			1） 编写自定义的校验注解
 			2） 编写自定义的校验器ConstraintValidator,同一个校验注解可以指定多个不同的校验器，适配不同类型的校验
 			3） 关联自定义的校验器和自定义的校验注解validatedBy



 4 统一的异常处理
 	@ControllerAdvice
 		1） 编写异常处理类，使用@ControllerAdvice
 		2） 使用@ExceptionHandler标明方法可以处理的异常
 */

@EnableDiscoveryClient
@MapperScan("com.bupt.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
