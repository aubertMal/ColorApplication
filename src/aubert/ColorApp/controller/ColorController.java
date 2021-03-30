package aubert.ColorApp.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import aubert.ColorApp.model.Color;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ColorController implements Initializable {

    private Color color;
    @FXML
    private TextField textFieldHexValue;
    @FXML
    private TextField textFieldRedValue;
    @FXML
    private TextField textFieldGreenValue;
    @FXML
    private TextField textFieldBlueValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldHexValue.addEventHandler(KeyEvent.KEY_TYPED,(KeyEvent key) -> {
            //color.setHexValue(key.getText());
            //System.out.println(color.toString());
            System.out.println("nouvelle valeur dans hexValue");
        });
    }
}
