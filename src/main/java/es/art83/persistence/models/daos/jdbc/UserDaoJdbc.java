package es.art83.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.art83.persistence.models.daos.DaoFactory;
import es.art83.persistence.models.daos.UserDao;
import es.art83.persistence.models.entities.jdbc.Address;
import es.art83.persistence.models.entities.jdbc.Category;
import es.art83.persistence.models.entities.jdbc.User;

public class UserDaoJdbc extends GenericDaoJdbc<User, Integer> implements UserDao {

    private Logger log = LogManager.getLogger(UserDaoJdbc.class);

    private User create(ResultSet resultSet) {
        User user;
        try {
            if (resultSet != null && resultSet.next()) {
                user = new User(resultSet.getString(User.NAME), resultSet.getString(User.PASSWORD),
                        new Address(resultSet.getString(Address.CITY),
                                resultSet.getString(Address.STREET)));
                user.setId(resultSet.getInt(User.ID));
                // Reconstruir Category
                Integer categoryId = resultSet.getInt(User.CATEGORY);
                if (categoryId > 0) {
                    Category category = DaoFactory.getFactory().getCategoryDao().read(categoryId);
                    user.setCategory(category);
                }
                return user;
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255), %s VARCHAR(255), %s VARCHAR(255), %s INT, PRIMARY KEY (%s), "
            + "FOREIGN KEY(%s) REFERENCES %s(ID) )";

    public static String sqlToCreateTable() {
        return String
                .format(SQL_CREATE_TABLE, User.TABLE, User.ID, User.NAME, User.PASSWORD, Address.CITY,
                        Address.STREET, User.CATEGORY, User.ID, User.CATEGORY, Category.TABLE);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s','%s','%s','%s',%d)";

    @Override
    public void create(User user) {
        assert user.getAddress() != null;
        Integer categoriaId = null;
        if (user.getCategory() != null) {
            DaoFactory.getFactory().getCategoryDao().create(user.getCategory());
            categoriaId = user.getCategory().getId();
        }
        this.updateSql(String.format(SQL_INSERT, User.TABLE, User.NAME, User.PASSWORD, Address.CITY,
                Address.STREET, User.CATEGORY, user.getName(), user.getPassword(), user
                        .getAddress().getCity(), user.getAddress().getStreet(), categoriaId));
        user.setId(this.autoId());
    }

    @Override
    public User read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, User.TABLE, id));
        return this.create(resultSet);
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', %s=%d WHERE ID=%d";

    @Override
    public void update(User user) {
        assert user.getAddress() != null;
        Integer categoryId, oldCategoryId = null;
        if (user.getCategory() == null) {
            User oldUser = this.read(user.getId());
            if (oldUser.getCategory() != null) {
                oldCategoryId = oldUser.getCategory().getId();
            }
            categoryId = null;
        } else {
            categoryId = user.getCategory().getId();
            if (DaoFactory.getFactory().getCategoryDao().read(categoryId) == null) {
                DaoFactory.getFactory().getCategoryDao().create(user.getCategory());
            } else {
                DaoFactory.getFactory().getCategoryDao().update(user.getCategory());
            }
        }
        this.updateSql(String.format(SQL_UPDATE, User.TABLE, User.NAME, user.getName(), User.PASSWORD,
                user.getPassword(), Address.CITY, user.getAddress().getCity(), Address.STREET, user
                        .getAddress().getStreet(), User.CATEGORY, categoryId, user.getId()));
        if (oldCategoryId != null) {
            DaoFactory.getFactory().getCategoryDao().deleteById(oldCategoryId);
        }
    }

    @Override
    public void deleteById(Integer id) {
        User userBD = this.read(id);
        if (userBD != null) {
            Integer categoryId = null;
            if (userBD.getCategory() != null) {
                categoryId = userBD.getCategory().getId();
            }
            this.updateSql(String.format(SQL_DELETE_ID, User.TABLE, id));
            if (categoryId != null) {
                DaoFactory.getFactory().getCategoryDao().deleteById(userBD.getCategory().getId());
            }

        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, User.TABLE));
        User user = this.create(resultSet);
        while (user != null) {
            list.add(user);
            user = this.create(resultSet);
        }
        return list;
    }

}
