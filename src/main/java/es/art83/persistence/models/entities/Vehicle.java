package es.art83.persistence.models.entities;

public class Vehicle {
    private Integer id;

    private String identification;

    private String description;
    
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
