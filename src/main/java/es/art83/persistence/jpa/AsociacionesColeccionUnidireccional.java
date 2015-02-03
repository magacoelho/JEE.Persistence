package es.art83.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.bbdd.models.entities.Phone1;
import es.art83.bbdd.models.entities.User5;
import es.art83.persistence.models.utils.PhoneType;

public class AsociacionesColeccionUnidireccional {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        List<Phone1> phones = new ArrayList<>();
        phones.add(new Phone1(111, PhoneType.HOME));
        phones.add(new Phone1(222, PhoneType.MOBILE));
        User5 u1 = new User5(101, "soy uno", phones);
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();
        
        //vamos a eliminar un miembro de la colección
        em.getTransaction().begin();
        phones.remove(0);
        em.merge(u1);
        em.getTransaction().commit();
        

        // Read
        System.out.println(em.find(User5.class, 101));
    }
}
