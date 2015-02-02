package es.art83.bbdd.models.entities;

import java.lang.String;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User2 {
    @Id
    private Integer id;

    private String name;
    
    @Embedded
    private Direction direction;

    public User2() {
    }

    public User2(Integer id, String name, Direction direction) {
        this.id = id;
        this.name = name;
        this.direction = direction;
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

    @Override
    public String toString() {
        return "User2[" + id + ":" + name + "," + direction.toString() + "]";
    }


}
