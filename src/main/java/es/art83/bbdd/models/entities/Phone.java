package es.art83.bbdd.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.art83.bbdd.models.utils.PhoneType;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private int id;

    private int number;

    @Enumerated(EnumType.STRING) //Opcional
    private PhoneType phoneType;

    public Phone() {
        super();
    }

    public Phone(int number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return this.phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "Phone[" + id + ":" + number + "," + phoneType + "]";
    }

}
