package org.example;
public enum Units {

    KG("кил"),GRAMM("грамм"),LITER("литр"),PIECE("штука");
private String name;
    Units(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
