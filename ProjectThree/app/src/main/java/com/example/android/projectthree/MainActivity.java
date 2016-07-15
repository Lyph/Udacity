package com.example.android.projectthree;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<quizObject> actualQuiz = new ArrayList<quizObject>();
    int score = 0;
    Boolean send =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();


        lv = (ListView) findViewById(R.id.main_list);
        lv.setAdapter(new quizAdapter(actualQuiz, this));

    }

    @Override //this keeps the app from reseting when orientation changes
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    public void submit(View view) {
        CharSequence text;
        double percent;
        for (int i = 0; i < actualQuiz.size(); i++) {
            score += actualQuiz.get(i).point;
        }
        if (actualQuiz.get(8).point== 0){score++;}      /*if custom quiz, delete this*/

        if(score<0 && score>actualQuiz.size()*-1000){text = "You didn't finish the quiz";}

        else if(score == actualQuiz.size()*-1000){text = "Wow, you didn't even do the quiz, I'm hurt.";}

        else{
           percent = (double) score/actualQuiz.size()*100; //Percent so works with any number of questions
            text = "You scored: %" + new DecimalFormat("##.##").format(percent);
        }



        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;


        Toast toast = Toast.makeText(context, text, duration);
        toast.show();



        if(send == false && score > -1){        /*if custom quiz, delete this*/
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lyphco@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Congratulation Kevin Ong");
            intent.putExtra(Intent.EXTRA_TEXT,
                    "Dear Kevin \n \n \t We would like to extend a Google internship position! We were expecting our students to hard code a couple of radio buttons and call it day. "
                            + "\n\nWe don't know how you interpreted \"hard code a couple of radio buttons\" as \"dynamically allocate questions in a ListView\" but "
                            + "we will interpret your absolute stubborness as passion, and we like passion!\n\n How you manage to use adapters and objects at this current stage is quite puzzling, "
                            + "but it probably required many hours you could have used playing Pokemon or fufilling regular bodily functions like eating. We will interpret this as dedication, "
                            + "and we like dedication! \n\nSo please, join us at Google, you will be a perfect fit! You will even get a free hat, that spins!\n \nSincerely, \nLarry Page");

            startActivity(Intent.createChooser(intent, "Email a Magical Narwhal")); //I wanted this to sound appealing

            send = true;//send only once because I'm not that annoying
        }

        score = 0;
    }


    public void initialize() { //write question here format is (question, A, B, C, D, position of correct answer), only thing you need to change.
                               // Oh also delete every function with /*if custom quiz, delete this*/

        actualQuiz.add(new quizObject("What is 0 + 0?", "0", "1", "2", "3", "a"));
        actualQuiz.add(new quizObject("What is 'U' in ASCII?", "68", "85", "67", "75", "b"));
        actualQuiz.add(new quizObject("What is my favorite animal?", "panda", "lion", "komodo dragon", "duck", "d"));
        actualQuiz.add(new quizObject("What was Google originally called?", "Googles", "Backrub", "Googol", "I'm pretty sure it was still Google", "b"));
        actualQuiz.add(new quizObject("Who is the current CEO of Google?", "Kevin Ong", "Eric Schmidt", "Sundar Pichai", "John Cena", "c"));
        actualQuiz.add(new quizObject("What was Google's first tweet that they did in binary?", "I'm Feeling Lucky", "Hello World", "We should hire Kevin Ong as our CEO", "veni, vidi, vici", "a"));
        actualQuiz.add(new quizObject("Which of these Google projects existed?", "Google Minus", "Google Deathstar", "Google Hex", "Google Weddings", "d"));
        actualQuiz.add(new quizObject("Google acquired Youtube from a meeting in where?", "Hong Kong", "Denys", "Costco", "Google HQ", "b"));
        actualQuiz.add(new quizObject("Did you google any of the answers? (I won't dock you points for being honest)", "Yes", "No", "Not telling", "No I used Bing", "a"));
        actualQuiz.add(new quizObject("What should everyone set their default browser as", "Chrome", "Firefox", "Safari", "Internet Explorer", "a"));

    }

}
