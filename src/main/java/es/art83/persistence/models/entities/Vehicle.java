package es.art83.persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Vehicle.TABLE)
public class Vehicle {
    public static final String TABLE = "VEHICLE";

    public static final String ID = "ID";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

    public static final String IDENTIFICATION = "IDENTIFICATION";

    @Column(name = IDENTIFICATION)
    private String identification;

    public static final String DESCRIPTION = "DESCRIPTION";

    @Column(name = DESCRIPTION)
    private String description;

    public static final String USER_ID = "USER_ID";

    @ManyToOne
    @JoinColumn(name = USER_ID)
    private User user;

    public Vehicle(String identification, String description) {
        this.identification = identification;
        this.description = description;
    }

    public Vehicle() {
    }

    public Integer getId() {
        return id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", identification=" + identification + ", description="
                + description + ", userId=" + user.getId() + "]";
    }

}
