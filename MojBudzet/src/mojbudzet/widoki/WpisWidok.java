/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.widoki;

import java.util.Date;
import mojbudzet.encje.Wpis;

public class WpisWidok {

    private int id;
    private String typ;
    private double wartosc;
    private Date data;
    String kategoria;

    public WpisWidok() {
    }

    public WpisWidok(byte typ, double wartosc, Date data, String kategoria) {
        this.typ = typ == -1 ? "wydatek" : "przychód";
        this.wartosc = wartosc;
        this.data = data;
        this.kategoria = kategoria;
    }

    public WpisWidok(Wpis wpis) {
        this.id = wpis.getId();
        this.typ = wpis.getTyp() == -1 ? "wydatek" : "przychód";
        this.wartosc = wpis.getWartosc() * (double) wpis.getTyp();
        this.data = wpis.getData();
        this.kategoria = wpis.getKategoria().getNazwa();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTyp() {
        return this.typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getWartosc() {
        return this.wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public String getKategoria() {
        return this.kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
