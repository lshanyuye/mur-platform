package com.mur.service.base;

import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {

    void saveOrUpdate(T t, String operator);
}
