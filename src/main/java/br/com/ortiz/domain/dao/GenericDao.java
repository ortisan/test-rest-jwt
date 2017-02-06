package br.com.ortiz.domain.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    T save(T t);

    T read(PK id);

    T update(T t);

    void delete(T t);

    List<T> findAll();
}