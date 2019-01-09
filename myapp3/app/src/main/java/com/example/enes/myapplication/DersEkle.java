package com.example.enes.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DersEkle extends Tracker {
    Button ekle;
    EditText lesson=null;

    EditText mEditTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_ekle);

        mEditTextInput = (EditText) findViewById(R.id.minute_input);
        Intent intent2 = getIntent();
        String minute_input = intent2.getStringExtra("minute_input");
        mEditTextInput.setText(minute_input);




        lesson = (EditText) findViewById(R.id.editText);

        ekle = (Button) findViewById(R.id.button_ekle);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("lesson", lesson.getText().toString());
                startActivity(intent);



                 String input = mEditTextInput.getText().toString();
                 if (input.length() == 0) {
                     Toast.makeText(DersEkle.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                     return;
                 }

                 long millisInput = Long.parseLong(input) * 60000;
                 if (millisInput == 0) {
                     Toast.makeText(DersEkle.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                     return;
                 }

                 setTime(millisInput);
                 mEditTextInput.setText("");

         }
        });
    }
}