package com.mur.platform.permission.service.impl;

import com.mur.platform.permission.domain.Position;
import com.mur.platform.permission.mapper.PositionMapper;
import com.mur.platform.permission.service.PositionService;
import com.mur.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 * 岗位 服务实现类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@Service
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    @Resource
    private PositionMapper positionMapper;
}
