package aubert.color.model;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    public Color(int red, int green, int blue) throws IllegalArgumentException{
        if ((red <0 || red >255) || (green <0 || green >255) || (blue<0 || blue >255))
            throw  new IllegalArgumentException("la valeur spécifiée est erronnée");
        this.red = red;
        this.green = green;
        this.blue = blue;
        setHexValue("#"+(Integer.toHexString(red)+Integer.toHexString(green)+Integer.toHexString(blue)).toUpperCase());
    }

    public Color(String hexColor) {
        if (hexColor==null || !hexColor.matches("#[A-F0-9]{6}"))
            throw new IllegalArgumentException("Le code couleur est incorrect");
        this.hexValue = hexColor;
        this.red = getRedFromHex(hexColor);
        this.green = getGreenFromHex(hexColor);
        this.blue = getBlueFromHex(hexColor);
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) throws IllegalArgumentException{
        if (green < 0 || green > 255)
            throw new IllegalArgumentException("Le code vert est incorrect");
        else {
            this.green = green;
            setHexValue("#"+this.hexValue.substring(1,3)+(Integer.toHexString(green).toUpperCase())+this.hexValue.substring(5,7));
        }
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if (blue < 0 || blue > 255)
            throw new IllegalArgumentException("Le code bleu est incorrect");
        else {
            this.blue = blue;
            setHexValue("#"+this.hexValue.substring(1,5)+(Integer.toHexString(blue).toUpperCase()));
        }
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        if (hexValue == null || (!hexValue.matches("#[A-F0-9]{6}")))
            throw new IllegalArgumentException("la valeur hexa est incorrecte");
        this.hexValue = hexValue;
        this.red = getRedFromHex(hexValue);
        this.green= getGreenFromHex(hexValue);
        this.blue = getBlueFromHex(hexValue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if (red < 0 || red > 255)
            throw new IllegalArgumentException("Le code rouge est incorrect");
        else
        {
            this.red = red;
            setHexValue("#"+(Integer.toHexString(red).toUpperCase())+this.hexValue.substring(3,7));
        }
    }

    public int getRedFromHex(String hexCode){
        return Integer.parseInt(hexCode.substring(1, 3), 16);
    }

    public int getGreenFromHex(String hexCode){
        return Integer.parseInt(hexCode.substring(3, 5), 16);
    }

    public int getBlueFromHex(String hexCode){
        return Integer.parseInt(hexCode.substring(5, 7), 16);
    }

    public String toString(){
        String hexColorCode = this.hexValue;
        if (!hexColorCode.matches("#[A-F0-9]{6}"))
            throw new IllegalArgumentException("Le code couleur est incorrect");
        return "[value=" + hexColorCode + ", r=" + getRedFromHex(hexColorCode) + ", g=" + getGreenFromHex(hexColorCode) + ", b=" + getBlueFromHex(hexColorCode) + "]";
    }
}
