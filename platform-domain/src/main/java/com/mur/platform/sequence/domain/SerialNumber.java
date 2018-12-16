package com.mur.platform.sequence.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p> 序列号 </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
@TableName("plat_serial_number")
public class SerialNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    /**
     * KEY值
     */
    @TableField("KEY_VALUE")
    private String keyValue;

    /**
     * 下一个值
     */
    @TableField("NEXT_NUMBER")
    private Integer nextNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Integer getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(Integer nextNumber) {
        this.nextNumber = nextNumber;
    }

    @Override
    public String toString() {
        return "SerialNumber{" +
                "id=" + id +
                "keyValue=" + keyValue +
                ", nextNumber=" + nextNumber +
                "}";
    }
}
