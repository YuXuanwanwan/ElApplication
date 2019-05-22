package com.example.elapplication.ControlTable.Li;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.elapplication.R;

public class m78Activity extends AppCompatActivity {
    private CylinderImageView2 cylinderImageView2;
    private ImageButton btnpop,btn_scole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m78);
        cylinderImageView2 = (CylinderImageView2) findViewById(R.id.cylinder_universe1);
        btnpop = (ImageButton) findViewById(R.id.btn_mapagain);
        btn_scole = (ImageButton) findViewById(R.id.btn_scolopeagain);

        setButtonStateChangeListener(btnpop);
        setButtonStateChangeListener1(btn_scole);

        btnpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.popupwindow_map, null);
                final PopupWindow popmap = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                popmap.showAsDropDown(btnpop, 0, 0);
                ImageButton pop_dismiss=(ImageButton)view.findViewById(R.id.btn_return);
                pop_dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popmap.dismiss();
                    }
                });
                setButtonStateChangeListener1(pop_dismiss);

                ImageButton start_universe = (ImageButton) view.findViewById(R.id.start_universe);
                setButtonStateChangeListener(start_universe);
                start_universe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intenttoM78=new Intent(m78Activity.this, MainActivity.class);
                        startActivity(intenttoM78);

                    }
                });
                ImageButton m78universe=(ImageButton)view.findViewById(R.id.universe_m78);
                setButtonStateChangeListener(m78universe);
                m78universe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popmap.dismiss();
                    }
                });
            }
        });

        btn_scole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttosclope=new Intent(m78Activity.this,InTheScolpe.class);
                startActivity(intenttosclope);
            }
        });
    }

    public void onResume() {
        super.onResume();
        cylinderImageView2.resume();
    }

    public void onPause() {
        super.onPause();
        cylinderImageView2.pause();
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



}
