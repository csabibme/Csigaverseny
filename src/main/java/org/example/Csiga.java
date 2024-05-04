package org.example;

public class Csiga implements Versenyzo {
    private String szin;
    private int tavolsag;

    public Csiga(String szin) {
        this.szin = szin;
        this.tavolsag = 0;
    }

    @Override
    public String getSzin() {
        return szin;
    }

    @Override
    public int getTavolsag() {
        return tavolsag;
    }

    @Override
    public void lep() {
        tavolsag += 1;  // normál sebesség
    }

    @Override
    public void gyorsit() {
        tavolsag += 2;  // gyorsítóval megy
    }

    @Override
    public String toString() {
        return szin + " csiga: " + tavolsag + " méterre van.";
    }
}
