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
        String ans = previous.getStringExtra("ans");

        TextView playerTv = findViewById(R.id.player);
        TextView roundTv = findViewById(R.id.roundValue);
        TextView ansTv = findViewById(R.id.ans);

        playerTv.setText(player);
        roundTv.setText(round);
        ansTv.setText(ans);
    }

    public void restart(View v)
    {
        Intent firstActivity = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(firstActivity);
    }
}
