/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.answeringMachine;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author MeganLandau
 */
public class AnsweringMachineApp extends Application {

    public AnsweringMachine am;
    public int tries = 3;
    Font fontAwesome;
    String imagePath = "/com/csci360/answeringMachine/images/";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        InputStream fafont = AnsweringMachineApp.class.getResourceAsStream("/com/csci360/answeringMachine/fonts/fontawesome-webfont.ttf");
        fontAwesome = Font.loadFont(fafont, 14);

        stage.setTitle("Simple Answering Machine");
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/com/csci360/answeringMachine/stylesheets/stylesheet.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
