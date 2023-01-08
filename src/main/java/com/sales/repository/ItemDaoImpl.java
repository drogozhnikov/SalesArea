package com.sales.repository;

import com.sales.entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDaoImpl implements ItemDao {

    private SessionFactory sessionFactory;

    public ItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllItem() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from ItemEntity").list();
    }

    @Override
    public ItemEntity getItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(ItemEntity.class, id);
    }

    @Override
    public ItemEntity addItem(ItemEntity itemEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(itemEntity);
        return itemEntity;
    }

    @Override
    public void updateItem(ItemEntity itemEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(itemEntity);
    }

    @Override
    public void deleteItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ItemEntity itemEntity = session.load(ItemEntity.class, id);
        Optional<ItemEntity> optItem = Optional.ofNullable(itemEntity);
        if (!optItem.isPresent()) {
            session.delete(itemEntity);
        }
    }
}
