package dad.ahorcado;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import dad.ahorcado.palabras.PalabrasController;
import dad.ahorcado.partida.PartidaController;
import dad.ahorcado.puntuaciones.PuntuacionesController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable{

    // CONTROLLERS
    
    private PalabrasController palabrasController = new PalabrasController();
    private PuntuacionesController puntuacionesController = new PuntuacionesController();
    private PartidaController partidaController = new PartidaController();
    
    // MODEL

    private static ListProperty<String> palabras = new SimpleListProperty<>();
    private StringProperty palabraOculta = new SimpleStringProperty();

    // VIEW
    
    @FXML
    private Tab palabrasTab;

    @FXML
    private Tab partidaTab;

    @FXML
    private Tab puntuacionesTab;

    @FXML
    private TabPane view;

    // CONSTRUCTOR
    public RootController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // CONTENIDO DE LAS TABS

        partidaTab.setContent(partidaController.getView());
        palabrasTab.setContent(palabrasController.getView());
        puntuacionesTab.setContent(puntuacionesController.getView());

        // BINDINGS
        palabras.bind(palabrasController.palabrasProperty());
        partidaController.palabraOcultaProperty().bind(palabraOculta);

    }

    public TabPane getView() {
        return view;
    }
    
    public ListProperty<String> palabrasProperty() {
        return palabras;
    }

    public void setPalabraOculta(String text) {
        palabraOculta.set(text);;
    }

    public String getPalabraOculta() {
        return palabraOculta.get();
    }

    public void ocultarLetras(String palabra) {
        partidaController.ocultarLetras(palabra);
    }

    public static String nuevaPalabra() {
        return palabras.get(new Random().nextInt(palabras.size()));
    }
}
