package es.art83.bbdd.models.daos;

import es.art83.bbdd.models.daos.jpa.DAOJPAFactory;


public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new DAOJPAFactory();
        }
        return factory;
    }

}
