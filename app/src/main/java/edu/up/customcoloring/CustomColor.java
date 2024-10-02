package edu.up.customcoloring;

import android.graphics.Color;

/**
 * <!-- class CustomColor -->
 *
 * This class defines a custom color that makes it easier to interact with the colors of CustomElement
 *
 * @author Arnaj Sandhu
 * @version Fall 2024
 *
 */

public class CustomColor {
    public int red;
    public int green;
    public int blue;

    public CustomColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getColor() {
        return Color.rgb(red, green, blue);
    }
}
