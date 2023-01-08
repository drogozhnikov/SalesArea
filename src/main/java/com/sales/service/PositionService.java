package com.sales.service;

import com.sales.entity.PositionEntity;
import com.sales.repository.PositionDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PositionService {

    private PositionDao positionDao;
    private MessageService messageService;

    public PositionService(PositionDao positionDao, MessageService messageService) {
        this.positionDao = positionDao;
        this.messageService = messageService;
    }

    public List<PositionEntity> getAllPosition() {
        return positionDao.getAllPosition();
    }

    public PositionEntity getPosition(int id) {
        return positionDao.getPosition(id);
    }

    public void addPosition(PositionEntity positionEntity) {
        positionDao.addPosition(positionEntity);
    }

    public void updatePosition(PositionEntity positionEntity) {
        positionDao.updatePosition(positionEntity);
    }

    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }
}
