package es.art83.bbdd.models.entities;

import java.lang.String;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User3 {
    @Id
    private Integer id;

    private String name;

    @ElementCollection
    @CollectionTable
    private List<Direction> addresses;

    public User3() {
    }

    public User3(Integer id, String name, List<Direction> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
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

    public List<Direction> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Direction> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User3[" + id + ":" + name + "," + addresses.toString() + "]";
    }

}
