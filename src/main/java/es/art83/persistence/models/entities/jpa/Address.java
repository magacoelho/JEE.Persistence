package es.art83.persistence.models.entities.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    public static final String CITY = "CITY";

    private String city;

    public static final String STREET = "STREET";

    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        Address other = (Address) obj;
        return city.equals(other.city) && street.equals(other.street);
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + "]";
    }

}
