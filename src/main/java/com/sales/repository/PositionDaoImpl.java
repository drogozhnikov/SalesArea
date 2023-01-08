package com.sales.repository;

import com.sales.entity.PositionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PositionDaoImpl implements PositionDao {

    private SessionFactory sessionFactory;

    public PositionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllPosition() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from PositionEntity").list();
    }

    @Override
    public PositionEntity getPosition(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(PositionEntity.class, id);
    }

    @Override
    public PositionEntity addPosition(PositionEntity positionEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(positionEntity);
        return positionEntity;
    }

    @Override
    public void updatePosition(PositionEntity positionEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(positionEntity);
    }

    @Override
    public void deletePosition(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PositionEntity positionEntity = session.load(PositionEntity.class, id);
        Optional<PositionEntity> optPosition = Optional.ofNullable(positionEntity);
        if (!optPosition.isPresent()) {
            session.delete(positionEntity);
        }
    }
}
