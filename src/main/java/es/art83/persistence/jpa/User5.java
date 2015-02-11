package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User5 {
    @Id
    private Integer id;

    private String description;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private Category2 category;

    public User5() {
        super();
    }

    public User5(Integer id, String description, Category2 category) {
        super();
        this.id = id;
        this.description = description;
        this.category = category;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category2 getCategory() {
        return category;
    }

    public void setCategory(Category2 category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User5 [id=" + id + ", description=" + description + ", category=" + category + "]";
    }

    public static void main(String[] args) {
        JpaFactory.dropAndCreateTables();
        EntityManager em = JpaFactory.getEntityManagerFactory().createEntityManager();
        User5 u = new User5(1, "Soy u", new Category2("categoria"));
        User5 u2 = new User5(2, "Soy u", null);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User5.class, 1));
        System.out.println(em.find(User5.class, 2));
        System.out.println(em.find(User5.class, 3));
    }
}
