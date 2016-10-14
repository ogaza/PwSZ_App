/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mojbudzet.encje.Wpis;
import mojbudzet.repozytoria.Repozytorium;
import mojbudzet.widoki.WpisWidok;

/**
 *
 * @author Olaf
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView table;

    private final Repozytorium repo = new Repozytorium();

    private void refreshGrid() {
        ObservableList<TableColumn> kolumny = FXCollections.
                observableArrayList(table.getColumns());

        kolumny.get(0).setCellValueFactory(new PropertyValueFactory<>("typ"));
        kolumny.get(1).setCellValueFactory(new PropertyValueFactory<>("wartosc"));
        kolumny.get(2).setCellValueFactory(new PropertyValueFactory<>("data"));
        kolumny.get(3).setCellValueFactory(new PropertyValueFactory<>("kategoria"));

        ObservableList<WpisWidok> wpisyObservable = FXCollections.observableArrayList();

        List<Wpis> wpisy = repo.pobierzWpisy();

        for (Wpis wpis : wpisy) {
            wpisyObservable.add(new WpisWidok(wpis));
        }

        table.setItems(wpisyObservable);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void onAddBtnClicked(ActionEvent event) {
    }

    @FXML
    private void onEditBtnClicked(ActionEvent event) {
    }

    @FXML
    private void onDeleteBtnClicked(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshGrid();
    }

}
