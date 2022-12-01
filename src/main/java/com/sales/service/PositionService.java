package com.sales.service;

import com.sales.entity.Position;
import com.sales.entity.User;
import com.sales.repository.PositionDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionService {

    private PositionDao positionDao;
    private MessageService messageService;

    public PositionService(PositionDao positionDao, MessageService messageService) {
        this.positionDao = positionDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Transactional
    public Position getPosition(int id) {
        return positionDao.getPosition(id);
    }

    @Transactional
    public void addPosition(Position position) {
        positionDao.addPosition(position);
    }

    @Transactional
    public void updatePosition(Position position) {
        positionDao.updatePosition(position);
    }

    @Transactional
    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }
}
