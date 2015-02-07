package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

@Entity
public class User8 {
    @Id
    private Integer id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user8")
    private List<Vehicle> vehicles;

    public User8() {
        super();
    }

    public User8(Integer id, String description) {
        super();
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "User8 [id=" + id + ", description=" + description + ", vehicles=" + vehicles + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User8 u = new User8(1, "Soy u");
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("123", "Soy v", u));
        vehicles.add(new Vehicle("456", "Soy v", u));
        u.setVehicles(vehicles);
        User8 u2 = new User8(2, "Soy u");
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User8.class, 1));
        System.out.println(em.find(User8.class, 2));
        System.out.println(em.find(User8.class, 3));
    }
}
