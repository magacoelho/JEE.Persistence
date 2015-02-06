package es.art83.persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name=Boat.TABLE)
public class Boat {
    public static final String TABLE = "boat";

    public static final String ID = "ID";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

    public static final String DESCRIPTION = "DESCRIPTION";

    @Column(name = DESCRIPTION)
    private String description;

    public static final String USER = "USER_ID";

    @OneToOne
    @JoinColumn(name = USER)
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
