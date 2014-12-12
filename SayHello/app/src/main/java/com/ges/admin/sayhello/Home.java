package com.ges.admin.sayhello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

public class Home extends Activity {

    private TextView mTextView;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                imageButton=(ImageButton)stub.findViewById(R.id.imageButton);


                final Animation animation = new AlphaAnimation(1, 0); // Change alpha
                // from fully
                // visible to
                // invisible
                animation.setDuration(1000); // duration - half a second
                animation.setInterpolator(new LinearInterpolator()); // do not alter
                // animation
                // rate
                animation.setRepeatCount(Animation.INFINITE); // Repeat animation
                // infinitely
                animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the
                // end so the button will
                // fade back in
                imageButton.startAnimation(animation);


                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(),"Haiii",Toast.LENGTH_LONG).show();

                        Intent toNext=new Intent(Home.this,SecondActivity.class);
                        startActivity(toNext);

                    }
                });


            }
        });



    }
}
