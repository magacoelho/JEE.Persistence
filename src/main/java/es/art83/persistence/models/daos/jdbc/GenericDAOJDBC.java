package es.art83.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.GenericDAO;

public abstract class GenericDAOJDBC<T, ID> implements GenericDAO<T, ID> {

    protected static final String SQL_SELECT_ID = "SELECT * FROM %s WHERE ID=%d";

    protected static final String SQL_SELECT_ALL = "SELECT * FROM %s";

    protected static final String SQL_DELETE_ID = "DELETE FROM %s WHERE ID=%d";

    protected static final String SQL_SELECT_LAST_ID = "SELECT LAST_INSERT_ID()";

    public void logError(String msg) {
        LogManager.getLogger(this.getClass().getName()).error(msg);
    }

    public ResultSet query(String sql) {
        try {
            Statement statement = DAOJDBCFactory.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            LogManager.getLogger(this.getClass().getName()).debug("Query: " + sql);
            return resultSet;
        } catch (SQLException e) {
            this.logError("Query SQL: ---" + sql + "---");
            this.logError(e.getMessage());
        }
        return null;
    }

    public void updateSql(String sql) {
        try {
            Statement statement = DAOJDBCFactory.getConnection().createStatement();
            statement.executeUpdate(sql);
            LogManager.getLogger(this.getClass().getName()).debug("UpdateSql: " + sql);
        } catch (SQLException e) {
            this.logError("Update SQL: ---" + sql + "---");
            this.logError(e.getMessage());
        }
    }

    public int autoId() {
        ResultSet resulSet = this.query(SQL_SELECT_LAST_ID);
        try {
            resulSet.next();
            return resulSet.getInt(1);
        } catch (SQLException e) {
            this.logError("Query SQL: ---" + SQL_SELECT_LAST_ID + "---");
            this.logError(e.getMessage());
        }
        return -1;
    }

}
