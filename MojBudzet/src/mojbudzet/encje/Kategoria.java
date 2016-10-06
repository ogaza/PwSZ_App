
package mojbudzet.encje;
import mojbudzet.interfejsy.IKategoria;

public class Kategoria implements IKategoria {

    private int id;
    private String nazwa;
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNazwa() {
        return this.nazwa;
    }

    @Override
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
}
