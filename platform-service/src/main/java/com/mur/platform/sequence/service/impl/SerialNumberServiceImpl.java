package com.mur.platform.sequence.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.platform.sequence.domain.SerialNumber;
import com.mur.platform.sequence.mapper.SerialNumberMapper;
import com.mur.platform.sequence.service.SerialNumberService;
import com.mur.service.base.impl.BaseServiceImpl;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 序列号 服务实现类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
@Service
public class SerialNumberServiceImpl extends BaseServiceImpl<SerialNumber> implements SerialNumberService {
    private static final Logger logger = LoggerFactory.getLogger(SerialNumberServiceImpl.class);

    @Resource
    private SerialNumberMapper serialNumberMapper;

    /**
     * 生成器锁
     */
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public String generateSerialNum(String bizKey, int startVal, int step, int length) {
        String serialNo = new String();
        lock.lock();
        try {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("key_value", bizKey);
            SerialNumber serialNumber = getOne(qw);
            if (serialNumber == null) {
                serialNumber = new SerialNumber();
                serialNumber.setKeyValue(bizKey);
                serialNumber.setNextNumber(startVal);
            }
            Integer currentNum = serialNumber.getNextNumber();
            Integer maxNum = getMax(length);
            if (maxNum != -1 && currentNum.compareTo(maxNum) > 0) {
                throw new RuntimeException(String.format("当前序号长度已超过配置的最大长度%s", length));
            }
            Integer nextNum = currentNum + step;
            serialNumber.setNextNumber(nextNum);
            String pattern = "%0" + length + "d";
            serialNo = String.format(pattern, currentNum);
            this.saveOrUpdate(serialNumber);
        } finally {
            lock.unlock();
        }
        return serialNo;
    }

    /**
     * 获取当前长度最大数字
     */
    private Integer getMax(int length) {
        StringBuilder sb = new StringBuilder();
        if (length == 0) {//如果长度为0 ，则不限制最大数量
            return -1;
        }
        for (int i = 0; i < length; i++) {
            sb.append(9);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("序列号允许最大值：" + sb.toString());
        }
        return Integer.parseInt(sb.toString());
    }
}
