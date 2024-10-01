package edu.up.customcoloring;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HouseController implements View.OnTouchListener{

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
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        hm.x = motionEvent.getX();
        hm.y = motionEvent.getY();

        if (curElement != null) {
            curElement.setText(hm.cur.getName());
        }

        hc.invalidate();
        return true;
    }
}
