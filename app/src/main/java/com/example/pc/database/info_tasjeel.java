package com.example.pc.database;

/**
 * Created by pc on 12/05/2022.
 */

public class info_tasjeel {
    private String name;
    private String card;
    private String phon;
    private String gss;
    private String alajmalee;
    private String almdfoa;
    private String almtbgee;

    public info_tasjeel(String name, String card, String phon, String gss, String alajmalee, String almdfoa, String almtbgee) {
        this.name = name;
        this.card = card;
        this.phon = phon;
        this.gss = gss;
        this.alajmalee = alajmalee;
        this.almdfoa = almdfoa;
        this.almtbgee = almtbgee;
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

    public String getGss() {
        return gss;
    }

    public void setGss(String gss) {
        this.gss = gss;
    }

    public String getAlajmalee() {
        return alajmalee;
    }

    public void setAlajmalee(String alajmalee) {
        this.alajmalee = alajmalee;
    }

    public String getAlmdfoa() {
        return almdfoa;
    }

    public void setAlmdfoa(String almdfoa) {
        this.almdfoa = almdfoa;
    }


    public String getAlmtbgee() {
        return almtbgee;
    }

    public void setAlmtbgee(String almtbgee) {
        this.almtbgee = almtbgee;
    }
}
