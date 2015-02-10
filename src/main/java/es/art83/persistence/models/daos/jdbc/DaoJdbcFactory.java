package es.art83.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.BoatDao;
import es.art83.persistence.models.daos.CategoryDao;
import es.art83.persistence.models.daos.DaoFactory;
import es.art83.persistence.models.daos.PhoneDao;
import es.art83.persistence.models.daos.UserDao;
import es.art83.persistence.models.daos.VehicleDao;
import es.art83.persistence.models.entities.Category;
import es.art83.persistence.models.entities.User;

public class DaoJdbcFactory extends DaoFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/jee";

    private static final String USER = "root";

    private static final String PASS = "";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(0)) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, User.TABLE));
            statement.executeUpdate(String.format(DROP_TABLE, Category.TABLE));
            statement.executeUpdate(CategoryDaoJdbc.sqlToCreateTable());
            statement.executeUpdate(UserDaoJdbc.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error("Drop tables: " + e.getMessage());
        }
    }

    @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserDaoJdbc();
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoJdbc();
    }

    @Override
    public BoatDao getBoatDao() {
        return new BoatDaoJdbc();
    }

    @Override
    public VehicleDao getVehicleDao() {
        return new VehicleDaoJdbc();
    }

    @Override
    public PhoneDao getPhoneDao() {
        return new PhoneDaoJdbc();
    }

}
