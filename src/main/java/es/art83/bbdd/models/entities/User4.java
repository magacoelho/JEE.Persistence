package es.art83.bbdd.models.entities;

import java.lang.String;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User4 {
    @Id
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // La relación se mapea en User4
    private Phone1 phone;

    public User4() {
    }

    public User4(Integer id, String name, Phone1 phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public Phone1 getPhone() {
        return phone;
    }

    public void setPhone(Phone1 phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User4[" + id + ":" + name + "," + phone.toString() + "]";
    }

}
