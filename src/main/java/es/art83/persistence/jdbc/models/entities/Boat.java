package es.art83.persistence.jdbc.models.entities;

public class Boat {
    private Integer id;

    private String description;

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
