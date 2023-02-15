package com.example.pc.database;

/**
 * Created by pc on 12/05/2022.
 */

public class info_accont {
    private String name;
    private String card;
    private String phon;

    public info_accont(String name, String card, String phon) {
        this.name = name;
        this.card = card;
        this.phon = phon;
    }

    public String getName() {
    return name;
}

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhon() {
        return phon;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }
}