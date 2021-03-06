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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.elapplication.R;

public class MainActivity extends AppCompatActivity {
    private CylinderImageView cylinderImageView;
    private FrameLayout relativeLayout_start;
    private ImageButton btnpop;
    private ImageButton btn_scole;
    private PopupWindow popmap;
    private ImageButton pop_dismiss;
    private ImageButton start_universe;
    private ImageButton m78universe;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cylinderImageView=(CylinderImageView)findViewById(R.id.cylinder_universe);

        //开场动画
        relativeLayout_start = (FrameLayout) findViewById(R.id.Container_ControlTable);
        Animation animation_enlarge = AnimationUtils.loadAnimation(this, R.anim.enlarge);
        animation_enlarge.setFillAfter(true); //最后停留的页面是否为放大后的页面
        relativeLayout_start.startAnimation(animation_enlarge);
        Animation animation_ensmall = AnimationUtils.loadAnimation(this, R.anim.ensmall);
        animation_ensmall.setFillAfter(true);
        relativeLayout_start.startAnimation(animation_ensmall);



        //按钮点击特效
        btnpop=(ImageButton)findViewById(R.id.btn_map);
        btn_scole=(ImageButton)findViewById(R.id.btn_scolope);

        setButtonStateChangeListener(btnpop);
        setButtonStateChangeListener1(btn_scole);

        btnpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =getLayoutInflater().inflate(R.layout.popupwindow_map,null);
                popmap=new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                popmap.showAsDropDown(btnpop,0,0);

                //返回按钮
                ImageButton pop_dismiss=(ImageButton)view.findViewById(R.id.btn_return);
                pop_dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popmap.dismiss();
                    }
                });
                setButtonStateChangeListener1(pop_dismiss);

                start_universe=(ImageButton)view.findViewById(R.id.start_universe);
                setButtonStateChangeListener(start_universe);
                start_universe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popmap.dismiss();
                    }
                });
                m78universe=(ImageButton)view.findViewById(R.id.universe_m78);
                setButtonStateChangeListener(m78universe);
                m78universe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intenttoM78=new Intent(MainActivity.this, m78Activity.class);
                        startActivity(intenttoM78);
                    }
                });
            }
        });
    btn_scole.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intenttoScolpe=new Intent(MainActivity.this,InTheScolpe.class);
            startActivity(intenttoScolpe);
        }
    });

    }

    public void onResume() {
        super.onResume();
        cylinderImageView.resume();
    }

    public void onPause() {
        super.onPause();
        cylinderImageView.pause();
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