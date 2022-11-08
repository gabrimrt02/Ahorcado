package dad.ahorcado.palabras;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

public class PalabrasController implements Initializable{

    // MODEL

    private ListProperty<String> palabras = new SimpleListProperty<>();
    
    // VIEW

    @FXML
    private BorderPane view;
    
    @FXML
    private Button aniadirButton;

    @FXML
    private ListView<String> palabrasList;

    @FXML
    private Button quitarButton;
    
    // CONSTRUCTOR
    public PalabrasController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palabrasView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        // BINDINGS
        palabras.bindBidirectional(palabrasList.itemsProperty());

    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    private void onNuevoAction(ActionEvent event) {

        // palabrasList.getItems().add("PALABRA");
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Nueva Palabra");
        dialogo.setHeaderText("Introduzca una nueva palabra");
        dialogo.setContentText("Nueva palabra:");

        Optional<String> result = dialogo.showAndWait();
        result.ifPresent(palabra -> palabrasList.getItems().add(palabra.toUpperCase()));

        System.out.println(getPalabras());

    }

    @FXML
    private void onQuitarAction(ActionEvent event) {

        palabrasList.getItems().remove(palabrasList.getSelectionModel().getSelectedIndex());

        System.out.println(getPalabras());

    }

    public ArrayList<String> getPalabras() {
        ArrayList<String> palabrasArray = new ArrayList<>();

        for(String s : palabras) {
            palabrasArray.add(s);
        }

        return palabrasArray;
    }

    public ListProperty<String> palabrasProperty() {
        return palabras;
    }

}
