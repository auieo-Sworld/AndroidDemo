package com.cuiyu.cuiyuanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
  private ImageView framAnim;
    private AnimationDrawable animationDrawable;
    private RelativeLayout rlQqtrembleAni;
    private Button btnRotate,btnTranslate,btnScale,btnAlpha;
    private boolean flag = true;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        framAnim = findViewById(R.id.iv_frame_anim);
        btnRotate = findViewById(R.id.btn_one);
        btnTranslate = findViewById(R.id.btn_two);
        btnScale = findViewById(R.id.btn_three);
        btnAlpha = findViewById(R.id.btn_four);
        iv = findViewById(R.id.iv);
        final Animation rotate = AnimationUtils.loadAnimation(this,
                R.anim.anim_rotate);
        final Animation translate = AnimationUtils.loadAnimation(this,
                R.anim.anim_translate);
        final Animation scale = AnimationUtils.loadAnimation(this,
                R.anim.anim_scale);
        final Animation alpha = AnimationUtils.loadAnimation(this,
                R.anim.anim_alpha);
         btnAlpha.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 iv.startAnimation(alpha);
             }
         });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(scale);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(rotate);
            }
        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(translate);
            }
        });
        animationDrawable = (AnimationDrawable) framAnim.getBackground();
        animationDrawable.start();

        rlQqtrembleAni = findViewById(R.id.rl_qqtremble_ani);
        final QQTrembleAni tremble = new QQTrembleAni();
        tremble.setDuration(800);
        tremble.setRepeatCount(2);
        rlQqtrembleAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              rlQqtrembleAni.startAnimation(tremble);
            }
        });
    }
}
