package com.mur.platform.sequence.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.exception.BusinessException;
import com.mur.platform.sequence.domain.SerialNumberRule;
import com.mur.platform.sequence.mapper.SerialNumberRuleMapper;
import com.mur.platform.sequence.service.SerialNumberRuleService;
import com.mur.platform.sequence.service.SerialNumberService;
import com.mur.service.base.impl.BaseServiceImpl;
import com.mur.utils.ParseKeyword;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> 序列号规则 服务实现类 </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
@Service
public class SerialNumberRuleServiceImpl extends BaseServiceImpl<SerialNumberRule> implements SerialNumberRuleService {

    public static final String BIZ_KEY = "BIZKEY";
    public static final String DATE = "DATE";
    public static final String SERIAL_NO = "SERIALNO";
    public static final String PREFIX = "PREFIX";

    @Resource
    private SerialNumberRuleMapper serialNumberRuleMapper;

    @Autowired
    private SerialNumberService serialNumberService;

    @Override
    public void save(SerialNumberRule serialNumberRule, String operator) {
        if (StringUtils.isBlank(serialNumberRule.getRuleCode())) {
            throw new BusinessException("编码规则编码不能为空");
        }
        if (StringUtils.isBlank(serialNumberRule.getRuleName())) {
            throw new BusinessException("编码规则名称不能为空");
        }
        if (serialNumberRule.getSerialLength() == null) {
            throw new BusinessException("编码规则序列长度不能为空");
        }
        if (serialNumberRule.getSerialLength() < 0) {
            throw new BusinessException("编码规则序列长度不能小于0");
        }
        if (serialNumberRule.getSerialStart() == null) {
            throw new BusinessException("编码规则开始序号不能为空");
        }
        if (serialNumberRule.getSerialStart() < 0) {
            throw new BusinessException("编码规则开始序号不能小于0");
        }
        if (serialNumberRule.isNew()) {
            SerialNumberRule existed = findByCode(serialNumberRule.getRuleCode());
            if (existed != null && !existed.getId().equals(serialNumberRule.getId())) {
                throw new BusinessException("规则编码%s不能重复添加", serialNumberRule.getRuleCode());
            }
        }
        saveOrUpdate(serialNumberRule, operator);
    }

    @Override
    public SerialNumberRule findByCode(String code) {
        QueryWrapper<SerialNumberRule> qw = new QueryWrapper<>();
        qw.eq("RULE_CODE", code);
        return this.getOne(qw);
    }

    @Override
    public String generateSerialNum(String code, String bizKey) {
        SerialNumberRule rule = findByCode(code);
        if (rule == null) {
            throw new BusinessException("编码%s编码规则不存在", code);
        }
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(rule.getStrFormat())) {
            List<String> list = ParseKeyword.getKeywords(rule.getStrFormat());
            list.forEach((key) -> {
                switch (key) {
                    case BIZ_KEY:
                        sb.append(bizKey);
                        break;
                    case SERIAL_NO:
                        sb.append(code);
                        break;
                    case PREFIX:
                        sb.append(rule.getRulePrefix());
                        break;
                    case DATE:
                        if (StringUtils.isBlank(rule.getDateFormat())) {
                            throw new BusinessException("编码规则%s未配置日期格式", rule.getRuleName());
                        }
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat(rule.getDateFormat());
                            sb.append(sdf.format(new Date()));
                        } catch (Exception e) {
                            throw new BusinessException("编码规则%s日期格式%s配置有误", rule.getRuleName(), rule.getDateFormat());
                        }
                }
            });
        } else {
            sb.append(code);
        }
        String serialNo = serialNumberService.generateSerialNum(sb.toString(), rule.getSerialStart(), rule.getSetup(), rule.getSerialLength());
        return sb.toString().replace(code, serialNo);
    }

}
