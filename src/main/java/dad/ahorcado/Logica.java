package dad.ahorcado;

import java.util.List;
import java.util.Random;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;

public class Logica {
    
    private static ListProperty<String> palabras = new SimpleListProperty<>();    
    private static StringProperty palabraOculta = new SimpleStringProperty();


    public static void nuevaPalabra() {
        palabraOculta.set(palabras.get(new Random().nextInt(palabras.size())));
    }



    public static ListProperty<String> palabrasProperty() {
        return palabras;
    }

    public static List<String> getPalabras() {
        return palabras.get();
    }

    public static void setPalabras(ObservableList<String> lista) {
        palabras.set(lista);
    }

    public static StringProperty palabraOcultaProperty() {
        return palabraOculta;
    }

    public static String getPalabraOculta() {
        return palabraOculta.get();
    }

    public static void setPalabraOculta(String palabra) {
        palabraOculta.set(palabra);
    }

    public static void gameOver(int puntos) {
        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over - Has perdido - Has conseguido un total de: " + puntos + " pts.");
        alert.setContentText("Introduce tu nombre: ");
        alert.showAndWait();
    }
}
