package es.art83.persistence.models.daos.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.art83.persistence.models.daos.CategoryDAO;
import es.art83.persistence.models.daos.DAOFactory;
import es.art83.persistence.models.entities.Category;

public class CategoryDAOJDBCTest {
    private CategoryDAO dao;

    private Category category;

    @BeforeClass
    public static void beforeClass() {
        DAOFactory.setFactory(new DAOJDBCFactory());
        DAOJDBCFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.category = new Category(1, "name", "description");
        dao = DAOFactory.getFactory().getCategoryDAO();
        dao.create(category);
    }

    @Test
    public void testRead() {
        Category categoryBD = dao.read(category.getId());
        assertEquals(category, categoryBD);
    }

    @Test
    public void testUpdateCategory() {
        category.setName("other");
        category.setDescription("other");
        dao.update(category);
        Category categoryBD = dao.read(category.getId());
        assertEquals(category, categoryBD);
    }

    @Test
    public void testDeleteByID() {
        dao.deleteByID(category.getId());
        assertNull(dao.read(category.getId()));
    }

    @Test
    public void testFindAll() {
        dao.create(new Category(2, "2", "2"));
        dao.create(new Category(3, "3", "3"));
        List<Category> categories = dao.findAll();
        assertEquals(3, categories.size());
    }
    
    @After
    public void after(){
        DAOJDBCFactory.dropAndCreateTables();
    }

}
