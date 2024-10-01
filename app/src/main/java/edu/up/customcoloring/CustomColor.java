package edu.up.customcoloring;

public class CustomColor {
    public int red;
    public int green;
    public int blue;

    public CustomColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // https://stackoverflow.com/a/60684467
    public int getColor() {
        int hexVal = 0;
        hexVal += red;
        hexVal = hexVal << 8;
        hexVal += green;
        hexVal = hexVal << 8;
        hexVal += blue;

        return hexVal;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
