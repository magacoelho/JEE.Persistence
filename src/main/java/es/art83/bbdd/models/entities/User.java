package es.art83.bbdd.models.entities;

import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
    @Id
    private Integer id;

    private String name;
    
    @Transient //No persistente
    private String volatil;

    public User() {
        super();
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolatil() {
        return volatil;
    }

    public void setVolatil(String volatil) {
        this.volatil = volatil;
    }

    @Override
    public String toString() {
        return "User[" + id + ":" + name + "]";
    }

}
