package org.openjfx;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.openjfx.configuration.Configuration;
import org.openjfx.services.ChatShipService;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private TextArea messageArea;
    @FXML
    private TextField inputTextArea;
    private ChatShipService chatShipService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//inicializa vista
        chatShipService = new ChatShipService();
        chatShipService.setMessage("Hi world");
        chatShipService.start();
    }



    @FXML
    private void handleKeyReleased(KeyEvent keyEvent){
        if(keyEvent.getCode()== KeyCode.ENTER){
            chatShipService.setMessage(inputTextArea.getText());
            chatShipService.restart();
            inputTextArea.setText("");
        }
    }//keyPressed - when the key goes down
    //keyReleased - when the key comes up
    //keyTyped - when the unicode character represented by this key is sent by the keyboard to system input.

}