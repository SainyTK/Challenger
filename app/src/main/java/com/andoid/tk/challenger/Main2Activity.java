package com.andoid.tk.challenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends Activity {

    int r;
    int p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView startValue = findViewById(R.id.startValue);
        TextView stopValue = findViewById(R.id.stopValue);

        Intent activity1 = getIntent();
        String startString = activity1.getStringExtra("start");
        String stopString = activity1.getStringExtra("stop");

        startValue.setText(startString);
        stopValue.setText(stopString);

        int start = Integer.parseInt(startString);
        int stop = Integer.parseInt(stopString);
        int num = stop - start;

        r = (int) (num*Math.random()+start);

    }

    public  void answer(View v)
    {
        EditText inputField = findViewById(R.id.inputField);
        TextView roundValue = findViewById(R.id.roundValue);
        TextView player = findViewById(R.id.player);
        TextView hint = findViewById(R.id.hint);

        String ans = inputField.getText().toString();
        String playerNum = player.getText().toString();
        String round = roundValue.getText().toString();

        if(ans!="")
        {
            int ansVal = Integer.parseInt(ans);
            int roundVal = Integer.parseInt(round);
            if(p==0)
            {
                player.setText(String.valueOf(r));
                switch (checkAns(ansVal,r))
                {
                    case 0: win("PLAYER 1",round); break;
                    case 1: hint.setText("Smaller!!"); break;
                    case 2: hint.setText("Bigger!!"); break;
                }
                p=1;
                player.setText("P2 : ");
            }
            else if(p==1)
            {
                switch (checkAns(ansVal,r))
                {
                    case 0: win("PLAYER 2",round); break;
                    case 1: hint.setText("Smaller!!"); break;
                    case 2: hint.setText("Bigger!!"); break;
                }
                p=0;
                player.setText("P1 : ");
                roundVal++;
                roundValue.setText(String.valueOf(roundVal));
            }
        }
    }

    public int checkAns(int x,int ans)
    {
        if(x == ans)
        {
            return 0;
        }
        else if(x>ans)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    public void win(String player,String round)
    {
        Intent newActivity = new Intent(Main2Activity.this,Main3Activity.class);

        newActivity.putExtra("player",player);
        newActivity.putExtra("round",round);

        startActivity(newActivity);
    }

    public void back(View v)
    {
        Intent newActivity = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(newActivity);
    }

}
