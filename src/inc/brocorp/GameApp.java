package inc.brocorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameApp extends Application {

    public static final String BUNDLES_FOLDER = "inc.brocorp.resources.Locale";
    private static final String FXML_APP = "fxml/GameApp.fxml";
    public static Stage menuStage;
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource(FXML_APP));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Just a game");
        Scene scene = new Scene(root, 240, 250);
        menuStage = primaryStage;
        menuStage.setScene(scene);
        menuStage.setResizable(false);
        menuStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
