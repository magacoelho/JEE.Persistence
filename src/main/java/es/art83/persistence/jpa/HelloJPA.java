package es.art83.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HelloJPA {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User1 u1 = new User1(1, "Sou u1");
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(new User1(2, "Soy dos"));
        em.persist(new User1(3, "Soy tres"));
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(User1.class, 1));
        // Update
        em.getTransaction().begin();
        em.merge(new User1(2, "dos cambiado con update"));
        em.getTransaction().commit();
        // Update2
        em.getTransaction().begin();
        u1.setName("uno, cambiado con set");
        em.getTransaction().commit();
        // Delete
        User1 u3 = em.find(User1.class, 3);
        em.getTransaction().begin();
        em.remove(u3);
        em.getTransaction().commit();
    }
}
