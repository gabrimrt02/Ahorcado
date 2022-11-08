package dad.ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    
    private static RootController rootController;

    private static final File FICHERO_PALABRAS = new File("src/main/resources/txt/palabras.txt");

    @Override
    public void init() throws Exception {
        rootController = new RootController();

        BufferedReader br = new BufferedReader(new FileReader(FICHERO_PALABRAS));
        String linea = br.readLine();
        
        if(linea != null) {
            ArrayList<String> palabras = new ArrayList<>();

            while(linea != null) {
                palabras.add(linea.trim());
                linea = br.readLine();
            }            
            rootController.palabrasProperty().addAll(palabras);

            rootController.setPalabraOculta(palabras.get(new Random().nextInt(palabras.size())));
        }
        br.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        

        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(rootController.getView()));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/hangman/9.png")));
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {

        FileWriter fw = new FileWriter(FICHERO_PALABRAS);

        Object[] palabras = rootController.palabrasProperty().toArray();

        for(Object s : palabras) {
            fw.write(s.toString() + "\n");
        }

        fw.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
