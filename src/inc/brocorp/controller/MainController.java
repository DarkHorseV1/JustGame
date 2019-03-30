package inc.brocorp.controller;


import static inc.brocorp.GameApp.BUNDLES_FOLDER;

import inc.brocorp.i18n.LocaleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController {

    private static final String FXML_MENU = "..//fxml/MainMenu.fxml";
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    public void initialize() {
        fxmlLoader.setLocation(getClass().getResource(FXML_MENU));
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
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
