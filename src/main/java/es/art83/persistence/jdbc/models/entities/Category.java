package es.art83.persistence.jdbc.models.entities;

public class Category {
    //Clave primaria
    private Integer id;

    private String name;

    private String description;
    
    //Atributo que no tiene persistencia
    private String volatil;

    public Category() {
    }

    public Category(Integer id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolatil() {
        return volatil;
    }

    public void setVolatil(String volatil) {
        this.volatil = volatil;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
