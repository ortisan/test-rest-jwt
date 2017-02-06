package br.com.ortiz.domain.dao;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoJpaImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    private Class<T> entityClass;

    @Inject
    private EntityManager entityManager;

    public GenericDaoJpaImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public T save(T object) {
        this.entityManager.persist(object);
        return object;
    }

    public T read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    public T update(T object) {
        return this.entityManager.merge(object);
    }

    public void delete(T object) {
        object = this.entityManager.merge(object);
        this.entityManager.remove(object);
    }

    public List<T> findAll() {
        return entityManager
                .createQuery(String.format("Select obj from %s obj", entityClass.getSimpleName()), entityClass)
                .getResultList();
    }
}