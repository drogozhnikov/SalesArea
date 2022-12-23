package com.sales.service;

import com.sales.entity.PositionEntity;
import com.sales.repository.PositionDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PositionService {

    private PositionDao positionDao;
    private MessageService messageService;

    public PositionService(PositionDao positionDao, MessageService messageService) {
        this.positionDao = positionDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<PositionEntity> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Transactional
    public PositionEntity getPosition(int id) {
        return positionDao.getPosition(id);
    }

    @Transactional
    public void addPosition(PositionEntity positionEntity) {
        positionDao.addPosition(positionEntity);
    }

    @Transactional
    public void updatePosition(PositionEntity positionEntity) {
        positionDao.updatePosition(positionEntity);
    }

    @Transactional
    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }
}
