package inc.brocorp.gameLevels;

import inc.brocorp.controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameLevel1 implements Initializable {

    @FXML
    private Pane pane;
    private File file = new File("inc.brocorp.resources.graphic.background.game_background.png");
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private String localURL = file.toURI().toURL().toString();
    private Image background = new Image(localURL);
    private ImageView showImage = new ImageView(background);

    public GameLevel1() throws MalformedURLException {
    }

    public void startPressed(){
        pane.setPadding(new Insets(20));
        pane.getChildren().addAll(showImage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //fxmlLoader.setLocation(getClass().getResource(MainController.FXML_GAME));
        pane.getChildren().addAll(showImage);
    }
}
