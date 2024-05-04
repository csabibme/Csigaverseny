package org.example;

import java.util.Random;
import java.util.Scanner;

public class Versenykiiras {
    private Versenyzo[] versenyzok;
    private Random szam = new Random();
    private Scanner scanner = new Scanner(System.in);
    private boolean voltGyorsitas = false; // Gyorsítás figyelése

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
                    voltGyorsitas = true;
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
        if (!voltGyorsitas && "döntetlen".equalsIgnoreCase(tipp)) {
            System.out.println("A verseny döntetlen lett, helyesen tippeltél!");
        } else if (gyoztes.getSzin().equalsIgnoreCase(tipp)) {
            System.out.println("A nyertes: " + gyoztes.getSzin() + "! A tipped helyes volt.");
        } else {
            System.out.println("Nem tippeltél helyesen. A győztes: " + gyoztes.getSzin());
        }
        scanner.close();
    }

    private String tippEllenorzes() {
        System.out.println("Tippelj, melyik csiga lesz a győztes (piros, zöld, kék, döntetlen):");
        String tipp = scanner.nextLine().trim();
        while (!isValidColor(tipp) && !"döntetlen".equals(tipp)) {
            System.out.println("Érvénytelen tipp! Próbáld újra! (piros, zöld, kék, döntetlen):");
            tipp = scanner.nextLine().trim();
        }
        return tipp;
    }

    private boolean isValidColor(String szin) {
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
