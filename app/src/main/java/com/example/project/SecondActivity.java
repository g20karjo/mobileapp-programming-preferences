package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences myPreferenceRef;
    SharedPreferences.Editor myPreferenceEditor;
    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPreferenceRef = getSharedPreferences("123", MODE_PRIVATE);
        //myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        button = findViewById(R.id.saveButton);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textViewTest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
                myPreferenceEditor.putString("123", editText.getText().toString());
                myPreferenceEditor.apply();
                editText.setText("");
            }
        });
    }
}