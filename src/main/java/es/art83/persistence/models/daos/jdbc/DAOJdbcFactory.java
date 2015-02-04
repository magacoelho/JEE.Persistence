package es.art83.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.BoatDAO;
import es.art83.persistence.models.daos.CategoryDAO;
import es.art83.persistence.models.daos.DAOFactory;
import es.art83.persistence.models.daos.PhoneDAO;
import es.art83.persistence.models.daos.UserDAO;
import es.art83.persistence.models.daos.VehicleDAO;
import es.art83.persistence.models.entities.Category;
import es.art83.persistence.models.entities.User;

public class DAOJdbcFactory extends DAOFactory {
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
            LogManager.getLogger(DAOJdbcFactory.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DAOJdbcFactory.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, User.TABLE));
            statement.executeUpdate(String.format(DROP_TABLE, Category.TABLE));
            statement.executeUpdate(CategoryDAOJdbc.sqlToCreateTable());
            statement.executeUpdate(UserDAOJdbc.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DAOJdbcFactory.class).error("Drop tables: " + e.getMessage());
        }
    }

    @Override
    public UserDAO getUserDAO() {
        // TODO Auto-generated method stub
        return new UserDAOJdbc();
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryDAOJdbc();
    }

    @Override
    public BoatDAO getBoatDAO() {
        return new BoatDAOJdbc();
    }

    @Override
    public VehicleDAO getVehicleDAO() {
        return new VehicleDAOJdbc();
    }

    @Override
    public PhoneDAO getPhoneDAO() {
        return new PhoneDAOJdbc();
    }

}
