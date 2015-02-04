package es.art83.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import es.art83.persistence.models.entities.Address;
import es.art83.persistence.models.entities.Phone;
import es.art83.persistence.models.entities.User;
import es.art83.persistence.models.utils.PhoneType;

public class PruebaJPA {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        Address address = new Address("Madrid", "Gran Vía");
        User u = new User("Jorge", "pass", address);
        List<Phone> phones= new ArrayList<Phone>();
        phones.add(new Phone(PhoneType.HOME,666666666));
        phones.add(new Phone(PhoneType.HOME,234));
        u.setPhones(phones);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
        
    }
}
