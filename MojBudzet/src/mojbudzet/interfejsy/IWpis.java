
package mojbudzet.interfejsy;

public interface IWpis {
    int getId();
    
    byte getType();
    void setType(byte type);
    
    IKategoria getKategoria();
    void setKategoria(IKategoria kategoria);
}
