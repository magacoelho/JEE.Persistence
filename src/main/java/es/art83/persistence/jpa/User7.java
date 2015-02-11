package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.art83.persistence.models.utils.PhoneType;

@Entity
public class User7 {
    @Id
    private Integer id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone2> phones;

    public User7() {
        super();
    }

    public User7(Integer id, String description, List<Phone2> phones) {
        super();
        this.id = id;
        this.description = description;
        this.phones = phones;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User7 [id=" + id + ", description=" + description + ", phones=" + phones + "]";
    }

    public List<Phone2> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone2> phones) {
        this.phones = phones;
    }

    public static void main(String[] args) {
        JpaFactory.dropAndCreateTables();
        EntityManager em = JpaFactory.getEntityManagerFactory().createEntityManager();
        List<Phone2> phones = new ArrayList<Phone2>();
        phones.add(new Phone2(PhoneType.HOME, 666));
        phones.add(new Phone2(PhoneType.MOBILE, 999));
        phones.add(new Phone2(PhoneType.WORK, 000));
        User7 u = new User7(1, "Soy u", phones);
        User7 u2 = new User7(2, "Soy u", null);
        // Create
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        // find
        System.out.println(em.find(User7.class, 1));
        System.out.println(em.find(User7.class, 2));
        System.out.println(em.find(User7.class, 3));
    }
}
