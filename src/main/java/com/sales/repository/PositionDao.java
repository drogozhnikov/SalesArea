package com.sales.repository;

import com.sales.entity.PositionEntity;

import java.util.List;

public interface PositionDao {

    public List<PositionEntity> getAllPosition();

    public PositionEntity getPosition(int id);

    public PositionEntity addPosition(PositionEntity positionEntity);

    public void updatePosition(PositionEntity positionEntity);

    public void deletePosition(int id);
}
