package es.art83.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.art83.persistence.models.utils.PhoneType;

@NamedQuery(name = Phone.FIND_PHONES_BY_TYPE, query = "SELECT p FROM Phone p WHERE p.phoneType = :"
        + Phone.TYPE)
@Entity
public class Phone {
    public static final String FIND_PHONES_BY_TYPE = "findPhonesByType";

    public static final String TYPE = "type";

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    private int number;

    public Phone(PhoneType phoneType, int number) {
        this.phoneType = phoneType;
        this.number = number;
    }

    public Phone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone [id=" + id + ", phoneType=" + phoneType + ", number=" + number + "]";
    }

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(new Phone(PhoneType.HOME, 666));
        phones.add(new Phone(PhoneType.MOBILE, 999));
        phones.add(new Phone(PhoneType.WORK, 000));
        phones.add(new Phone(PhoneType.HOME, 111));
        phones.add(new Phone(PhoneType.MOBILE, 444));
        phones.add(new Phone(PhoneType.WORK, 222));
        // Create
        entityManager.getTransaction().begin();
        for (Phone phone : phones) {
            entityManager.persist(phone);
        }
        entityManager.getTransaction().commit();
        // find
        Query query= entityManager.createQuery("SELECT p.phoneType FROM Phone p WHERE p.number = 666");
        System.out.println("Query: " + query.getSingleResult());
        
        Query query2 = entityManager.createNamedQuery(Phone.FIND_PHONES_BY_TYPE);
        query2.setParameter(Phone.TYPE, PhoneType.MOBILE);
        System.out.println("Named query: " + query2.getResultList());
    }

}
