package com.mur.platform.sequence.service;

import com.mur.platform.sequence.domain.SerialNumberRule;
import com.mur.service.base.BaseService;

/**
 * <p>
 * 序列号规则 服务类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
public interface SerialNumberRuleService extends BaseService<SerialNumberRule> {

    void save(SerialNumberRule serialNumberRule, String operator);

    SerialNumberRule findByCode(String code);

    /**
     * 生成序列号
     * @param code
     * @return
     */
    String generateSerialNum(String code, String bizKey);
}
