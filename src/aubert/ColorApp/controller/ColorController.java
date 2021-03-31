package aubert.ColorApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import aubert.ColorApp.model.Color;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
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
    @FXML
    private Slider redSlider = new Slider();
    @FXML
    private Slider blueSlider = new Slider();
    @FXML
    private Slider greenSlider = new Slider();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textFieldHexValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("HEX", Integer.valueOf(newValue));
                    System.out.println("new value = " + color.getHexValue());
                })
        );

        textFieldRedValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("RED",Integer.valueOf(newValue));
                })
        );

        textFieldGreenValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("GREEN",Integer.valueOf(newValue));
                })
        );

        textFieldBlueValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("BLUE",Integer.valueOf(newValue));
                })
        );

        redSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("RED", newValue.intValue());
                })
        );

        blueSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("BLUE",newValue.intValue());
                })
        );

        greenSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("GREEN",newValue.intValue());
                })
        );
    }

    private void updateAllColors(){
        textFieldRedValue.setText(String.valueOf(color.getRed()));
        textFieldGreenValue.setText(String.valueOf(color.getGreen()));
        textFieldBlueValue.setText(String.valueOf(color.getBlue()));
        textFieldHexValue.setText(color.getHexValue());
    }

    private void updateOneColor(String colorCode, int value){
        switch (colorCode){
            case "RED":
                color.setRed(value);
                redSlider.setValue(value);
                break;
            case "GREEN":
                color.setGreen(value);
                greenSlider.setValue(value);
                break;
            case "BLUE":
                color.setBlue(value);
                blueSlider.setValue(value);
                break;
            case "HEX":
                color.setHexValue(color.getHexValue());
                updateAllColors();
                break;
        }
        updateAllColors();
    }
}
