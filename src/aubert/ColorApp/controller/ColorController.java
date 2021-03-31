package aubert.ColorApp.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import aubert.ColorApp.model.Color;
import javafx.scene.control.TextField;

public class ColorController implements Initializable {

    private Color color=new Color(153,51,102);

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
        textFieldHexValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    if (newValue.matches("#[A-F0-9]{6}")) {
                        color.setHexValue(newValue);
                        textFieldRedValue.setText(String.valueOf(color.getRed()));
                        textFieldGreenValue.setText(String.valueOf(color.getGreen()));
                        textFieldBlueValue.setText(String.valueOf(color.getBlue()));
                        System.out.println("new value = " + color.getHexValue());
                    }
                })
        );

        textFieldRedValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    int newRed = Integer.parseInt(newValue);
                    if (newRed>=0 && newRed<=255){
                        color.setRed(newRed);
                        textFieldGreenValue.setText(String.valueOf(color.getGreen()));
                        textFieldBlueValue.setText(String.valueOf(color.getBlue()));
                        textFieldHexValue.setText(color.getHexValue());
                    }
                })
        );
    }
}
