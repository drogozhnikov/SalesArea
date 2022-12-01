package com.sales.repository;

import com.sales.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ItemDaoImpl implements ItemDao {

    private SessionFactory sessionFactory;

    public ItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllItem() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Item").list();
    }

    @Override
    public Item getItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Item) session.get(Item.class, id);
    }

    @Override
    public Item addItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(item);
        return item;
    }

    @Override
    public void updateItem(Item item) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(item);
    }

    @Override
    public void deleteItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = session.load(Item.class, id);
        Optional<Item> optItem = Optional.ofNullable(item);
        if (!optItem.isPresent()) {
            session.delete(item);
        }
    }
}
