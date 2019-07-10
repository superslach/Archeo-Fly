package com.example.archeodrone;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {
    String retour;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set window fullscreen and remove title bar, and force landscape orientation
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent intent = getIntent();

        /*
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retour = "Ok, retour éffectué !";
                intent.putExtra("img", retour);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        */
        videoView = (VideoView) findViewById(R.id.videoAdmin);
        Uri uri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.videoadmin);
        videoView.setVideoURI( uri );
    }

    @Override
    protected  void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.suspend();
    }
}
