package com.example.elapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;

public class PlanetC extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_c);

        /**
         * 添加内容 ——> 星球介绍
         */
        TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1_c, tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2_c, tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1_c").setIndicator("概述").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("tab2_c").setIndicator("特点").setContent(R.id.right));

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);//获取布局管理器
        AnimationDrawable animationDrawable = (AnimationDrawable)relativeLayout.getBackground();//获取动画资源
        animationDrawable.start();

        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlanetC.this,"back",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
