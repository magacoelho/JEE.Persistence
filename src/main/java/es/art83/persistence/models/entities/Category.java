package es.art83.persistence.models.entities;

public class Category {
    public static final String TABLE = "category";

    // Clave primaria
    public static final String ID = "ID";

    private Integer id;

    public static final String NAME = "NAME";

    private String name;

    public static final String DESCRIPTION = "DESCRIPTION";

    private String description;

    // Atributo que no tiene persistencia
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
    public boolean equals(Object obj) {
        assert obj != null;
        Category other = (Category) obj;
        return id.equals(other.id) && name.equals(other.name)
                && description.equals(other.description);
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
