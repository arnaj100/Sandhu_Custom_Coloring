package edu.up.customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * <!-- class MainActivity -->
 *
 * This is the Main Class
 *
 * @author Arnaj Sandhu
 * @version Fall 2024
 *
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     External Citation
     Date: 23 September 2024
     Problem: Could not figure out how to get my drawings to appear
     Resource:
     example code posted on moodle webpage
     Solution: I used the example code from the MainActivity.java file on the moodle page
     */
    protected void onCreate_drawing(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.id.drawing);
    }
}