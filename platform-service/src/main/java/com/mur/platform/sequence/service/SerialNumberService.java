package com.mur.platform.sequence.service;

import com.mur.platform.sequence.domain.SerialNumber;
import com.mur.service.base.BaseService;

/**
 * <p>
 * 序列号 服务类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
public interface SerialNumberService extends BaseService<SerialNumber> {

    /**
     * 生成编码
     * @param bizKey
     * @param startVal
     * @param step
     * @param length
     * @return
     */
    String generateSerialNum(String bizKey, int startVal, int step, int length);
}
