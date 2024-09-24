package edu.up.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class HouseCanvas extends SurfaceView {
    CustomRect door;
    CustomRect leftWindow;
    CustomRect rightWindow;
    CustomRect house;
    CustomRect chimney;
    CustomCircle doorknob;
    CustomTriangle roof;

    public HouseCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(0xFFFFFFFF);

        door = new CustomRect("door", 0xFFFF0000, 925, 700, 1075, 950);
        leftWindow = new CustomRect("leftWindow", 0xFFFFFFFF, 700, 550, 800, 700);
        rightWindow = new CustomRect("rightWindow", 0xFFFFFFFF, 1200, 550, 1300, 700);
        house = new CustomRect("house", 0xFF000000, 600, 400, 1400, 950);
        doorknob = new CustomCircle("doorknob", 0xFF00AAAA, 1040, 850, 10);
        roof = new CustomTriangle("roof", 0xFF000000, 585, 400, 1415, 400, 1000, 0);
        chimney = new CustomRect("chimney", 0xFF964B00, 1150, 75, 1225, 400);
    }
    @Override
    protected void onDraw(Canvas canvas){
        chimney.drawMe(canvas);
        house.drawMe(canvas);
        roof.drawMe(canvas);
        door.drawMe(canvas);
        leftWindow.drawMe(canvas);
        rightWindow.drawMe(canvas);
        doorknob.drawMe(canvas);
    }
}
