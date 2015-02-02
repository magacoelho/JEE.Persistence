package es.art83.bbdd.basic;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.bbdd.models.entities.Phone;
import es.art83.bbdd.models.entities.User4;
import es.art83.bbdd.models.utils.PhoneType;

public class AsociacionesUnidireccional {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User4 u1 = new User4(101, "soy uno", new Phone(222, PhoneType.MOBILE));
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();

        // Read
        System.out.println(em.find(User4.class, 101));
    }
}
