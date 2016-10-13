/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

//import java.util.Date;
//import java.util.List;
//import mojbudzet.repozytoria.Repozytorium;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import mojbudzet.encje.*;

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

//        Kategoria  kategoria = new Kategoria("kategoria 1");                
//        Wpis wpis = new Wpis((byte)-1 , 1.0, new Date(), kategoria);
//        
//        Repozytorium repo = new Repozytorium();
//        
//        repo.dodajKategorie(kategoria);        
//        repo.dodajWpis(wpis);
//        
//        List<Wpis> lista = repo.pobierzWpisy();
//        Kategoria kat  = lista.get(0).getKategoria();       
               
        // nie zadziala, nie ma my sesji => rozw trzeba ustawic lazy na false        
        //String nazwa = kat.getNazwa();                
        //int y = 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
