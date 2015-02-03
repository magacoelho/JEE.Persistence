package es.art83.persistence.models.daos;

import java.util.List;

public interface GenericDAO<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    void deleteByID(ID id);

    List<T> findAll();

}
