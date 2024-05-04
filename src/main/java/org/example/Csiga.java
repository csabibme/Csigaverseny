package org.example;
import java.util.Random;
public class Csiga implements Versenyzo {
    private Random rnd;
    private String szin;
    private int tavolsag;

    public Csiga(String szin) {
        this.szin = szin;
        this.tavolsag = 0;
        this.rnd=new Random();
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
        int lepesek = rnd.nextInt(4); // A lépések a videon elhnagzottak szerint 0-3 közöttiek lehetnek
        tavolsag += lepesek;
        System.out.println(szin + " csiga " + lepesek + " lépést tett.");
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
