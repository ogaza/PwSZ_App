/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.encje;

import java.util.Date;

public class Wpis {

    private int id;
    private byte typ;
    private double wartosc;
    private Date data;
    Kategoria kategoria;

    public Wpis() {
    }

    public Wpis(byte typ, double wartosc, Date data, Kategoria kategoria) {
        this.typ = typ;
        this.wartosc = wartosc;
        this.data = data;
        this.kategoria = kategoria;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getTyp() {
        return this.typ;
    }

    public void setTyp(byte typ) {
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

    public Kategoria getKategoria() {
        return this.kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

}
