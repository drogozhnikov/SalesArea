package com.sales.service;

import com.sales.entity.ItemEntity;
import com.sales.repository.ItemDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ItemService {

    private ItemDao itemDao;
    private MessageService messageService;

    public ItemService(ItemDao itemDao, MessageService messageService) {
        this.itemDao = itemDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<ItemEntity> getAllItem() {
        return itemDao.getAllItem();
    }

    @Transactional
    public ItemEntity getItem(int id) {
        return itemDao.getItem(id);
    }

    @Transactional
    public void addItem(ItemEntity itemEntity) {
        itemDao.addItem(itemEntity);
    }

    @Transactional
    public void updateItem(ItemEntity itemEntity) {
        itemDao.updateItem(itemEntity);
    }

    @Transactional
    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }
}
