package es.art83.bbdd.models.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Direction {
    private String Street;

    private int number;

    public Direction() {
    }

    public Direction(String street, int number) {
        super();
        Street = street;
        this.number = number;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Direction[" + Street + "," + number + "]";
    }

}
