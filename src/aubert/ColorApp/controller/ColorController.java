package aubert.ColorApp.controller;

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
                    updateOneColor("HEX", newValue);
                    System.out.println("new value = " + color.getHexValue());
                })
        );

        textFieldRedValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("RED",newValue);
                })
        );

        textFieldGreenValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("GREEN",newValue);
                })
        );

        textFieldBlueValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("BLUE",newValue);
                })
        );
    }

    private void updateAllColors(){
        textFieldRedValue.setText(String.valueOf(color.getRed()));
        textFieldGreenValue.setText(String.valueOf(color.getGreen()));
        textFieldBlueValue.setText(String.valueOf(color.getBlue()));
        textFieldHexValue.setText(color.getHexValue());
    }

    private void updateOneColor(String colorCode, String value){
        switch (colorCode){
            case "RED":
                int newRed = Integer.parseInt(value);
                color.setRed(newRed);
                break;
            case "GREEN":
                int newGreen = Integer.parseInt(value);
                color.setGreen(newGreen);
                break;
            case "BLUE":
                int newBlue = Integer.parseInt(value);
                color.setBlue(newBlue);
                break;
            case "HEX":
                color.setHexValue(value);
                updateAllColors();
                break;
        }
        updateAllColors();
    }
}
