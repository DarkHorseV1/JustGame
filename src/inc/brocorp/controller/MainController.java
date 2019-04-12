package inc.brocorp.controller;


import static inc.brocorp.GameApp.BUNDLES_FOLDER;
import static inc.brocorp.GameApp.menuStage;


import inc.brocorp.i18n.LocaleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String FXML_MENU = "..//fxml/MainMenu.fxml";
    private static final String FXML_GAME = "..//fxml/GameLevel1.fxml";
    private FXMLLoader loadFxmlMenu = new FXMLLoader();
    private FXMLLoader loadFxmlGame = new FXMLLoader();
    private Parent menuParent;
    private Parent gameParent;

    @FXML
    public VBox menuVBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                //createGame();
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
        createMenu(selectedLocale);
    }

    private void createMenu(Locale locale) {
        initLoader(locale);
        menuStage.setScene(new Scene(menuParent, 275, 390));
        menuStage.setTitle(loadFxmlMenu.getResources().getString("menu.title"));
        menuVBox.setAlignment(Pos.CENTER_LEFT);
    }

    private void createGame() {

    }
}

