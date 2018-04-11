/* CSCI 360 - Software Architecture
 * Dr. Jim Bowring
 *
 * Simple Answering Machine Project
 * @author: Megan Landau
 */
package com.csci360.answeringMachine;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author MeganLandau
 */
public class AppController implements Initializable {

    @FXML
    public Font fontAwesome;
    public AnsweringMachine am;

    public Pane initPane;
    public TextField nameInput;

    public Pane passcodePane;
    public Label passcodeHeading;
    public TextField passcodeInput;
    public Label warning;

    public Pane greetingPane;
    public Label greetingHeader;

    public Pane mainMenuPane;
    public Label mainMenuMessage;

    public Pane newMessagesPane;
    public ScrollPane scrollPane;

    public Pane savedMessagesPane;
    public ScrollPane savedScrollPane;

    public Pane settingsPane;

    public Pane newPasscodePane;
    public TextField newPasscodeInput;
    public Label npwarning;

    public Pane newGreetingPane;

    public Pane ownerCallerPane;
    public Label welcomeOwnerText;
    public Label leaveMessageText;

    public Pane leaveMessagePane;
    public Label leaveMessageForText;
    public TextField senderName;

    public Pane loginPane;
    public Label loginText;
    public TextField loginInput;
    public Label loginWarning;

    @FXML
    public void submitNameButtonAction(ActionEvent event) {
        String ownerName = nameInput.getText();
        am = new AnsweringMachine(ownerName);

        (initPane).setVisible(false);

        passcodeHeading.setText("Initialize Voicemail");
        (passcodePane).setVisible(true);
    }

    @FXML
    public void passcodeSubmitButtonAction(ActionEvent event) {
        String tryPasscode = passcodeInput.getText();

        if (!am.passcode.validatePasscode(tryPasscode)) {
            warning.setText("Invalid passcode. Passcodes must be exactly 4 digits long.");
        } else {
            am.setPasscode(passcodeInput.getText());
            passcodePane.setVisible(false);
            greetingPane.setVisible(true);
        }
    }

    @FXML
    public void greetingSubmitButtonAction() {
        am.recordNewGreeting();

        if (!am.isInitialized) {
            mainMenuMessage.setText("Welcome, " + am.getOwnerName() + "!");
            greetingPane.setVisible(false);
            mainMenuPane.setVisible(true);
        } else {
            greetingPane.setVisible(false);
            settingsPane.setVisible(true);
        }
    }

    @FXML
    public void populateNewMessages() {

        VBox vb = new VBox();
        vb.setStyle("-fx-background-color: white;");

        for (Message m : am.newMessages.getMessages()) {
            HBox hb = new HBox();
            hb.setPrefSize(250, 38);
            hb.setStyle("-fx-padding: 3 0 0 0; -fx-border-color: #fee4c7; -fx-border-width: 0 0 3 0; ");

            Label name = new Label(m.getSenderName());
            name.setStyle("-fx-label-padding: 0 0 0 5; -fx-text-fill: #3e7e9f;");
            name.setPrefSize(115, 25);
            name.setFont(new Font("Ubuntu", 14));
            name.setAlignment(Pos.CENTER_LEFT);
            name.setTextAlignment(TextAlignment.CENTER);

            hb.getChildren().add(name);

            Button listenButton = new Button("\uf04b");
            listenButton.setFont(fontAwesome);
            listenButton.setStyle("-fx-border-width: 0; -fx-background-color: white; -fx-effect: null; -fx-text-fill: #3e7e9f; -fx-font-family: 'FontAwesome';");
            listenButton.setAlignment(Pos.CENTER);
            listenButton.setPrefSize(30, 30);

            listenButton.setOnAction((ActionEvent event) -> {
                am.newMessages.playMessage(m.messageId);
            });
            hb.getChildren().add(listenButton);

            Button trashButton = new Button("\uf1f8");
            trashButton.setFont(fontAwesome);
            trashButton.setStyle("-fx-border-width: 0; -fx-background-color: white; -fx-effect: null; -fx-text-fill: #3e7e9f; -fx-font-family: 'FontAwesome';");
            trashButton.setAlignment(Pos.CENTER);
            trashButton.setPrefSize(30, 30);

            trashButton.setOnAction((ActionEvent event) -> {
                am.deleteMessage("New", m.getMessageId());
                populateNewMessages();
            });
            hb.getChildren().add(trashButton);

            Button saveButton = new Button("\uf0c7");
            saveButton.setFont(fontAwesome);
            saveButton.setStyle("-fx-border-width: 0; -fx-background-color: white; -fx-effect: null;-fx-text-fill: #3e7e9f; -fx-font-family: 'FontAwesome';");
            saveButton.setAlignment(Pos.CENTER);
            saveButton.setPrefSize(30, 30);

            saveButton.setOnAction((ActionEvent event) -> {
                am.moveNewMessageToSavedMessages(m.getMessageId());
                populateNewMessages();
            });

            hb.getChildren().add(saveButton);
            vb.getChildren().add(hb);
        }

        scrollPane.setFitToWidth(true);
        scrollPane.setContent(vb);
    }

    @FXML
    public void populateSavedMessages() {

        VBox vb = new VBox();
        vb.setStyle("-fx-background-color: white;");

        for (Message m : am.savedMessages.getMessages()) {
            HBox hb = new HBox();
            hb.setPrefSize(250, 38);

            hb.setStyle("-fx-padding: 3 0 0 0; -fx-border-color: #fee4c7; -fx-border-width: 0 0 3 0; ");

            Label name = new Label(m.getSenderName());
            name.setStyle("-fx-label-padding: 0 0 0 5; -fx-text-fill: #3e7e9f;");
            name.setPrefSize(155, 25);
            name.setFont(new Font("Ubuntu", 14));
            name.setAlignment(Pos.CENTER_LEFT);
            name.setTextAlignment(TextAlignment.CENTER);

            HBox.setHgrow(name, Priority.ALWAYS);
            hb.getChildren().add(name);

            Button listenButton = new Button("\uf04b");
            listenButton.setFont(fontAwesome);
            listenButton.setStyle("-fx-border-width: 0; -fx-background-color: white; -fx-effect: null; -fx-text-fill: #3e7e9f; -fx-font-family: 'FontAwesome';");
            listenButton.setAlignment(Pos.CENTER);
            listenButton.setPrefSize(30, 30);

            listenButton.setOnAction((ActionEvent event) -> {
                am.savedMessages.playMessage(m.messageId);
            });
            hb.getChildren().add(listenButton);

            Button trashButton = new Button("\uf1f8");
            trashButton.setFont(fontAwesome);
            trashButton.setStyle("-fx-border-width: 0; -fx-background-color: white; -fx-effect: null; -fx-text-fill: #3e7e9f; -fx-font-family: 'FontAwesome';");
            trashButton.setAlignment(Pos.CENTER);
            trashButton.setPrefSize(30, 30);

            trashButton.setOnAction((ActionEvent event) -> {
                am.deleteMessage("Saved", m.getMessageId());
                populateSavedMessages();
            });
            hb.getChildren().add(trashButton);

            vb.getChildren().add(hb);
        }

        savedScrollPane.setFitToWidth(true);
        savedScrollPane.setContent(vb);
    }

    @FXML
    public void goToNewMessages() {
        populateNewMessages();
        mainMenuPane.setVisible(false);
        newMessagesPane.setVisible(true);
    }

    @FXML
    public void goToSavedMessages() {
        populateSavedMessages();
        mainMenuPane.setVisible(false);
        savedMessagesPane.setVisible(true);
    }

    @FXML
    public void goToMainMenu() {
        settingsPane.setVisible(false);
        mainMenuPane.setVisible(true);
    }

    @FXML
    public void recordNewGreeting() {
        am.recordNewGreeting();
    }

    @FXML
    public void goToNewGreetings() {
        settingsPane.setVisible(false);
        newGreetingPane.setVisible(true);
    }

    @FXML
    public void playGreeting() {
        am.listenToGreeting();
    }

    @FXML
    public void goToSettings() {
        mainMenuPane.setVisible(false);
        settingsPane.setVisible(true);
    }

    @FXML
    public void goToNewPasscodePane() {
        settingsPane.setVisible(false);
        newPasscodePane.setVisible(true);
    }

    @FXML
    public void newPasscodeSubmit() {
        String tryPasscode = newPasscodeInput.getText();

        if (!am.passcode.validatePasscode(tryPasscode)) {
            npwarning.setText("Invalid passcode. Passcodes must be exactly 4 digits long.");
        } else {
            am.setPasscode(newPasscodeInput.getText());
            newPasscodePane.setVisible(false);
            settingsPane.setVisible(true);
        }
    }

    @FXML
    public void newMessagesBackToMain() {
        newMessagesPane.setVisible(false);
        mainMenuPane.setVisible(true);
    }

    @FXML
    public void savedMessagesBackToMain() {
        savedMessagesPane.setVisible(false);
        mainMenuPane.setVisible(true);
    }

    @FXML
    public void newPasscodeGoBackToSettings() {
        newPasscodePane.setVisible(false);
        settingsPane.setVisible(true);
    }

    @FXML
    public void greetingGoBackToSettings() {
        newGreetingPane.setVisible(false);
        settingsPane.setVisible(true);
    }

    @FXML
    public void goToLeaveMessagePane() {
        leaveMessageForText.setText("Please leave a message for " + am.getOwnerName() + ". Leave your name and record your message.");
        ownerCallerPane.setVisible(false);
        leaveMessagePane.setVisible(true);
    }

    @FXML
    public void leaveMessagesGoToOwnerCallerPane() {
        ownerCallerPane.setVisible(true);
        leaveMessagePane.setVisible(false);
    }

    @FXML
    public void recordNewMessage() {
        am.leaveMessage(senderName.getText());
        senderName.clear();
        ownerCallerPane.setVisible(true);
        leaveMessagePane.setVisible(false);
    }

    @FXML
    public void loginSubmitPasscode() {
        String tryPasscode = loginInput.getText();
        loginInput.clear();
        if (!am.authenticatePasscode(tryPasscode)) {
            loginWarning.setText("Invalid passcode.");
        } else {
            loginPane.setVisible(false);
            mainMenuPane.setVisible(true);
        }
    }

    @FXML
    public void loginGoToOwnerCallerPane() {
        ownerCallerPane.setVisible(true);
        loginPane.setVisible(false);
    }

    @FXML
    public void goToLoginPane() {
        loginWarning.setText("");
        loginInput.setText("");
        loginText.setText("Welcome back, " + am.getOwnerName() + ". Please enter your passcode.");
        ownerCallerPane.setVisible(false);
        loginPane.setVisible(true);
    }

    @FXML
    public void goToOwnerCallerPane() {
        welcomeOwnerText.setText("If you are " + am.getOwnerName() + ", please log in.");
        leaveMessageText.setText("Or, please leave a message for " + am.getOwnerName() + ".");
        mainMenuPane.setVisible(false);
        ownerCallerPane.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InputStream fafont = AppController.class.getResourceAsStream("/com/csci360/answeringMachine/fonts/fontawesome-webfont.ttf");
        fontAwesome = Font.loadFont(fafont, 14);

        (initPane).setVisible(true);
        passcodePane.setVisible(false);
        greetingPane.setVisible(false);
        mainMenuPane.setVisible(false);
        newPasscodePane.setVisible(false);
        newGreetingPane.setVisible(false);
        settingsPane.setVisible(false);
        ownerCallerPane.setVisible(false);
        loginPane.setVisible(false);
        leaveMessagePane.setVisible(false);
        newMessagesPane.setVisible(false);
        savedMessagesPane.setVisible(false);
    }

}
