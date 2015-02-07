package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class User4 {
    @Id
    private Integer id;

    private String description;

    @Embedded
    private Address adress;

    public User4() {
        super();
    }

    public User4(Integer id, String description, Address adress) {
        this.id = id;
        this.description = description;
        this.adress = adress;
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

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User4 [id=" + id + ", description=" + description + ", adress=" + adress + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User4 u = new User4(1, "Sou u", new Address("city", "street"));
        User4 u2 = new User4(2, "Sou u", null);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User4.class, 1));
        System.out.println(em.find(User4.class, 2));
    }
}
