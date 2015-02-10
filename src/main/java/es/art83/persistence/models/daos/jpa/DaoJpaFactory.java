package es.art83.persistence.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.BoatDao;
import es.art83.persistence.models.daos.CategoryDao;
import es.art83.persistence.models.daos.DaoFactory;
import es.art83.persistence.models.daos.PhoneDao;
import es.art83.persistence.models.daos.UserDao;
import es.art83.persistence.models.daos.VehicleDao;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoJpa();
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoJpa();
    }

    @Override
    public BoatDao getBoatDao() {
        return new BoatDaoJpa();
    }

    @Override
    public VehicleDao getVehicleDao() {
        return new VehicleDaoJpa();
    }

    @Override
    public PhoneDao getPhoneDao() {
        return new PhoneDaoJpa();
    }

}
