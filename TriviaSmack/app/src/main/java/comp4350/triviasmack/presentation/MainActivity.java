package comp4350.triviasmack.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import comp4350.triviasmack.R;
import comp4350.triviasmack.business.GameController;

public class MainActivity extends AppCompatActivity {

    private final int MAXQUESTIONS = 2;
    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameController = new GameController(MAXQUESTIONS);
        gameController.start();
    }

    public void renderQuestionPage(View v) {
        Intent QuestionPageIntent = new Intent(MainActivity.this, QuestionPageActivity.class);
        QuestionPageIntent.putExtra("gameController", gameController);
        MainActivity.this.startActivity(QuestionPageIntent);
    }
}
