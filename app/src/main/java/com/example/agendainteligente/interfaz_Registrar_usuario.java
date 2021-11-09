package com.example.agendainteligente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class interfaz_Registrar_usuario extends AppCompatActivity {

    private static final int RECOGNIZE_SPEECH_ACTIVITY2 = 1;
    String clave_usu = "";
    String key = "";
    String contra = "";
    String varClave = "";
    TextView password_capturada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz__registrar_usuario);
        password_capturada = findViewById(R.id.id_password_captured);


    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY2:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);
                    varClave=strSpeech2Text;
                    int count = varClave.length();
                    String clave="*";
                    String as;
                    for(int i=1; i==count;i++)
                    {
                        clave=clave+clave;
                    }
                    as=clave;
                    password_capturada.setText(as);

                }
                break;
            default:
                break;
        }
    }
    public void onClickImgBtnHablarclave(View view) {
        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // Configura el Lenguaje (Español-México)
        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY2);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Tú dispositivo no soporta el reconocimiento por voz",Toast.LENGTH_LONG);

        }
    }


}