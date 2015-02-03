package es.art83.persistence.jpa.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Boat {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @OneToOne
    @JoinColumn
    private User user;

    public Boat(String description, User user) {
        super();
        this.description = description;
        this.user = user;
    }

    public Boat() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

}
