/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.encje;

import mojbudzet.interfejsy.IKategoria;
import mojbudzet.interfejsy.IWpis;


public class Wpis implements IWpis {

    private int id;
    private byte type;
    IKategoria kategoria;
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public byte getType() {
        return this.type;
    }

    @Override
    public void setType(byte type) {
        this.type = type;
    }

    @Override
    public IKategoria getKategoria() {
        return this.kategoria;
    }

    @Override
    public void setKategoria(IKategoria kategoria) {
        this.kategoria = kategoria;
    }
    
}
