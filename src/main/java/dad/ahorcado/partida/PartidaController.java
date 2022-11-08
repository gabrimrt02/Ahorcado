package dad.ahorcado.partida;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PartidaController implements Initializable {

    // MODEL
    private StringProperty palabraOculta = new SimpleStringProperty();
    
    // VIEW
    @FXML
    private ImageView ahorcadoImage;

    @FXML
    private TextField entradaTextField;

    @FXML
    private Button letraButton;

    @FXML
    private Label letrasUsadasLabel;

    @FXML
    private Label palabraOcultaLabel;

    @FXML
    private Label puntosLabel;

    @FXML
    private Button resolverButton;

    @FXML
    private BorderPane view;

    

    // CONSTRUCTOR
    public PartidaController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/partidaView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO IMPLEMENTAR INITIALIZE DE PARTIDACONTROLLER
        
        // BINDINGS


        ocultarLetras();
    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    private void onAdivinarLetraButton(ActionEvent event) {

    }

    @FXML
    private void onResolverButton(ActionEvent event) {

    }

    public StringProperty palabraOcultaProperty() {
        return palabraOculta;
    }

    public void ocultarLetras() {
        
        String oculto = "";
        String prueba = "HOLAMUNDO";

        for(int index = 0; index < prueba.length(); index++) {
            oculto += "_ ";
        }

        palabraOcultaLabel.setText(oculto);

    }


}
