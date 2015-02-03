package es.art83.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.bbdd.models.entities.Direction;
import es.art83.bbdd.models.entities.User3;

public class Colecciones {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        List<Direction> addresses = new ArrayList<>();
        addresses.add(new Direction("dir1", 111));
        addresses.add(new Direction("dir2", 222));
        addresses.add(new Direction("dir3", 333));
        User3 u1 = new User3(1, "soy uno", addresses);
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();

        // Read
        System.out.println(em.find(User3.class, 1));
    }
}
