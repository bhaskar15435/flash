package com.wolfy007.brainteaser;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CountDownTimer your=new CountDownTimer(30000, 1000) {
        public void onTick(long milliseconduntildone) {
            TextView timer = (TextView) findViewById(R.id.counter);
            timer.setText("00:" + String.valueOf(milliseconduntildone / 1000));

        }

        public void onFinish() {
            //RelativeLayout relative=(RelativeLayout) findViewById(R.id.relativeLayout);
            //relative.setVisibility(RelativeLayout.VISIBLE);
            Button option1=(Button) findViewById(R.id.option1);
            Button option2=(Button) findViewById(R.id.option2);
            Button option3=(Button) findViewById(R.id.option3);
            Button option4=(Button) findViewById(R.id.option4);
            TextView score=(TextView)findViewById(R.id.score);
            TextView counter=(TextView) findViewById(R.id.counter);
            TextView display=(TextView) findViewById(R.id.display);
            //ImageView image=(ImageView) findViewById(R.id.imageView);
            //image.animate().scaleX(2f).scaleY(2f).setDuration(1000);
            option1.setVisibility(View.INVISIBLE);
            option2.setVisibility(View.INVISIBLE);
            option3.setVisibility(View.INVISIBLE);
            option4.setVisibility(View.INVISIBLE);
            score.setVisibility(View.INVISIBLE);
            counter.setVisibility(View.INVISIBLE);
            display.setVisibility(View.INVISIBLE);
            Button b1=(Button) findViewById(R.id.control);
            b1.setVisibility(View.INVISIBLE);
            //TextView end=(TextView) findViewById(R.id.finalscore);
            //end.setText("your score is\n"+score.getText().toString());


        }

    };

    int ans,win=0,total=0;
    boolean count=true;
    public void playIt(View view){
        total++;
        Button option1=(Button) findViewById(R.id.option1);
        Button option2=(Button) findViewById(R.id.option2);
        Button option3=(Button) findViewById(R.id.option3);
        Button option4=(Button) findViewById(R.id.option4);
        TextView display=(TextView) findViewById(R.id.display);
        TextView score=(TextView)findViewById(R.id.score);
        TextView counter=(TextView) findViewById(R.id.counter);
        Random rand1=new Random();Random rand=new Random();Random position=new Random();
        int num1=rand.nextInt(50)+1;
        int num2=rand1.nextInt(50)+1;
        int pos=position.nextInt(4)+0;
        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        option4.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        counter.setVisibility(View.VISIBLE);
        display.setText("sum of "+(String.valueOf(num1))+"+"+(String.valueOf(num2)));
        Button[] b={option1,option2,option3,option4 };
        b[pos].setText(String.valueOf(num1+num2));
        int i;
        ans=num1+num2;
        for(i=0;i<4;i++){
            Random postion1=new Random();
            int pos1=postion1.nextInt(100)+0;
            if(pos!=i){
                b[i].setText(String.valueOf(pos1));
            }
        }
        if(count){
            your.start();
            count=false;
        }

    }
    public void pressMe(View view){
        Button option1=(Button) findViewById(R.id.option1);
        Button option2=(Button) findViewById(R.id.option2);
        Button option3=(Button) findViewById(R.id.option3);
        Button option4=(Button) findViewById(R.id.option4);
        TextView score=(TextView)findViewById(R.id.score);
        TextView counter=(TextView) findViewById(R.id.counter);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        option4.setVisibility(View.INVISIBLE);
        int tag=Integer.parseInt(view.getTag().toString());
        Button[] b={option1,option2,option3,option4 };
        int answer=Integer.parseInt(b[tag].getText().toString());
        if(answer==ans){
            win++;
            score.setText(String.valueOf(win)+"/"+String.valueOf(total));

        }
        else{
            score.setText(String.valueOf(win)+"/"+String.valueOf(total));
        }

    }
    public  void endThis(View view){
        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
