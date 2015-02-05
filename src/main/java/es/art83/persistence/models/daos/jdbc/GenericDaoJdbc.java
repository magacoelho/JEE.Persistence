package es.art83.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.art83.persistence.models.daos.GenericDao;

public abstract class GenericDaoJdbc<T, ID> implements GenericDao<T, ID> {

    protected static final String SQL_SELECT_ID = "SELECT * FROM %s WHERE ID=%d";

    protected static final String SQL_SELECT_ALL = "SELECT * FROM %s";

    protected static final String SQL_DELETE_ID = "DELETE FROM %s WHERE ID=%d";

    protected static final String SQL_SELECT_LAST_ID = "SELECT LAST_INSERT_ID()";

    private Logger log = LogManager.getLogger(GenericDaoJdbc.class);

    public ResultSet query(String sql) {
        try {
            Statement statement = DaoJdbcFactory.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            this.log.debug("Query: " + sql);
            return resultSet;
        } catch (SQLException e) {
            this.log.error("Query SQL: ---" + sql + "---");
            this.log.error(e.getMessage());
        }
        return null;
    }

    public void updateSql(String sql) {
        try {
            Statement statement = DaoJdbcFactory.getConnection().createStatement();
            statement.executeUpdate(sql);
            this.log.debug("UpdateSql: " + sql);
        } catch (SQLException e) {
            this.log.error("Update SQL: ---" + sql + "---");
            this.log.error(e.getMessage());
        }
    }

    public int autoId() {
        ResultSet resulSet = this.query(SQL_SELECT_LAST_ID);
        try {
            resulSet.next();
            return resulSet.getInt(1);
        } catch (SQLException e) {
            this.log.error("Query SQL: ---" + SQL_SELECT_LAST_ID + "---");
            this.log.error(e.getMessage());
        }
        return -1;
    }

}
