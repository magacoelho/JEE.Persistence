package es.art83.persistence.jpa.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class C1 {
    @Id
    private int id;

    private int atr1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtr1() {
        return atr1;
    }

    public void setAtr1(int atr1) {
        this.atr1 = atr1;
    }

    public C1(int id, int atr1) {
        this.id = id;
        this.atr1 = atr1;
    }

    public C1() {
    }

}
