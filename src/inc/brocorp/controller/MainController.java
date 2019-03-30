package inc.brocorp.controller;


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

    @FXML
    private Button btnNewGame;

    private ResourceBundle resourceBundle;
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        fxmlLoader.setLocation(getClass().getResource("..//fxml/MainMenu.fxml"));
    }

    public void showMenu(ActionEvent ae) {
        Object source = ae.getSource();
        if (!(source instanceof Button))
            return;
        Button clickedButton = (Button) source;
        if (clickedButton.getId().equals("btnRu")) {
            fxmlLoader.setResources(ResourceBundle.getBundle("inc.brocorp.resources.Locale", new Locale("ru")));
        } else if (clickedButton.getId().equals("btnEn")) {
            fxmlLoader.setResources(ResourceBundle.getBundle("inc.brocorp.resources.Locale", new Locale("en")));
        }
        createMenu();
    }

    private void createMenu() {
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 275, 375);
            Stage stage = new Stage();
            stage.setTitle(fxmlLoader.getResources().getString("menu.title"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException o){
            o.printStackTrace();
        }
    }
}
