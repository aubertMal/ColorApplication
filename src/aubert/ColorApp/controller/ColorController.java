package aubert.ColorApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import aubert.ColorApp.model.Color;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ColorController implements Initializable {

    private Color color=new Color(255,255,255);

    @FXML
    private TextField textFieldHexValue;
    @FXML
    private TextField textFieldRedValue;
    @FXML
    private TextField textFieldGreenValue;
    @FXML
    private TextField textFieldBlueValue;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Pane paneColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textFieldHexValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    if(newValue.matches("#[A-F0-9]{6}")) //on va attendre la saisie du code hexa en entier avant de le traiter
                        updateColorFromHex(newValue);
                })
        );

        textFieldRedValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    try {
                        updateOneColor("RED", Integer.valueOf(newValue));
                    } catch (NumberFormatException e){
                        System.out.println("Erreur au parsing de la chaine " + newValue);
                    }
                })
        );

        textFieldGreenValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    try {
                        updateOneColor("GREEN", Integer.valueOf(newValue));
                    } catch (NumberFormatException e){
                        System.out.println("Erreur au parsing de la chaine " + newValue);
                    }
                })
        );

        textFieldBlueValue.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    try {
                        updateOneColor("BLUE", Integer.valueOf(newValue));
                    } catch (NumberFormatException e){
                        System.out.println("Erreur au parsing de la chaine " + newValue);
                    }
                })
        );

        redSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("RED", newValue.intValue());
                })
        );

        blueSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("BLUE", newValue.intValue());
                })
        );

        greenSlider.valueProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    updateOneColor("GREEN", newValue.intValue());
                })
        );

    }

    private void updateAllColors(){
        try {
            textFieldRedValue.setText(String.valueOf(color.getRed()));
            textFieldGreenValue.setText(String.valueOf(color.getGreen()));
            textFieldBlueValue.setText(String.valueOf(color.getBlue()));
            textFieldHexValue.setText(color.getHexValue());
            redSlider.setValue(color.getRed());
            blueSlider.setValue(color.getBlue());
            greenSlider.setValue(color.getGreen());
        } catch (IllegalArgumentException e){
            System.out.println("Erreur à la mise à jour des couleurs");
        }
        paneColor.setStyle("-fx-background-color: " + color.getHexValue() + ";");
    }

    private void updateColorFromHex(String hexValue){
        try {
            color.setHexValue(hexValue);
        } catch (IllegalArgumentException e){
            System.out.println("en attente d'une valeur hexa correcte");
        }
        updateAllColors();
    }

    private void updateOneColor(String colorCode, int value){
        try {
            switch (colorCode) {
                case "RED":
                    color.setRed(value);
                    break;
                case "GREEN":
                    color.setGreen(value);
                    break;
                case "BLUE":
                    color.setBlue(value);
                    break;
            }
        } catch (IllegalArgumentException e){
            System.out.println("Le code couleur " + colorCode+ " n'est pas bon");
        }
        updateAllColors();
    }
}
