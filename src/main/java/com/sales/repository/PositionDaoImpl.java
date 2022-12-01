package com.sales.repository;

import com.sales.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PositionDaoImpl implements PositionDao {

    private SessionFactory sessionFactory;

    public PositionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllPosition() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Position").list();
    }

    @Override
    public Position getPosition(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Position) session.get(Position.class, id);
    }

    @Override
    public Position addPosition(Position position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(position);
        return position;
    }

    @Override
    public void updatePosition(Position position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(position);
    }

    @Override
    public void deletePosition(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Position position = session.load(Position.class, id);
        Optional<Position> optPosition = Optional.ofNullable(position);
        if (!optPosition.isPresent()) {
            session.delete(position);
        }
    }
}
