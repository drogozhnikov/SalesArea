package com.sales.service;

import com.sales.entity.Item;
import com.sales.repository.ItemDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemService {

    private ItemDao itemDao;
    private MessageService messageService;

    public ItemService(ItemDao itemDao, MessageService messageService) {
        this.itemDao = itemDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<Item> getAllItem() {
        return itemDao.getAllItem();
    }

    @Transactional
    public Item getItem(int id) {
        return itemDao.getItem(id);
    }

    @Transactional
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Transactional
    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }

    @Transactional
    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }
}
