package es.art83.persistence.models.daos.jdbc;

import es.art83.persistence.models.daos.CategoryDAO;
import es.art83.persistence.models.daos.DAOFactory;
import es.art83.persistence.models.daos.UserDAO;

public class DAOJDBCFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryDAOJDBC();
    }

}
