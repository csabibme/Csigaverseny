package org.example;

public class Csigaverseny {
    public static void main(String[] args) {
        Versenyzo[] versenyzok = {
                new Csiga("piros"),
                new Csiga("zöld"),
                new Csiga("kék")
        };
        Versenykiiras versenykiiras = new Versenykiiras(versenyzok);
        versenykiiras.versenyIndit();
    }
}
