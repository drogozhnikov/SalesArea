package com.sales.repository;

import com.sales.entity.Position;

import java.util.List;

public interface PositionDao {

    public List<Position> getAllPosition();

    public Position getPosition(int id);

    public Position addPosition(Position position);

    public void updatePosition(Position position);

    public void deletePosition(int id);
}
