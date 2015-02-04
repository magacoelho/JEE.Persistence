package es.art83.persistence.models.daos.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.art83.persistence.models.daos.DAOFactory;
import es.art83.persistence.models.daos.UserDAO;
import es.art83.persistence.models.entities.Address;
import es.art83.persistence.models.entities.Category;
import es.art83.persistence.models.entities.User;

public class UserDAOJDBCTest {
    private UserDAO dao;

    private User user;

    @BeforeClass
    public static void beforeClass() {
        DAOFactory.setFactory(new DAOJDBCFactory());
        DAOJDBCFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.user = new User("user", "pass", new Address("city", "street"));
        this.user.setCategory(new Category(666, "666", "666"));
        dao = DAOFactory.getFactory().getUserDAO();
        dao.create(user);
    }

    @Test
    public void testRead() {
        assertEquals(user, dao.read(user.getId()));
    }

    @Test
    public void testUpdateCategory() {
        user.setName("other");
        user.setPassword("other");
        user.getAddress().setCity("other");
        user.getAddress().setStreet("other");
        user.setCategory(new Category(2, "2", "2"));
        dao.update(user);
        assertEquals(user, dao.read(user.getId()));
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(user.getId());
        assertNull(dao.read(user.getId()));
        assertNull(DAOFactory.getFactory().getCategoryDAO().read(user.getCategory().getId()));
    }

    @Test
    public void testFindAll() {
        this.user = new User("user", "pass", new Address("city", "street"));
        this.user.setCategory(new Category(333, "333", "333"));
        dao = DAOFactory.getFactory().getUserDAO();
        dao.create(user);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DAOJDBCFactory.dropAndCreateTables();
    }

}
