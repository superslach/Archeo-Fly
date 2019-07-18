/**
 * @author MODESTE Sullyvan
 */
package com.example.archeofly;

/**
 * Les différents import nécessaires pour les éléments de l'application
 *
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class ThirdActivity extends AppCompatActivity {
    /**
     * Attributs des éléments de l'interface
     *      VideoView - Permet l'affichage de vidéo
     */
    private VideoView videoView;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        /**
         * Set window fullscreen and remove title bar, and force landscape orientation
         */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final Intent intent = getIntent();
        videoView = (VideoView) findViewById(R.id.videoViewer);
        Uri uri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI( uri );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Méthode permettant de lire la vidéo (Non nécessaire pour Livestream)
     */
    @Override
    protected  void onResume() {
        super.onResume();
        videoView.start();
    }

    /**
     * Méthode permettant de mettre en pause la vidéo (Non nécessaire pour Livestream)
     */
    @Override
    protected void onPause() {
        super.onPause();
        videoView.suspend();
    }
}
