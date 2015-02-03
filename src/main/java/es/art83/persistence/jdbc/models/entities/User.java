package es.art83.persistence.jdbc.models.entities;

import java.util.List;

public class User {

    private int id;

    private String name;

    private String password;

    // Relación embebida
    private Address address;

    // Relación unidireccional: 1:1
    // relación mapeada aqui
    // Se aplica cascada
    private Category category;

    // Relación unidireccional: 1:n
    // relación mapeada en una tabla de unión
    // Se aplica cascada
    private List<Phone> phones;

    // Relación bidireccional: 1:1
    // relación mapeada en la otra entidad
    private Boat boat;

    // Relación bidireccional: 1:n
    // relación mapeada en la otra entidad
   private List<Vehicle> vehicles;

    public User(String name, String password, Address address) {
        super();
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", address="
                + address + ", category=" + category + ", phones=" + phones + ", boat=" + boat
                + ", vehicles=" + vehicles + "]";
    }

}
