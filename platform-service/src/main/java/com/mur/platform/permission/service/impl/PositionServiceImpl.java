package com.mur.platform.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.exception.BusinessException;
import com.mur.platform.permission.domain.Position;
import com.mur.platform.permission.mapper.PositionMapper;
import com.mur.platform.permission.service.PositionService;
import com.mur.service.base.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 岗位 服务实现类
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@Service
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
  @Resource private PositionMapper positionMapper;

  @Override
  public void save(Position position, String operator) {
    if (StringUtils.isBlank(position.getPosCode())) {
      throw new BusinessException("岗位编码不能为空");
    }
    if (StringUtils.isBlank(position.getPosName())) {
      throw new BusinessException("岗位名称不能为空");
    }
    if (position.isNew() && position.getEnabled() == null) {
      position.setEnabled(Boolean.TRUE);
    }
    Position existed = findByCode(position.getPosCode());
    if (existed != null && !existed.getId().equals(position.getId())) {
      throw new BusinessException("岗位编码%s已存在", existed.getPosCode());
    }
    save(position, operator);
  }

  @Override
  public Position findByCode(String posCode) {
    QueryWrapper<Position> qw = new QueryWrapper<>();
    qw.eq("pos_code", posCode);
    return getOne(qw);
  }
}
