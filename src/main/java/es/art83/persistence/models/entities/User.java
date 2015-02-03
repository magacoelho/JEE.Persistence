package es.art83.persistence.models.entities;

import java.util.List;

public class User {
    private int id;

    private String name;

    private String password;

    //Relación embebida
    private Address detail;

    //Relación unidireccional: 1:1
    //relación mapeada aqui
    //Se aplica cascada
    private Phone mainPhone;

    //Relación unidireccional: 1:n
    //relación mapeada en la otra entidad
    //Se aplica cascada
    private List<Phone> phones;

    //Relación bidireccional: 1:1
    //relación mapeada en la otra entidad
    private Vehicle mainVehicle;

    //Relación bidireccional: 1:n
    //relación mapeada en la otra entidad
    private List<Vehicle> vehicles;

    public User(String name, String password, Address detail) {
        super();
        this.name = name;
        this.password = password;
        this.detail = detail;
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

    public Address getDetail() {
        return detail;
    }

    public void setDetail(Address detail) {
        this.detail = detail;
    }

    public Phone getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(Phone mainPhone) {
        this.mainPhone = mainPhone;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Vehicle getMainVehicle() {
        return mainVehicle;
    }

    public void setMainVehicle(Vehicle mainVehicle) {
        this.mainVehicle = mainVehicle;
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
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", detail="
                + detail + ", mainPhone=" + mainPhone + ", phones=" + phones + ", mainVehicle="
                + mainVehicle + ", vehicles=" + vehicles + "]";
    }

    
}
