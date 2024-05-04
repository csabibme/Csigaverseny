package org.example;

public class Versenykiiras {
    private Versenyzo[] versenyzok;

    public Versenykiiras(Versenyzo[] versenyzok) {
        this.versenyzok = versenyzok;
    }

    public void versenyIndit() {
        for (Versenyzo versenyzo : versenyzok) {
            System.out.println(versenyzo);  // A tábolságot meg kell változtatni
        }

        Versenyzo gyoztes = gyoztesKivalaszt();
        System.out.println("A gyoztes: " + gyoztes.getSzin() + "!");
    }

    private Versenyzo gyoztesKivalaszt() { //talán ide teszem a 20%-os gyorsítót...
        Versenyzo gyoztes = versenyzok[0];
        for (int i = 1; i < versenyzok.length; i++) {
            if (versenyzok[i].getTavolsag() > gyoztes.getTavolsag()) {
                gyoztes = versenyzok[i];
            }
        }
        return gyoztes;
    }
}
