package es.art83.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle2 {
    @Id
    @GeneratedValue
    private Integer id;

    private String identification;

    private String description;

    @ManyToOne
    @JoinColumn
    private User8 user8;

    public Vehicle2(String identification, String description, User8 user8) {
        this.identification = identification;
        this.description = description;
        this.user8 = user8;
    }

    public Vehicle2() {
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

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", identification=" + identification + ", description="
                + description + ", user8Id=" + user8.getId() + "]";
    }

}
