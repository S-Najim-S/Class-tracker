package com.example.enes.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.GoalRow;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;

    Button goButton;

    TextView al_Lesson;
    EditText userInput;

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = (TextView) findViewById(R.id.textView2);
        View b = findViewById(R.id.goButton);
        textView2.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DersEkle.class));
                Intent i = new Intent(MainActivity.this,DersEkle.class);
                startActivity(i);
            }
        });


        al_Lesson = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String lesson = intent.getStringExtra("lesson");
        al_Lesson.setText(lesson);



        if(lesson!=null){
            textView2.setVisibility(View.VISIBLE);
            b.setVisibility(View.VISIBLE);
        }

        if(b.getVisibility()==View.VISIBLE) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Tracker.class));

                    Intent intent = new Intent(getApplicationContext(),Tracker.class);
                    intent.putExtra("lesson",al_Lesson.getText().toString());
                    startActivity(intent);
                }
            });
        }
    }
}

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/