package edu.up.customcoloring;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * <!-- class HouseController -->
 *
 * This class is the controller for the interaction between the GUI elements and the CustomElements
 *
 * @author Arnaj Sandhu
 * @version Fall 2024
 *
 */

public class HouseController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener{

    private HouseCanvas hc;
    private HouseModel hm;
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private TextView curElement;

    public HouseController(HouseCanvas hc, SeekBar redSeekBar, SeekBar greenSeekBar, SeekBar blueSeekBar, TextView curElement){
        this.hc = hc;
        this.redSeekBar = redSeekBar;
        this.greenSeekBar = greenSeekBar;
        this.blueSeekBar = blueSeekBar;
        this.curElement = curElement;
        hm = this.hc.getHm();

        //set the listener for the SeekBars
        redSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            // get the current touch position and set the current elements based on it
            hc.setCurElement((int) motionEvent.getX(), (int) motionEvent.getY());

            // set the TextView and SeekBars based on the current element
            curElement.setText(hm.cur.getName());
            redSeekBar.setProgress(hm.cur.getColor().red);
            greenSeekBar.setProgress(hm.cur.getColor().green);
            blueSeekBar.setProgress(hm.cur.getColor().blue);

            hc.invalidate();
            return true;
        }
        return false;
    }

    // set the color of the current element when the Seekbar progress is initiated by the user
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (hm.cur != null & b) {
            CustomColor newColor = new CustomColor(redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress());
            hm.cur.setColor(newColor);
        }
        hc.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
