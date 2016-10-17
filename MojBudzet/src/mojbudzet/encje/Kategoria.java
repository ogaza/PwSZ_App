package mojbudzet.encje;

public class Kategoria {

    private int id;
    private String nazwa;

    public Kategoria() {
    }

    public Kategoria(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
