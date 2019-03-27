package inc.brocorp;

import inc.brocorp.i18n.Language;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class gameApp extends Application {

    @FXML
    private ComboBox<Language> langComboBox = new ComboBox<Language>();



    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableList<Language> list = Language.getLanguageList();
        langComboBox.setItems(list);
        langComboBox.getSelectionModel().select(1);

        Parent root = FXMLLoader.load(getClass().getResource("fxml/gameApp.fxml"));
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
