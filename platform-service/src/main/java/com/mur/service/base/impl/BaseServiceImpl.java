package com.mur.service.base.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mur.domain.Domain;
import com.mur.service.base.BaseService;

/**
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 11:09
 **/
public class BaseServiceImpl<T> extends ServiceImpl<BaseMapper<T>, T> implements BaseService<T> {

    @Override
    protected Class<T> currentModelClass() {
        return ReflectionKit.getSuperClassGenericType(this.getClass(), 0);
    }

    public void saveOrUpdate(T t, String operator) {
        if (t instanceof Domain) {
          ((Domain) t).fillOperator(operator);
        }
        saveOrUpdate(t);
    }
}
