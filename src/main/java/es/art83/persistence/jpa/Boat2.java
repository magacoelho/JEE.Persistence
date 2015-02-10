package es.art83.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Boat2 {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @OneToOne
    @JoinColumn
    private User6 user6;

    public Boat2(String description, User6 user6) {
        super();
        this.description = description;
        this.user6 = user6;
    }

    public Boat2() {
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User6 getUser() {
        return user6;
    }

    public void setUser(User6 user6) {
        this.user6 = user6;
    }

    @Override
    public String toString() {
        return "Boat [id=" + id + ", description=" + description + ", user6=" + user6 + "]";
    }

}
