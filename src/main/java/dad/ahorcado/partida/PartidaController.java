package dad.ahorcado.partida;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PartidaController implements Initializable {
    
    // VIEW
    @FXML
    private ImageView ahorcadoImage;

    @FXML
    private TextField entradaTextField;

    @FXML
    private Button letraButton;

    @FXML
    private Text letrasUsadasText;

    @FXML
    private Text palabraOcultaText;

    @FXML
    private Text puntosText;

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
        // TODO Auto-generated method stub
        
    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    private void onAdivinarLetraButton(ActionEvent e) {

    }

    @FXML
    private void onResolverButton(ActionEvent e) {

    }

}
