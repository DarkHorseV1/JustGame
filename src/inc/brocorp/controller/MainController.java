package inc.brocorp.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

     public void showMenu(ActionEvent ae){
        Object source = ae.getSource();
        if(!(source instanceof Button))
            return;
        Button clickedButton = (Button)source;
        if(clickedButton.getId().equals("btnRu"))
            System.out.println("rus button");
        else if(clickedButton.getId().equals("btnEn"))
            System.out.println("eng button");
        createMenu();
     }

     private void createMenu(){
         try{
             Stage stage = new Stage();
             Parent root = FXMLLoader.load(getClass().getResource("..//fxml/MainMenu.fxml"));
             Scene scene = new Scene(root,350,375);
             stage.setTitle("Main menu");
             stage.setResizable(false);
             stage.setScene(scene);
             stage.show();
         }
         catch(IOException e){
            e.printStackTrace();
         }
     }

}
