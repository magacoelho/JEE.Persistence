package es.art83.bbdd.models.entities;

import java.lang.String;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User5 {
    @Id
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn En lugar de crear una tabla de unión (user4_phone), se mapea en la tabla "phone"
    private List<Phone1> phones;

    public User5() {
    }

    public User5(Integer id, String name, List<Phone1> phones) {
        this.id = id;
        this.name = name;
        this.phones = phones;
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

    public List<Phone1> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone1> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User4[" + id + ":" + name + "," + phones.toString() + "]";
    }

}
