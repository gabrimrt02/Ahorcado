package dad.ahorcado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    
    private static RootController rootController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        rootController = new RootController();

        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(rootController.getView()));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/hangman/9.png")));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
