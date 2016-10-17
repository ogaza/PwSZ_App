/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import mojbudzet.encje.Kategoria;
import mojbudzet.encje.Wpis;

public class AddModalController implements Initializable {

    @FXML
    private TextField wartoscField;

    @FXML
    ToggleGroup toggleGroup;

    @FXML
    private RadioButton rbWydatek, rbPrzychod;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private ChoiceBox kategoriaBox;

    private Stage dialogStage;

    public Wpis wpis;

    public List<Kategoria> kategorie;

    @FXML
    private void onSaveBtnClicked() {

        Double wartosc;

        String wartoscStr = wartoscField.getText().trim();
        String regex = "^([0-9]+[.]{1}[0-9]+|[0-9]+)";

        if (wartoscStr.matches(regex)) {
            wartosc = Double.parseDouble(wartoscStr);
        } else {
            wartosc = 0.0;
            wartoscField.setText(Double.toString(wartosc));
            return;
        }
        wpis.setWartosc(wartosc);

        RadioButton rbIn = (RadioButton) toggleGroup.getSelectedToggle();

        switch (rbIn.getId()) {
            case "rbWydatek":
                wpis.setTyp((byte) -1);
                break;
            case "rbPrzychod":
                wpis.setTyp((byte) 1);
                break;
        }

        LocalDate localDate = dataPicker.getValue();

        Date date = new Date();

        if (localDate != null) {
            date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        wpis.setData(date);

        Kategoria kategoria = (Kategoria) kategoriaBox.getValue();

        if (kategoria == null) {
            return;
        }

        wpis.setKategoria(kategoria);

        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setWpis(Wpis wpis) {
        this.wpis = wpis;

        wartoscField.setText(Double.toString(wpis.getWartosc()));

        Date date = new Date(wpis.getData().getTime());

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        dataPicker.setValue(localDate);

        if (wpis.getTyp() == -1) {
            rbWydatek.setSelected(true);
        } else {
            rbPrzychod.setSelected(true);
        }
        
        kategoriaBox.setValue(wpis.getKategoria());
    }

    public void setKategorie(List<Kategoria> kategorie) {
        this.kategorie = kategorie;

        ObservableList<Kategoria> kategorieStr = FXCollections.observableArrayList();

        for (Kategoria kategoria : kategorie) {
            kategorieStr.add(kategoria);
        }

        kategoriaBox.setItems(kategorieStr);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
