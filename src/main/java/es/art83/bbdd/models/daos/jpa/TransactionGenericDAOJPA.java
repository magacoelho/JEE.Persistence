package es.art83.bbdd.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import es.art83.bbdd.models.daos.DAOFactory;
import es.art83.bbdd.models.daos.TransactionGenericDAO;


public class TransactionGenericDAOJPA<T, ID> implements TransactionGenericDAO<T, ID> {
    private Class<T> persistentClass;

    protected EntityManager entityManager;

    public TransactionGenericDAOJPA(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.entityManager = ((DAOJPAFactory) DAOFactory.getFactory()).getEm();
    }

    @Override
    public void create(T entity) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.persist(entity);
            LogManager.getLogger(TransactionGenericDAOJPA.class).info(
                    "create(Transaccion abierta): " + entity);
        } else {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(TransactionGenericDAOJPA.class).info(
                        "create(Transaccion cerrada): " + entity);
            } catch (Exception e) {
                LogManager.getLogger(TransactionGenericDAOJPA.class).error("create: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public T read(ID id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    public void update(T entity) {
        LogManager.getLogger(TransactionGenericDAOJPA.class).info("update: " + entity);
        if (entityManager.getTransaction().isActive())
            entityManager.merge(entity);
        else {
            entityManager.getTransaction().begin();
            try {
                entityManager.merge(entity);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                LogManager.getLogger(TransactionGenericDAOJPA.class).error("update: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            }
        }
    }

    // entity debe estar en estado de "Managed"
    @Override
    public void delete(T entity) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.remove(entity);
            LogManager.getLogger(TransactionGenericDAOJPA.class).info(
                    "delete(Transaccion abierta): " + entity);
        } else {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(TransactionGenericDAOJPA.class).info(
                        "delete(Transaccion cerrada): " + entity);
            } catch (Exception e) {
                LogManager.getLogger(TransactionGenericDAOJPA.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public void deleteByID(ID id) {
        T entity = this.read(id);
        if (entity != null)
            this.delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find(String[] attributes, String[] values, String order, int index, int size) {
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // Se configuran los predicados, combinados por AND
        Predicate predicate = criteriaBuilder.conjunction();
        for (int i = 0; i < attributes.length; i++) {
            Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class),
                    values[i]);
            // Predicate sig =
            // criteriaBuilder.like(root.get(attributes[i]).as(String.class),
            // values[i]);
            predicate = criteriaBuilder.and(predicate, sig);
        }
        // Se establece el WHERE
        criteriaQuery.where(predicate);

        // Se establece el orden
        if (order != null && !order.isEmpty())
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order)));

        // Se crea el resultado
        if (index >= 0 && size > 0) {
            TypedQuery<T> tq = entityManager.createQuery(criteriaQuery);
            tq.setFirstResult(index);
            tq.setMaxResults(size); // Se realiza la query
            return tq.getResultList();
        } else {
            // Se realiza la query
            Query query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    @Override
    public List<T> find(String[] attributes, String[] values) {
        return this.find(attributes, values, null, -1, -1);
    }

    @Override
    public List<T> findAll() {
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // No existen predicados

        // Se realiza la query
        TypedQuery<T> tq = entityManager.createQuery(criteriaQuery);
        tq.setFirstResult(0); // El primero es 0
        tq.setMaxResults(0); // Se realiza la query, se buscan todos
        return tq.getResultList();

        // Equivalente a return this.find(new String[0], new String[0], null, 0,
        // 0);
    }

    @Override
    public void begin() {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
            LogManager.getLogger(TransactionGenericDAOJPA.class).info("Transaccion abierta");
        }
    }

    @Override
    public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
            LogManager.getLogger(TransactionGenericDAOJPA.class).info("Transaccion cerrada");
        }
    }

    @Override
    public void rollback() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }

}
