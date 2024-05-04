package org.example;

import java.util.Random;
import java.util.Scanner;

public class Versenykiiras {
    private Versenyzo[] versenyzok;
    private Random szam = new Random();
    private Scanner scanner = new Scanner(System.in);

    public Versenykiiras(Versenyzo[] versenyzok) {
        this.versenyzok = versenyzok;
    }

    public void versenyIndit() {
        String tipp = tippEllenorzes();

        for (int kor = 1; kor <= 5; kor++) {
            System.out.println("Kör: " + kor);
            for (int i = 0; i < versenyzok.length; i++) {
                if (szam.nextInt(5) == 0) {
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
        if (gyoztes.getSzin().equalsIgnoreCase(tipp)) {
            System.out.println("A tipped helyes volt");
        } else {
            System.out.println("Nem tippeltél helyesen.");
            // az a gond, hogy a döntetlennél matematikailag bármely tipp helyes. Ezt kezelni kell!
        }
        scanner.close();
    }

    private String tippEllenorzes() { //metódus az ellenőrzéshez
        System.out.println("Tippelj, melyik csiga lesz a győztes! (piros, zöld, kék):");
        String tipp = scanner.nextLine().trim();
        while (!ervenyesSzin(tipp)) {
            System.out.println("Csak a következők adhatók meg: (piros, zöld, kék):");
            tipp = scanner.nextLine().trim();
        }
        return tipp;
    }

    private boolean ervenyesSzin(String szin) {
        for (Versenyzo versenyzo : versenyzok) {
            if (versenyzo.getSzin().equalsIgnoreCase(szin)) {
                return true;
            }
        }
        return false;
    }

    private Versenyzo gyoztesKivalaszt() {
        Versenyzo gyoztes = versenyzok[0];
        for (int i = 1; i < versenyzok.length; i++) {
            if (versenyzok[i].getTavolsag() > gyoztes.getTavolsag()) {
                gyoztes = versenyzok[i];
            }
        }
        return gyoztes;
    }
}
