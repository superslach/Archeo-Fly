package com.example.archeodrone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static int REQ_IMG_SECONDACTIVITY = 1;
    private TextView mGreetingText;
    private EditText mLoginInput;
    private EditText mPasswordInput;
    private Button mLoginButton;
    private Button mViewerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mLoginInput = (EditText) findViewById(R.id.activity_main_log_input);
        mPasswordInput = (EditText) findViewById(R.id.activity_main_password_input);
        mLoginButton = (Button) findViewById(R.id.activity_main_login_btn);
        mViewerButton = (Button) findViewById(R.id.activity_main_viewver_btn);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mLoginInput.getText().toString();
                String pass = mPasswordInput.getText().toString();
                if (name.equals("Admin") && pass.equals("Admin")) {
                    Toast.makeText(getApplication(),"Connexion Ok",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivityForResult(intent, REQ_IMG_SECONDACTIVITY);
                }
                else {
                    Toast.makeText(getApplication(),"Login ou Mot de passe Incorrect" + name,Toast.LENGTH_LONG).show();
                    //startActivity(intent);
                }
            }
        }); //Vérification du champs text

        mViewerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQ_IMG_SECONDACTIVITY) {
            if (resultCode == RESULT_OK){
                Bundle bundle = data.getExtras(); // Récupération de mon intent
                traitement(bundle);
            }
        }
    }

    public void traitement(Bundle bundle){
        String retour = bundle.getString("img");
        Toast.makeText(getApplication(), "Retour : " + retour, Toast.LENGTH_LONG).show();
    }
}
