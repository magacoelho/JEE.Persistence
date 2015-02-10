package es.art83.persistence.models.daos.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.art83.persistence.models.daos.DaoFactory;
import es.art83.persistence.models.daos.UserDao;
import es.art83.persistence.models.entities.Address;
import es.art83.persistence.models.entities.Category;
import es.art83.persistence.models.entities.User;

public class UserDaoJdbcTest {
    private UserDao dao;

    private User user;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJdbcFactory());
        DaoJdbcFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.user = new User("user", "pass", new Address("city", "street"));
        this.user.setCategory(new Category(666, "666", "666"));
        dao = DaoFactory.getFactory().getUserDao();
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
        user.getCategory().setName("other");
        user.getCategory().setDescription("other");
        dao.update(user);
        assertEquals(user, dao.read(user.getId()));
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(user.getId());
        assertNull(dao.read(user.getId()));
        assertNull(DaoFactory.getFactory().getCategoryDao().read(user.getCategory().getId()));
    }

    @Test
    public void testFindAll() {
        this.user = new User("user", "pass", new Address("city", "street"));
        this.user.setCategory(new Category(333, "333", "333"));
        dao = DaoFactory.getFactory().getUserDao();
        dao.create(user);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJdbcFactory.dropAndCreateTables();
    }

}
