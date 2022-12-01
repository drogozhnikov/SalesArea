package com.sales.repository;

import com.sales.entity.Item;

import java.util.List;

public interface ItemDao {

    public List<Item> getAllItem();

    public Item getItem(int id);

    public Item addItem(Item item);

    public void updateItem(Item item);

    public void deleteItem(int id);
}
