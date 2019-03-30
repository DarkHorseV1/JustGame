package inc.brocorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameApp extends Application {

    public static final String BUNDLES_FOLDER = "inc.brocorp.resources.Locale";
    private static final String FXML_APP = "fxml/GameApp.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(FXML_APP));
        primaryStage.setTitle("Just a game");
        Scene scene = new Scene(root,240, 250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
