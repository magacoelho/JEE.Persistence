package es.art83.persistence.models.daos.jpa;

import es.art83.persistence.models.daos.CategoryDao;
import es.art83.persistence.models.entities.Category;

public class CategoryDaoJpa extends GenericDaoJpa<Category, Integer> implements CategoryDao {

    public CategoryDaoJpa() {
        super(Category.class);
    }
}
