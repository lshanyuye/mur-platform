package com.mur.platform.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.platform.permission.domain.Resources;
import com.mur.platform.permission.mapper.ResourceMapper;
import com.mur.platform.permission.service.ResourceService;
import com.mur.service.base.impl.BaseServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 * 资源管理 服务实现类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-22
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resources> implements ResourceService {
    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public void resetResources(List<Resources> resources) {
        this.remove(new QueryWrapper<Resources>());
        this.saveOrUpdateBatch(resources);
    }
}
