/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mojbudzet.encje.*;
import mojbudzet.repozytoria.Repozytorium;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        // make app close on x button
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        // List<Wpis> lista = sprawdzDlaKategorii();
        // List<Wpis> lista = sprawdzDlaTypu();
        
        int x = 0;
    }

    private List<Wpis> sprawdzDlaDat() throws Exception {
        Repozytorium repo = new Repozytorium();

        Kategoria kat1 = new Kategoria("kategoria 1");
        repo.dodajKategorie(kat1);

        Kategoria kat2 = new Kategoria("kategoria 2");
        repo.dodajKategorie(kat2);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        date = format.parse("2016-01-11");

        Wpis wpis = new Wpis((byte) -1, 1.0, date, kat1);

        repo.dodajWpis(wpis);

        date = format.parse("2016-10-13");

        wpis = new Wpis((byte) -1, 1.0, date, kat2);

        repo.dodajWpis(wpis);

        List<Wpis> lista = repo.
                pobierzWpisyDlaOkresu(
                        format.parse("2010-10-13"),
                        format.parse("2016-10-13"));

        return lista;
    }

    private List<Wpis> sprawdzDlaKategorii() throws Exception {
        Repozytorium repo = new Repozytorium();

        Kategoria kat1 = new Kategoria("kategoria 1");
        repo.dodajKategorie(kat1);

        Kategoria kat2 = new Kategoria("kategoria 2");
        repo.dodajKategorie(kat2);

        Wpis wpis = new Wpis((byte) -1, 1.0, new Date(), kat1);

        repo.dodajWpis(wpis);

        wpis = new Wpis((byte) -1, 1.0, new Date(), kat2);

        repo.dodajWpis(wpis);

        List<Wpis> lista = repo.pobierzWpisyDlaKategorii(kat2);

        return lista;
    }

    private List<Kategoria> sprawdzPobieranieKategorii() {

        Repozytorium repo = new Repozytorium();

        Kategoria kat1 = new Kategoria("kategoria 1");
        repo.dodajKategorie(kat1);

        Kategoria kat2 = new Kategoria("kategoria 2");
        repo.dodajKategorie(kat2);

        List<Kategoria> kategorie = repo.pobierzKategorie();

        return kategorie;
    }

    private List<Wpis> sprawdzDlaTypu() throws Exception {
        Repozytorium repo = new Repozytorium();

        Kategoria kat1 = new Kategoria("kategoria 1");
        repo.dodajKategorie(kat1);

        Kategoria kat2 = new Kategoria("kategoria 2");
        repo.dodajKategorie(kat2);

        Wpis wpis = new Wpis((byte) -1, 1.0, new Date(), kat1);

        repo.dodajWpis(wpis);

        wpis = new Wpis((byte) 1, 1.0, new Date(), kat2);

        repo.dodajWpis(wpis);

        List<Wpis> lista = repo.pobierzWpisyTypu((byte) 1);

        return lista;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
