package com.sales.service;

import com.sales.entity.ItemEntity;
import com.sales.repository.ItemDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ItemService {

    private ItemDao itemDao;
    private MessageService messageService;

    public ItemService(ItemDao itemDao, MessageService messageService) {
        this.itemDao = itemDao;
        this.messageService = messageService;
    }

    public List<ItemEntity> getAllItem() {
        return itemDao.getAllItem();
    }

    public ItemEntity getItem(int id) {
        return itemDao.getItem(id);
    }

    public void addItem(ItemEntity itemEntity) {
        itemDao.addItem(itemEntity);
    }

    public void updateItem(ItemEntity itemEntity) {
        itemDao.updateItem(itemEntity);
    }

    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }
}
