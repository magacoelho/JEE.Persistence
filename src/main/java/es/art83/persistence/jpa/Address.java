package es.art83.persistence.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private String city;

    private String street;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + "]";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStret() {
        return street;
    }

    public void setStret(String street) {
        this.street = street;
    }
}
