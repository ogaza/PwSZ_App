/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.encje;

public class Wpis {

    private int id;
    private byte type;
    Kategoria kategoria;
    
    public int getId() {
        return this.id;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Kategoria getKategoria() {
        return this.kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
    
}
