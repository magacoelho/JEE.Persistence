package es.art83.bbdd.basic;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.bbdd.models.entities.User;

public class HelloJPA {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User u1 = new User(1, "Sou u1");
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(new User(2, "Soy dos"));
        em.persist(new User(3, "Soy tres"));
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(User.class, 1));
        // Update
        em.getTransaction().begin();
        em.merge(new User(2, "dos cambiado con update"));
        em.getTransaction().commit();
        // Update2
        em.getTransaction().begin();
        u1.setName("uno, cambiado con set");
        em.getTransaction().commit();
        // Delete
        User u3 = em.find(User.class, 3);
        em.getTransaction().begin();
        em.remove(u3);
        em.getTransaction().commit();
    }
}
