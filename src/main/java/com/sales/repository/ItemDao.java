package com.sales.repository;

import com.sales.entity.ItemEntity;

import java.util.List;

public interface ItemDao {

    public List<ItemEntity> getAllItem();

    public ItemEntity getItem(int id);

    public ItemEntity addItem(ItemEntity itemEntity);

    public void updateItem(ItemEntity itemEntity);

    public void deleteItem(int id);
}
