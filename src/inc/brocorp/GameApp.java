package inc.brocorp;

import inc.brocorp.controller.MainController;
import inc.brocorp.i18n.LocaleManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Locale;


public class GameApp extends Application {

    public static final String BUNDLES_FOLDER = "inc.brocorp.resources.Locale";
    private static final String FXML_APP = "fxml/GameApp.fxml";
    public static Stage menuStage;
    private MainController mainController = new MainController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_APP));
        primaryStage.setTitle("Just a game");
        Scene scene = new Scene(root, 240, 250);
        menuStage = primaryStage;
        menuStage.setScene(scene);
        menuStage.setResizable(false);
        menuStage.show();
    }

    public void showMenu(ActionEvent ae) {
        Locale selectedLocale = null;
        Object source = ae.getSource();
        if (!(source instanceof Button))
            return;
        Button clickedButton = (Button) source;
        if (clickedButton.getId().equals("btnRu")) {
            selectedLocale = LocaleManager.RU_LOCALE;
        } else if (clickedButton.getId().equals("btnEn")) {
            selectedLocale = LocaleManager.EN_LOCALE;
        }
        mainController.createMenu(selectedLocale);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
