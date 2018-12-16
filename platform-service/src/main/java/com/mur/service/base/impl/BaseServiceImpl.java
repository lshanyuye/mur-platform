package com.mur.service.base.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mur.domain.Domain;
import com.mur.service.base.BaseService;
import java.util.Date;

/**
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 11:09
 **/
public class BaseServiceImpl<T> extends ServiceImpl<BaseMapper<T>, T> implements BaseService<T> {

    public void saveOrUpdate(T t, String operator) {
        if (t instanceof Domain) {
            if (((Domain) t).isNew()) {
                ((Domain) t).setCreatedTime(new Date());
                ((Domain) t).setCreatedBy(operator);
            } else {
                ((Domain) t).setModifiedBy(operator);
                ((Domain) t).setModifiedTime(new Date());
            }
        }
        saveOrUpdate(t);
    }
}
