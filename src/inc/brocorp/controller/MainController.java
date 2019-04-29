package inc.brocorp.controller;


import inc.brocorp.gameLevels.GameLevel1;
import inc.brocorp.interfaceCange.ButtonScaling;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static inc.brocorp.GameApp.*;

public class MainController implements Initializable {

    private static final String FXML_MENU = "..//fxml/MainMenu.fxml";
    private FXMLLoader loadFxmlMenu = new FXMLLoader();
    private Parent menuParent;
    private ObservableList<Node> menuButtons;

    @FXML
    public VBox menuVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuButtons = menuVBox.getChildren();
        ButtonScaling.setButtonsScale(menuButtons);
    }


    private void initLoader(Locale locale) {
        try {
            loadFxmlMenu.setLocation(getClass().getResource(FXML_MENU));
            loadFxmlMenu.setResources(ResourceBundle.getBundle(BUNDLES_FOLDER, locale));
            menuParent = loadFxmlMenu.load();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }

    public void btnPressed(ActionEvent ae) {
        Object source = ae.getSource();
        if (!(source instanceof Button))
            return;
        Button clickedButton = (Button) source;
        switch (clickedButton.getId()) {
            case "btnGame":
                createGame();
                break;
            case "btnLoad":
                break;
            case "btnScores":
                break;
            case "btnSettings":
                break;
            case "btnControls":
                break;
            case "btnExit":
                System.exit(0);
                break;
        }
    }

    public void createMenu(Locale locale) {
        initLoader(locale);
        menuStage.setScene(new Scene(menuParent, 275, 390));
        menuStage.setTitle(loadFxmlMenu.getResources().getString("menu.title"));
    }

    private void createGame() {
        new GameLevel1().startGame();
    }
}

