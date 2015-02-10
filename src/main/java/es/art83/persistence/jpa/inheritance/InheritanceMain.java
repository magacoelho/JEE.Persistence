package es.art83.persistence.jpa.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class InheritanceMain {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new C1A(1,1,1,1));
        entityManager.persist(new C1A(2,2,2,2));
        entityManager.persist(new C1B(3,3,3,3));
        entityManager.persist(new C1B(4,4,4,4));
        entityManager.getTransaction().commit();
    }

}
