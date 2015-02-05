package es.art83.persistence.jpa;

import java.io.Serializable;

public class User3PK implements Serializable{
     private static final long serialVersionUID = 1L;

    private int part1;

    private int part2;

    public User3PK() {
    }

    public User3PK(int part1, int part2) {
        super();
        this.part1 = part1;
        this.part2 = part2;
    }

    public int getPart1() {
        return this.part1;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public int getPart2() {
        return this.part2;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    public boolean equals(Object obj) {
        User3PK other = (User3PK) obj;
        return getPart1() == other.getPart1() && getPart2() == other.getPart2();
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getPart1();
        result = prime * result + getPart2();
        return result;
    }

}
