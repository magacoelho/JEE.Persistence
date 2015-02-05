package es.art83.persistence.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = User.TABLE)
public class User {
    public static final String TABLE = "user";

    public static final String ID = "ID";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

    public static final String NAME = "NAME";
    @Column(name = NAME)
    private String name;

    public static final String PASSWORD = "PASSWORD";
    @Column(name = PASSWORD)
    private String password;

    // Relación embebida
    @Embedded
    private Address address;

    public static final String CATEGORY = "CATEGORY_ID";
    // Relación unidireccional: 1:0..1
    // relación mapeada aqui
    // Se aplica cascada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=CATEGORY)
    private Category category;

    // Relación unidireccional: 1:0..n
    // relación mapeada en una tabla de unión
    // Se aplica cascada
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    // Relación bidireccional: 1:0..1
    // relación mapeada en la otra entidad
    @OneToOne(mappedBy = "user")
    private Boat boat;

    // Relación bidireccional: 1:0..n
    // relación mapeada en la otra entidad
    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;

    public User(String name, String password, Address address) {
        assert address != null;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        User other = (User) obj;
        boolean result = id.equals(other.id) && name.equals(other.name)
                && password.equals(other.password) && address.equals(other.address);
        if (category == null) {
            result = result && other.category == null;
        } else {
            result = result && category.equals(other.category);
        }
        return result;

    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", address="
                + address + ", category=" + category + ", phones=" + phones + ", boat=" + boat
                + ", vehicles=" + vehicles + "]";
    }

}
