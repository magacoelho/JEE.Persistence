package es.art83.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.GenericDAO;

public abstract class GenericDAOJDBC<T, ID> implements GenericDAO<T, ID> {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/jee";

    private static final String USER = "root";

    private static final String PASS = "";

    protected static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    protected static final String SELECT = "SELECT * FROM %s WHERE ID=%d";

    protected static final String SELECT_ALL = "SELECT * FROM %s";

    protected static final String DELETE = "DELETE FROM %s WHERE ID=%d";

    private static Connection connection;

    public void logError(String msg) {
        LogManager.getLogger(this.getClass().getName()).error(msg);
    }

    public Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(0))
                Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            this.logError("Problemas con el driver");
            this.logError(e.getMessage());
        } catch (SQLException e) {
            this.logError("Problemas con la BD");
            this.logError(e.getMessage());
        }

        return connection;
    }

    public ResultSet query(String sql) {
        try {
            Statement statement = this.getConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            this.logError("Query SQL: " + sql);
            this.logError(e.getMessage());
        }
        return null;
    }

    public boolean updateSql(String sql) {
        try {
            Statement statement = this.getConnection().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            this.logError("Update SQL: " + sql);
            this.logError(e.getMessage());
        }
        return false;
    }

}
