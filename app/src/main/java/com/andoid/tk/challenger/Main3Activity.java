package com.andoid.tk.challenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent previous = getIntent();
        String player = previous.getStringExtra("player");
        String round = previous.getStringExtra("round");

        TextView playerTv = findViewById(R.id.player);
        TextView roundTv = findViewById(R.id.roundValue);

        playerTv.setText(player);
        roundTv.setText(round);
    }

    public void restart(View v)
    {
        Intent firstActivity = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(firstActivity);
    }
}
