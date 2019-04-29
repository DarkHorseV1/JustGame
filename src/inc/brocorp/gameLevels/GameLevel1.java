package inc.brocorp.gameLevels;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static inc.brocorp.GameApp.BUNDLES_FOLDER;
import static inc.brocorp.GameApp.menuStage;

public class GameLevel1 implements Initializable {

    private Parent gameParent;
    private FXMLLoader loadFxmlGame = new FXMLLoader();
    private static final String FXML_GAME = "..//fxml/GameLevel1.fxml";
    private Stage gameStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startGame(){
        initLoader();
        gameStage = new Stage();
        gameStage.setTitle("Level 1");
        gameStage.setScene(new Scene(gameParent));
        gameStage.setResizable(false);
        gameStage.show();
        menuStage.hide();

    }

    private void initLoader(){
        try {
            loadFxmlGame.setLocation(getClass().getResource(FXML_GAME));
            loadFxmlGame.setResources(ResourceBundle.getBundle(BUNDLES_FOLDER));
            gameParent = loadFxmlGame.load();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
