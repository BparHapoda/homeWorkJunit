package org.example;

public enum Units {

    KG("килограмм"),GRAMM("грамм"),LITER("литр"),PIECE("штука");
private String name;
    Units(String name) {
        this.name=name;
    }
}
