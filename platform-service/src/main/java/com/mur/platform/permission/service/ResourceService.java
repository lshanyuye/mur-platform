package com.mur.platform.permission.service;

import com.mur.platform.permission.domain.Resources;
import com.mur.service.base.BaseService;
import java.util.List;
import javax.annotation.Resource;

/**
 * <p>
 * 资源管理 服务类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-22
 */
public interface ResourceService extends BaseService<Resources> {

    void resetResources(List<Resources> resources);
}
