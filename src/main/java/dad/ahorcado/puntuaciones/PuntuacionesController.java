package dad.ahorcado.puntuaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class PuntuacionesController implements Initializable {
    
    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TableColumn<?, ?> puntuacionColumn;

    @FXML
    private TableView<?> tabla;

    @FXML
    private BorderPane view;

    public PuntuacionesController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/puntuacionesView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        


    }

    public BorderPane getView() {
        return view;
    }

}
