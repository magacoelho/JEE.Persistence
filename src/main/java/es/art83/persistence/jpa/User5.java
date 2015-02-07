package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

@Entity
public class User5 {
    @Id
    private Integer id;

    private String description;

    @OneToOne
    private Category category;

    public User5() {
        super();
    }

    public User5(Integer id, String description, Category category) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User5 [id=" + id + ", description=" + description + ", category=" + category + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User5 u = new User5(1, "Sou u", new Category("description"));
        User5 u2 = new User5(2, "Sou u", null);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User5.class, 1));
        System.out.println(em.find(User5.class, 2));
    }
}
