package com.bupt.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.common.utils.PageUtils;
import com.bupt.gulimall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author zhangxuewen
 * @email 18231366505@163.com
 * @date 2022-03-15 23:10:06
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

