package com.bupt.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.gulimall.product.entity.BrandEntity;
import com.bupt.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * 1 引入oss-starter
 * 2 配置key endpoint相关信息即可
 * 3 使用OSSClient操作即可
 */

@SpringBootTest
class GulimallProductApplicationTests {

	@Autowired
	BrandService brandService;




	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("修改为描述");
//		brandEntity.setDescript("描述是华为");
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		System.out.println("测试、保存成功");
//		brandService.updateById(brandEntity);
//		System.out.println("测试修改");
		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		list.forEach((item)->{
			System.out.println(item);
		});

	}

}
