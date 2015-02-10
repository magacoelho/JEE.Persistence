package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

@Entity
public class User6 {
    @Id
    private Integer id;

    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user6")
    private Boat2 boat;

    public User6() {
        super();
    }

    public User6(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    public Boat2 getBoat() {
        return boat;
    }

    public void setBoat(Boat2 boat) {
        this.boat = boat;
    }

    @Override
    public String toString() {
        return "User6 [id=" + id + ", description=" + description + ", boat=" + boat + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User6 u = new User6(1, "Soy u");
        Boat2 boat = new Boat2("boat", u);
        u.setBoat(boat);
        User6 u2 = new User6(2, "Soy u");
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User6.class, 1));
        System.out.println(em.find(User6.class, 2));
        System.out.println(em.find(User6.class, 3));
    }
}
