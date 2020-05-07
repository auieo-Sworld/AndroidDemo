package com.cuiyu.cuiyuanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
  private ImageView framAnim;
    private AnimationDrawable animationDrawable;
    private RelativeLayout rlQqtrembleAni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        framAnim = findViewById(R.id.iv_frame_anim);
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
