/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mojbudzet.encje.Kategoria;
import mojbudzet.encje.Wpis;
import mojbudzet.repozytoria.Repozytorium;
import mojbudzet.widoki.WpisWidok;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView table;

    private final Repozytorium repo = new Repozytorium();

    List<Kategoria> kategorie;

    @FXML
    private void onAddBtnClicked(ActionEvent event) {

        Wpis wpis = showWpisEditDialog(
                new Wpis((byte) -1, 0.0, new Date(), null), event);

        repo.dodajWpis(wpis);

        refreshGrid();
    }

    @FXML
    private void onEditBtnClicked(ActionEvent event) {
        
        WpisWidok wybranyWpis = (WpisWidok)table.
                getSelectionModel().getSelectedItem();
        
        if (wybranyWpis != null) {
            
            Wpis wpis = repo.pobierzWpis(wybranyWpis.getId());
            
            wpis = showWpisEditDialog(wpis, event);
            
            repo.dodajWpis(wpis);
            
            refreshGrid();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Nie wybrano wpisu do edycji");
            alert.showAndWait();
        }
    }

    @FXML
    private void onDeleteBtnClicked() {
        WpisWidok wybranyWpis = (WpisWidok)table.
                getSelectionModel().getSelectedItem();
                
        repo.usunWpis(wybranyWpis.getId());
        refreshGrid();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pobierzKategorie();
        przygotujKolumny();
        refreshGrid();
    }

    private void refreshGrid() {

        ObservableList<WpisWidok> wpisyObservable = FXCollections.observableArrayList();

        List<Wpis> wpisy = repo.pobierzWpisy();

        for (Wpis wpis : wpisy) {
            wpisyObservable.add(new WpisWidok(wpis));
        }

        table.setItems(wpisyObservable);
    }

    private void przygotujKolumny() {

        ObservableList<TableColumn> kolumny = FXCollections.
                observableArrayList(table.getColumns());

        kolumny.get(0).setCellValueFactory(new PropertyValueFactory<>("typ"));
        kolumny.get(1).setCellValueFactory(new PropertyValueFactory<>("wartosc"));
        kolumny.get(2).setCellValueFactory(new PropertyValueFactory<>("data"));
        kolumny.get(3).setCellValueFactory(new PropertyValueFactory<>("kategoria"));

    }

    private void pobierzKategorie() {
        kategorie = repo.pobierzKategorie();
    }

    public Wpis showWpisEditDialog(Wpis wpis, ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addModal.fxml"));

            Parent root = (Parent) loader.load();

            Stage dialogStage = new Stage();

            dialogStage.setTitle("Wprowady dane");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            dialogStage.setScene(new Scene(root));

            AddModalController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            controller.setKategorie(kategorie);
            controller.setWpis(wpis);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.wpis;
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
