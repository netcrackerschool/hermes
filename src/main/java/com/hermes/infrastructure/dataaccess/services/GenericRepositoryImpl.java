package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class GenericRepositoryImpl<T extends AbstractPersistentObject> implements GenericRepository<T> {

    protected final Class<? extends T> repositoryType;
    private final SessionFactory sessionFactory;

    public GenericRepositoryImpl(Class<? extends T> repositoryType, SessionFactory sessionFactory) {
        this.repositoryType = repositoryType;
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(T entity) {
        currentSession().delete(entity);
    }

    @Override
    public T find(UUID key) {
        return (T) currentSession().get(repositoryType, key);
    }

    @Override
    public <T> List findAllBySpecification(Specification<T>...specification) {
        Criteria criteria = currentSession().createCriteria(specification[0].getType());
        for(Specification<T> detail : specification) {
            criteria.add(detail.toCriterion());
        }
        return criteria.list();
    }

    @Override
    public List<T> getAll() {
        return currentSession().createCriteria(repositoryType).list();
    }
}