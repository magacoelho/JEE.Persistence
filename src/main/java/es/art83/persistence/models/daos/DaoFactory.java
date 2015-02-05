package es.art83.persistence.models.daos;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract UserDao getUserDao();

    public abstract CategoryDao getCategoryDao();

    public abstract BoatDao getBoatDao();

    public abstract VehicleDao getVehicleDao();

    public abstract PhoneDao getPhoneDao();

}
