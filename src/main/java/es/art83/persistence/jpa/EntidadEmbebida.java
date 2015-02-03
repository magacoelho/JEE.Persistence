package es.art83.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.bbdd.models.entities.Direction;
import es.art83.bbdd.models.entities.User2;

public class EntidadEmbebida {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User2 u1 = new User2(1, "Sou u1", new Direction("calle", 666));
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();
        
        // Read
        System.out.println(em.find(User2.class, 1));
    }
}
