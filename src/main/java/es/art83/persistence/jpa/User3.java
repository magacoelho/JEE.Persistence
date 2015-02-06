package es.art83.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Persistence;

@Entity
@IdClass(User3PK.class) 
public class User3 {
    @Id
    private int part1;

    @Id
    private int part2;

    private String description;

    public User3() {
        super();
    }

    public User3(int part1, int part2, String description) {
        this.part1 = part1;
        this.part2 = part2;
        this.description = description;
    }

    public int getPart1() {
        return part1;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public int getPart2() {
        return part2;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User3 [part1=" + part1 + ", part2=" + part2 + ", description=" + description + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User3 u = new User3(3,4,"clave compuesta");
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        // Read
        System.out.println(em.find(User3.class,new User3PK(3,4)));
    }


}
