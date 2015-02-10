package es.art83.persistence.jpa.inheritance;

import javax.persistence.Entity;

@Entity
public class C1B extends C1 {
    private int atr3;

    private int atr5;

    public C1B(int id, int atr1, int atr3, int atr5) {
        super(id, atr1);
        this.atr3 = atr3;
        this.atr5 = atr5;
    }

    public C1B() {
    }

    public int getAtr3() {
        return atr3;
    }

    public void setAtr3(int atr3) {
        this.atr3 = atr3;
    }

    public int getAtr5() {
        return atr5;
    }

    public void setAtr5(int atr5) {
        this.atr5 = atr5;
    }

}
