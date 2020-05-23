package org.openjfx;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.openjfx.configuration.Configuration;
import org.openjfx.services.ChatReceiveService;
import org.openjfx.services.ChatShipService;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private TextArea messageArea;
    @FXML
    private TextField inputTextArea;
    private ChatShipService chatShipService;
    private ChatReceiveService chatReceiveService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//inicializa vista
        chatShipService = new ChatShipService();
        chatShipService.setMessage("Hi world");
        chatShipService.start();
        chatReceiveService = new ChatReceiveService();
        chatReceiveService.configure();
        chatReceiveService.start();
        chatReceiveService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                System.out.println("Handle");
                writteOnMessageArea(removeLineBreak((String) workerStateEvent.getSource().getValue()));
            }
        });
    }

    public String removeLineBreak(String string) {
        return string.replaceAll("\n", "");
    }

    public void writteOnMessageArea(String message) {
        messageArea.setText(messageArea.getText() + message  + "\n");
    }

    @FXML
    private void handleKeyReleased(KeyEvent keyEvent){
        if(keyEvent.getCode()== KeyCode.ENTER && !chatShipService.isRunning()) { //just to prevent bugs
            chatShipService.setMessage(inputTextArea.getText());
            chatShipService.restart();
             writteOnMessageArea("YO: " + inputTextArea.getText());
            inputTextArea.setText("");
        }
    }
}