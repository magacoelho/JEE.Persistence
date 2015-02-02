package es.art83.bbdd.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.art83.bbdd.models.daos.DAOFactory;

public class DAOJPAFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "BBDD";

    private EntityManager em;

    public DAOJPAFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
        LogManager.getLogger(DAOJPAFactory.class).info("createEntityManager");
    }

    public EntityManager getEm() {
        if (!em.isOpen()) {
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
            LogManager.getLogger(DAOJPAFactory.class).info("createEntityManager");
        }
        return em;
    }

}
