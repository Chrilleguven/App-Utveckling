package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_start, button_answer0, button_answer1, button_answer2, button_answer3;
    TextView textView_timer, textView_question, textView_score, textView_message;
    ProgressBar progressBar;

    Game game = new Game();

    int seconds = 100;

    CountDownTimer timer = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            seconds--;
            textView_timer.setText(Integer.toString(seconds) + "sec");
            progressBar.setProgress(100 - seconds);
        }

        @Override
        public void onFinish() {

            button_answer0.setEnabled(false);
            button_answer1.setEnabled(false);
            button_answer2.setEnabled(false);
            button_answer3.setEnabled(false);

            textView_message.setText("Time is up!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        button_answer0 = findViewById(R.id.button_answer0);
        button_answer1 = findViewById(R.id.button_answer1);
        button_answer2 = findViewById(R.id.button_answer2);
        button_answer3 = findViewById(R.id.button_answer3);

        textView_message = findViewById(R.id.textView_message);
        textView_question = findViewById(R.id.textView_question);
        textView_score = findViewById(R.id.textView_score);
        textView_timer = findViewById(R.id.textView_timer);

        progressBar = findViewById(R.id.progressBar);

        textView_timer.setText("0 Sec");
        textView_question.setText("");
        textView_score.setText("0 pts");
        textView_message.setText("Press Go");

       View.OnClickListener startButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button start_button = (Button) view;
                start_button.setVisibility(View.INVISIBLE);
                nextTurn();
                timer.start();
            }
        };

       View.OnClickListener answerButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button buttonClicked = (Button) view;

                int selectedButton = Integer.parseInt(buttonClicked.getText().toString());

                game.checkAnswer(selectedButton);
                textView_score.setText(Integer.toString(game.getScore()));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonListener);
        button_answer0.setOnClickListener(answerButtonListener);
        button_answer1.setOnClickListener(answerButtonListener);
        button_answer2.setOnClickListener(answerButtonListener);
        button_answer3.setOnClickListener(answerButtonListener);

    }

    private void nextTurn(){

        game.makeNewQuestion();
        int [] answer = game.getCurrentQuestion().getAnswerArray();
        button_answer0.setText(Integer.toString(answer[0]));
        button_answer1.setText(Integer.toString(answer[1]));
        button_answer2.setText(Integer.toString(answer[2]));
        button_answer3.setText(Integer.toString(answer[3]));

        button_answer0.setEnabled(true);
        button_answer1.setEnabled(true);
        button_answer2.setEnabled(true);
        button_answer3.setEnabled(true);

        textView_question.setText(game.getCurrentQuestion().getQuestionPhrase());
        textView_message.setText(game.getNumberCorrect() + "/" + (game.getTotalQuestions() - 1));
    }
}