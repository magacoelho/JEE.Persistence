package es.art83.persistence.jpa.inheritance;

import javax.persistence.Entity;

@Entity
public class C1A extends C1 {
    private int atr3;

    private int atr4;

    public C1A(int id, int atr1, int atr3, int atr4) {
        super(id, atr1);
        this.atr3 = atr3;
        this.atr4 = atr4;
    }

    public C1A() {
    }

    public int getAtr3() {
        return atr3;
    }

    public void setAtr3(int atr3) {
        this.atr3 = atr3;
    }

    public int getAtr4() {
        return atr4;
    }

    public void setAtr4(int atr4) {
        this.atr4 = atr4;
    }

}
