package es.art83.persistence.jpa;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "otra_user2")
public class User2 {
    @Id
    @GeneratedValue
    private Integer id;

    private String description = "descipcion";

    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    private java.sql.Date date2 = new java.sql.Date(new Date().getTime());

    @Column(name = "COLUMNA", length = 4, unique = true)
    private String cadena = "1234";

    public User2() {
        super();
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Date getDate2() {
        return date2;
    }

    public void setDate2(java.sql.Date date2) {
        this.date2 = date2;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }


    @Override
    public String toString() {
        return "User2 [id=" + id + ", description=" + description + ", date=" + date + ", date2="
                + date2 + ", cadena=" + cadena + "]";
    }

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BBDD").createEntityManager();
        User2 u1 = new User2();
        u1.setDescription("esta es...");
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();

        // Read
        System.out.println(em.find(User2.class, u1.getId()));
    }

}
