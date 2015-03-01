package es.art83.persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.art83.persistence.models.utils.PhoneType;

@Entity
public class Phone {
    public static final String TABLE = "phone";

    public static final String ID = "ID";

    @Id
    @GeneratedValue
    private Integer id;

    public static final String PHONE_TYPE = "PHONETYPE";

    @Enumerated(EnumType.STRING) // Opcional
    private PhoneType phoneType;

    public static final String NUMBER = "NUMBER";

    private int number;

    public Phone(PhoneType phoneType, int number) {
        this.phoneType = phoneType;
        this.number = number;
    }

    public Phone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone [id=" + id + ", phoneType=" + phoneType + ", number=" + number + "]";
    }

}
