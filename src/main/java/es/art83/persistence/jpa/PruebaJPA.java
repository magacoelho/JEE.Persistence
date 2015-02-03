package es.art83.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.persistence.jpa.models.entities.Address;
import es.art83.persistence.jpa.models.entities.User;

public class PruebaJPA {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        Address address = new Address("Madrid", "Gran Vía");
        User u = new User("Jorge", "pass", address);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
    }
}
