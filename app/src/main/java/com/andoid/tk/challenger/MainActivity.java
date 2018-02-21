package com.andoid.tk.challenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View v)
    {
        Intent newActivity = new Intent(MainActivity.this,Main2Activity.class);
        EditText startValue = findViewById(R.id.startValue);
        EditText stopValue = findViewById(R.id.stopValue);

        String startString = startValue.getText().toString();
        String stopString = stopValue.getText().toString();

        if(startString!=""&&stopString!="")
        {
            newActivity.putExtra("start",startString);
            newActivity.putExtra("stop",stopString);

            startActivity(newActivity);
        }

    }
}
