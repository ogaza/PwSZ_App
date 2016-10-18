/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mojbudzet.encje.Kategoria;

public class AddKategoriaController implements Initializable {

    @FXML
    private TextField nazwaField;

    private Stage dialogStage;

    private Kategoria kategoriaDoEdycji;    
    
    private Kategoria kategoriaDoZapisu; 

    @FXML
    private void onSaveBtnClicked() {

        if (nazwaField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Podaj nazwę");
            alert.show();
            return;
        }

        kategoriaDoEdycji.setNazwa(nazwaField.getText());        

        kategoriaDoZapisu = kategoriaDoEdycji;
        
        dialogStage.close();

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setKategoriaDoEdycji(Kategoria kategoria) {
        this.kategoriaDoEdycji = kategoria;

        nazwaField.setText(kategoriaDoEdycji.getNazwa());
    }

    public Kategoria getKategoriaDoZapisu(){
        return kategoriaDoZapisu;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
}
