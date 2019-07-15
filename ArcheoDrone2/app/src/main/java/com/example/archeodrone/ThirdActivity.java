/**
 * @author MODESTE Sullyvan
 */
package com.example.archeodrone;

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

        /**
         * Set window fullscreen and remove title bar, and force landscape orientation
         */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent intent = getIntent();

        videoView = (VideoView) findViewById(R.id.videoAdmin);
        Uri uri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI( uri );
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
