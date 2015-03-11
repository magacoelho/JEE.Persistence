package es.art83.persistence.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.Embeddable;

@Embeddable
public class Address2 implements Serializable {  
    private static final long serialVersionUID = 1L;

    private String city;

    private String street;

    public Address2() {
    }

    public Address2(String city, String street) {
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
