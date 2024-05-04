package org.example;

import java.util.Random;
import java.util.Scanner;

public class Versenykiiras {
    private Versenyzo[] versenyzok;
    private Random szam = new Random();

    public Versenykiiras(Versenyzo[] versenyzok) {
        this.versenyzok = versenyzok;
    }

    public void versenyIndit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tippelj, melyik csiga lesz a győztes! (piros, zöld, kék):");
        String tipp = scanner.nextLine(); // ide majd be kell tennem inputra exceptiont...

        for (int kor = 1; kor <= 5; kor++) {
            System.out.println("Kör: " + kor);
            for (int i = 0; i < versenyzok.length; i++) {
                if (szam.nextInt(5) == 0) {
                    /*20% beállítása.
                    (ahhoz hogy 0 legyen a random szam, 1 az 5höz az esély, vagyis épp 20%)*/
                    versenyzok[i].gyorsit();
                    System.out.println(versenyzok[i].getSzin() + " gyorsítót kaptott...");
                } else {
                    versenyzok[i].lep();
                }
            }
            for (Versenyzo versenyzo : versenyzok) {
                System.out.println(versenyzo);
            }
            System.out.println();
        }

        Versenyzo gyoztes = gyoztesKivalaszt();
        System.out.println("A nyertes: " + gyoztes.getSzin() + "!");
        if (gyoztes.getSzin().equals(tipp)) {
            System.out.println("A tipped helyes volt");
        } else {
            System.out.println("Nem tippeltél helyesen.");
        }
        scanner.close();
    }

    private Versenyzo gyoztesKivalaszt() {
        Versenyzo gyoztes = versenyzok[0];
        for (int i = 0; i < versenyzok.length; i++) {
            if (versenyzok[i].getTavolsag() > gyoztes.getTavolsag()) {
                gyoztes = versenyzok[i];
            }
        }
        return gyoztes;
    }
}

