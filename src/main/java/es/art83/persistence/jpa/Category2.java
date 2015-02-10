package es.art83.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category2 {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    public Category2() {
    }

    public Category2(String description) {
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", description=" + description + "]";
    }

}
