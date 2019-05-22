package com.example.elapplication.ControlTable.Li;

import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.elapplication.R;

public class InTheScolpe extends AppCompatActivity {
    private ImageButton btn1,btn2,btn3,btn4,btn5;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_the_scolpe);
        btn1=(ImageButton)findViewById(R.id.s1);
        btn2=(ImageButton)findViewById(R.id.s2);
        btn3=(ImageButton)findViewById(R.id.s3);
        btn4=(ImageButton)findViewById(R.id.s4);
        btn5=(ImageButton)findViewById(R.id.s5);

        setButtonStateChangeListener(btn1);
        setButtonStateChangeListener1(btn2);
        setButtonStateChangeListener1(btn3);
        setButtonStateChangeListener1(btn4);
        setButtonStateChangeListener(btn5);

        imageView=(ImageView)findViewById(R.id.temptele);
        imageView.bringToFront();
    }

    private final static float[] BUTTON_PRESSED = new float[] {
            1,0 ,0, 0,-50,
            0, 1, 0, 0, -50,
            0, 0, 1, 0,-50,
            0, 0, 0, 1, 0 };
    /**
     * 按钮恢复原状
     */
    private final static float[] BUTTON_RELEASED = new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0 };


    private static final View.OnTouchListener touchListener1 = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            BitmapDrawable drawable = (BitmapDrawable) v.getBackground();
            Bitmap bitmap = drawable.getBitmap();
            if (bitmap.getPixel((int) (event.getX()), ((int) event.getY())) == 0) {
                return true;
            } else {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_PRESSED));
                    v.setBackgroundDrawable(v.getBackground());
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_RELEASED));
                    v.setBackgroundDrawable(v.getBackground());

                }
                return false;

            }
        }
    };
    public static void setButtonStateChangeListener1(View v) {
        v.setOnTouchListener(touchListener1);
    }
    private static final View.OnTouchListener touchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_PRESSED));
                v.setBackgroundDrawable(v.getBackground());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(BUTTON_RELEASED));
                v.setBackgroundDrawable(v.getBackground());

            }
            return false;

        }

    };
    public static void setButtonStateChangeListener(View v) {
        v.setOnTouchListener(touchListener);
    }
}
