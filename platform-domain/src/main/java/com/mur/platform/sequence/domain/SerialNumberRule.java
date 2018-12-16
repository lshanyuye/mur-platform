package com.mur.platform.sequence.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 序列号规则
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
@TableName("plat_serial_number_rule")
public class SerialNumberRule extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 规则编码
     */
    @TableField("RULE_CODE")
    private String ruleCode;

    /**
     * 规则名称
     */
    @TableField("RULE_NAME")
    private String ruleName;

    /**
     * 编码前缀
     */
    @TableField("RULE_PREFIX")
    private String rulePrefix;

    /**
     * 日期格式
     */
    @TableField("DATE_FORMAT")
    private String dateFormat;

    /**
     * 编码格式
     */
    @TableField("STR_FORMAT")
    private String strFormat;

    /**
     * 序列长度
     */
    @TableField("SERIAL_LENGTH")
    private Integer serialLength;

    /**
     * 开始序号
     */
    @TableField("SERIAL_START")
    private Integer serialStart;

    /**
     * 步长
     */
    @TableField("SETUP")
    private Integer setup;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRulePrefix() {
        return rulePrefix;
    }

    public void setRulePrefix(String rulePrefix) {
        this.rulePrefix = rulePrefix;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Integer getSerialLength() {
        return serialLength;
    }

    public void setSerialLength(Integer serialLength) {
        this.serialLength = serialLength;
    }

    public Integer getSerialStart() {
        return serialStart;
    }

    public void setSerialStart(Integer serialStart) {
        this.serialStart = serialStart;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public Integer getSetup() {
        return setup;
    }

    public void setSetup(Integer setup) {
        this.setup = setup;
    }

}
