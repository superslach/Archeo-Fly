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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.VideoView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    /**
     * Attributs des éléments de l'interface
     *      VideoView - Permet l'affichage de vidéo
     */
    String retour;
    private VideoView videoView;
    private ListView listView;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         *  Set window fullscreen and remove title bar, and force landscape orientation
         */
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

        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Lorem Ipsum");
        arrayList.add("Lorem Ipsum");
        arrayList.add("Lorem Ipsum");
        arrayList.add("Lorem Ipsum");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
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
