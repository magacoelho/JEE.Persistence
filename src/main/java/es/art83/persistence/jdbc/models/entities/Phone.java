package es.art83.persistence.jdbc.models.entities;

public class Phone {
    private Integer id;

    private PhoneType phoneType;

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
