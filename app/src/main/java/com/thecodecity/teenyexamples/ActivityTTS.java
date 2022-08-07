package com.thecodecity.teenyexamples;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Locale;

public class ActivityTTS extends Activity {
    Button btnGenerateSpeech;
    EditText etText;
    TextToSpeech t1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR)
                    t1.setLanguage(Locale.CHINESE);
            }
        });

        btnGenerateSpeech = findViewById(R.id.btnGenerateSpeech);
        etText = findViewById(R.id.etText);
        btnGenerateSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etText.getText().toString();
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}
