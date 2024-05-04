package org.example;

public class Csiga implements Versenyzo {
    private String szin;
    private int tavolsag;

    public Csiga(String szin) {
        this.szin = szin;
        this.tavolsag = 1;  //Itt majd meg kell oldanom, hogy több kör legyen
    }


    public String getSzin() {
        return szin;
    }


    public int getTavolsag() {
        return tavolsag;
    }


    public String toString() {
        return szin + " csiga: " + tavolsag + " méterre van.";
    }
}
