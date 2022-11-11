package dad.ahorcado.partida;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.ahorcado.Logica;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PartidaController implements Initializable {

    // MODEL
    private StringProperty palabraOculta = new SimpleStringProperty();
    private int puntos;

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

    // ARRAY CON LAS IMAGENES DEL JUEGO
    private final Image[] imagenes = {
            new Image(getClass().getResourceAsStream("/images/hangman/1.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/2.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/3.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/4.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/5.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/6.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/7.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/8.png")),
            new Image(getClass().getResourceAsStream("/images/hangman/9.png"))
    };

    private int errores = 0;

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

        // BINDINGS
        palabraOculta.bind(Logica.palabraOcultaProperty());

    }

    public BorderPane getView() {
        return view;
    }

    @FXML
    private boolean onAdivinarLetraButton(ActionEvent event) {

        if(entradaTextField.getText().toUpperCase().length() > 1) {
            onResolverButton(event);
            return false;
        }

        if (palabraOculta.get().contains(entradaTextField.getText().toUpperCase())) {
            for (int i = 0; i < palabraOculta.get().length(); i++) {
                if (palabraOculta.get().charAt(i) == entradaTextField.getText().toUpperCase().charAt(0)) {

                    char letra = entradaTextField.getText().charAt(0);

                    String palabra = "";
                    for (int index = 0; index < palabraOcultaLabel.getText().length(); index++) {

                        if (index == i) {
                            palabra += (letra + "").toUpperCase();
                        } else {
                            palabra += palabraOcultaLabel.getText().charAt(index);
                        }

                    }
                    palabraOcultaLabel.setText(palabra);

                    puntos++;
                }
            }


        } else {
            errores++;

        }
        if (errores == 9) {
            letrasUsadasLabel.setText("");
            gameOver();
            ocultarLetras(palabraOculta.get());
        } else {
            ahorcadoImage.imageProperty().set(imagenes[errores]);
            letrasUsadasLabel.setText(letrasUsadasLabel.getText() + entradaTextField.getText().toUpperCase() + " ");
        }
        puntosLabel.setText("Puntos: " + puntos);

        entradaTextField.clear();
        entradaTextField.requestFocus();

        return true;

    }

    @FXML
    private boolean onResolverButton(ActionEvent event) {

        if(entradaTextField.getText().toUpperCase().length() == 1) {
            onAdivinarLetraButton(event);
            return false;
        }

        if (entradaTextField.getText().toUpperCase().equals(palabraOculta.get().toUpperCase())) {
            mostrarPalabraOculta();
            Logica.nuevaPalabra();
            palabraOcultaLabel.setText(palabraOculta.get());
            ocultarLetras(palabraOculta.get());
            letrasUsadasLabel.setText("");

            puntos += 10;

        } else {
            errores++;
            if (errores == 9) {
                letrasUsadasLabel.setText("");
                gameOver();
                ocultarLetras(palabraOculta.get());
            } else {
                ahorcadoImage.imageProperty().set(imagenes[errores]);
                letrasUsadasLabel.setText(letrasUsadasLabel.getText() + entradaTextField.getText().toUpperCase() + " ");
            }
        }
        puntosLabel.setText("Puntos: " + puntos);

        entradaTextField.clear();
        entradaTextField.requestFocus();

        return true;
    }

    public StringProperty palabraOcultaProperty() {
        return palabraOculta;
    }

    public void ocultarLetras(String palabra) {

        String oculto = "";

        for (int index = 0; index < palabra.length(); index++) {
            if (Character.isLetterOrDigit(palabra.charAt(index)))
                oculto += "-";
            else
                oculto += " ";
        }

        palabraOcultaLabel.setText(oculto);

    }

    private void gameOver() {
        Logica.gameOver(puntos);
        errores = 0;
        puntos = 0;
        ahorcadoImage.imageProperty().set(imagenes[errores]);
        Logica.nuevaPalabra();
        letrasUsadasLabel.setText(" ");
    }

    private void mostrarPalabraOculta() {
        palabraOcultaLabel.setText(palabraOculta.get());
    }

}
