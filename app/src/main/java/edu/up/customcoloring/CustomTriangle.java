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

    public CustomTriangle(String name, CustomColor color, int ax, int ay, int bx, int by, int cx, int cy) {
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

    /**
     External Citation
     Date: 30 September 2024
     Problem: Needed a way to find if a triangle contains a point
     Resource:
     https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
     Solution: I used the example code from this page and adapted it slightly
     */
    @Override
    public boolean containsPoint(int x, int y) {
        CustomColor c = new CustomColor(1,1,1);
        /* Calculate area of triangle ABC */
        double A = new CustomTriangle("A", c, ax, ay, bx, by, cx, cy).getSize();

        /* Calculate area of triangle PBC */
        double A1 = new CustomTriangle("B", c, x, y, bx, by, cx, cy).getSize();

        /* Calculate area of triangle PAC */
        double A2 = new CustomTriangle("B", c, ax, ay, x, y, cx, cy).getSize();

        /* Calculate area of triangle PAB */
        double A3 = new CustomTriangle("B", c, ax, ay, bx, by, x, y).getSize();

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    /**
     External Citation
     Date: 30 September 2024
     Problem: Needed a way to get the area of a triangle
     Resource:
     https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
     Solution: I used the example code from this page and adapted it slightly
     */
    @Override
    public int getSize() {
        return (int) Math.abs((ax*(by-cy) + bx*(cy-ay)+ cx*(ay-by))/2.0);
    }

    @Override
    public void drawHighlight(Canvas canvas) {

    }
}
