package com.bupt.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.common.utils.PageUtils;
import com.bupt.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author zhangxuewen
 * @email 18231366505@163.com
 * @date 2022-03-15 22:52:10
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

