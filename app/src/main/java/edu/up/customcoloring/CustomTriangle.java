package edu.up.customcoloring;

import android.graphics.Canvas;
import android.graphics.Path;

/**
 * <!-- class CustomRect -->
 *
 * This class defines a custom drawing element that is a triangle.
 *
 * @author Arnaj Sandhu
 * @version Fall 2024
 * @see CustomElement
 *
 */
public class CustomTriangle extends CustomElement {

    private int ax;
    private int ay;
    private int bx;
    private int by;
    private int cx;
    private int cy;

    public CustomTriangle(String name, int color, int ax, int ay, int bx, int by, int cx, int cy) {
        super(name, color);
        this.ax = ax;
        this.ay = ay;
        this.by = by;
        this.bx = bx;
        this.cx = cx;
        this.cy = cy;
    }

    @Override
    public void drawMe(Canvas canvas) {
        /**
         External Citation
         Date: 23 September 2024
         Problem: Needed a way to make a triangle
         Resource:
         https://stackoverflow.com/a/22690364
         Solution: I used the example code from this comment
         */
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(ax, ay);
        path.lineTo(bx, by);
        path.lineTo(cx, cy);
        path.close();

        canvas.drawPath(path, myPaint);
        path.reset();
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void drawHighlight(Canvas canvas) {

    }
}
