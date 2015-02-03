package es.art83.persistence.models.entities;

public class User {
    private int id;

    private String name;

    private String password;

    private int level;

    private UserDetail detail;

    public User(int id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setLevel(1);
    }

    public User() {
        this(0, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public UserDetail getDetail() {
        return this.detail;
    }

    public void setDetail(UserDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        String d = ", detail=(null)";
        if (this.detail != null)
            d = ", detail=(" + this.detail.toString() + ")";
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", level=" + level
                + d + "]";
    }

}
