package com.andoid.tk.challenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


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

        final EditText inputField = findViewById(R.id.inputField);
        final TextView roundValue = findViewById(R.id.roundValue);
        final TextView player = findViewById(R.id.player);

        final TextSwitcher hint = findViewById(R.id.hint);
        hint.setFactory(mFactory);
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        hint.setInAnimation(in);
        hint.setOutAnimation(out);

        Button btn = findViewById(R.id.ansBtn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String ans = inputField.getText().toString();
                String playerNum = player.getText().toString();
                String round = roundValue.getText().toString();

                if(!ans.equals(""))
                {
                    int ansVal = Integer.parseInt(ans);
                    int roundVal = Integer.parseInt(round);
                    String hintStr = new String();
                    if(p==0)
                    {
                        player.setText(String.valueOf(r));
                        switch (checkAns(ansVal,r))
                        {
                            case 0: win("PLAYER 1",round); break;
                            case 1: hintStr = "Smaller!!";break;
                            case 2: hintStr = "Bigger!!";break;
                        }
                        p=1;
                        player.setText("P2 : ");
                    }
                    else if(p==1)
                    {
                        switch (checkAns(ansVal,r))
                        {
                            case 0: win("PLAYER 2",round); break;
                            case 1: hintStr = "Smaller!!"; break;
                            case 2: hintStr = "Bigger!!"; break;
                        }
                        p=0;
                        player.setText("P1 : ");
                        roundVal++;
                        roundValue.setText(String.valueOf(roundVal));
                    }
                    hint.setText(hintStr);
                    hint.setCurrentText(hintStr);
                }
            }
        });


    }


    private ViewFactory mFactory = new ViewFactory() {
        @Override
        public View makeView() {
            // Create a new TextView
            TextView t = new TextView(Main2Activity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(Main2Activity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };

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

        newActivity.putExtra("ans",String.valueOf(r));
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
