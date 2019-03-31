package inc.brocorp.controller;


import static inc.brocorp.GameApp.BUNDLES_FOLDER;

import inc.brocorp.GameApp;
import inc.brocorp.i18n.LocaleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String FXML_MENU = "..//fxml/MainMenu.fxml";
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxmlLoader.setLocation(getClass().getResource(FXML_MENU));
    }

    public void btnPressed(ActionEvent ae) {
        Object source = ae.getSource();
        if (!(source instanceof Button))
            return;
        Button clickedButton = (Button) source;
        switch (clickedButton.getId()) {
            case "btnGame":
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
        try {
            fxmlLoader.setResources(ResourceBundle.getBundle(BUNDLES_FOLDER, locale));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 275, 375);
            Stage stage = new Stage();
            stage.setTitle(fxmlLoader.getResources().getString("menu.title"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            GameApp.mainStage.close();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
