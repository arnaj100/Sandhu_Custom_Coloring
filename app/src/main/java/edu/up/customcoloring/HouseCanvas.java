package edu.up.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * <!-- class HouseCanvas -->
 *
 * This class defines the SurfaceView to draw on
 *
 * @author Arnaj Sandhu
 * @version Fall 2024
 *
 */
public class HouseCanvas extends SurfaceView {
    CustomRect door;
    CustomRect leftWindow;
    CustomRect rightWindow;
    CustomRect house;
    CustomRect chimney;
    CustomCircle doorknob;
    CustomTriangle roof;
    CustomColor doorColor = new CustomColor(255, 0, 0);
    CustomColor leftWindowColor = new CustomColor(255, 255, 255);;
    CustomColor rightWindowColor = new CustomColor(255, 255, 255);;
    CustomColor houseColor = new CustomColor(0, 0, 0);;
    CustomColor chimneyColor = new CustomColor(150, 75, 0);;
    CustomColor doorknobColor = new CustomColor(0, 170, 170);;
    CustomColor roofColor = new CustomColor(0, 0, 0);;




    private HouseModel hm = new HouseModel();

    public HouseCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(0xFFFFFFFF);

        door = new CustomRect("door", doorColor, 925, 700, 1075, 950);
        leftWindow = new CustomRect("leftWindow", leftWindowColor, 700, 550, 800, 700);
        rightWindow = new CustomRect("rightWindow", rightWindowColor, 1200, 550, 1300, 700);
        house = new CustomRect("house", houseColor, 600, 400, 1400, 950);
        doorknob = new CustomCircle("doorknob", doorknobColor, 1040, 850, 10);
        roof = new CustomTriangle("roof", roofColor, 585, 400, 1415, 400, 1000, 0);
        chimney = new CustomRect("chimney", chimneyColor, 1150, 75, 1225, 400);
    }

    public boolean setCurElement() {
        int x = (int) hm.x;
        int y = (int) hm.y;
        if (doorknob.containsPoint(x,y)){
            hm.cur = doorknob;
            return true;
        }
        if (door.containsPoint(x,y)){
            hm.cur = door;
            return true;
        }
        if (leftWindow.containsPoint(x,y)){
            hm.cur = leftWindow;
            return true;
        }
        if (rightWindow.containsPoint(x,y)){
            hm.cur = rightWindow;
            return true;
        }
        if (house.containsPoint(x,y)){
            hm.cur = house;
            return true;
        }
        if (roof.containsPoint(x,y)){
            hm.cur = roof;
            return true;
        }
        if (chimney.containsPoint(x,y)){
            hm.cur = chimney;
            return true;
        }
        return false;
    }
    @Override
    protected void onDraw(Canvas canvas){
        setCurElement();
        chimney.drawMe(canvas);
        roof.drawMe(canvas);
        house.drawMe(canvas);
        door.drawMe(canvas);
        leftWindow.drawMe(canvas);
        rightWindow.drawMe(canvas);
        doorknob.drawMe(canvas);
    }

    public HouseModel getHm() { return hm; }
}
