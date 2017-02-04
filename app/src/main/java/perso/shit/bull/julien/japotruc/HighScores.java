package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import perso.shit.bull.julien.japotruc.sqlite.ScoreBean;

public class HighScores extends AppCompatActivity {

    private perso.shit.bull.julien.japotruc.logic.HighScores highScore;

    private List<ScoreBean> scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.highScore = new perso.shit.bull.julien.japotruc.logic.HighScores();

        setContentView(R.layout.activity_high_scores);

        Intent intent = getIntent();
        scoreList = (List<ScoreBean>)intent.getSerializableExtra(WelcomeScreen.HIGH_SCORES);
        System.out.println(scoreList.toString());
        displayScoreList();

    }

    private void displayScoreList() {
        TableLayout layout = (TableLayout)findViewById(R.id.myTableLayout);
        for(ScoreBean score : scoreList){
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

            /* Create a TextView to be the user id container */
            TextView userName = new TextView(this);
            userName.setText(score.getUserName().toUpperCase());
            userName.setTextColor(Color.RED);
            userName.setGravity(Gravity.LEFT);
            userName.setBackgroundResource(R.drawable.cell_shape);
            userName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            /* Create a TextView to be the score container */
            TextView scoreInt = new TextView(this);
            scoreInt.setText(score.getScore().toString().toUpperCase());
            scoreInt.setGravity(Gravity.CENTER);
            scoreInt.setBackgroundResource(R.drawable.cell_shape);
            scoreInt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            /* Add Button to row. */
            tr.addView(userName);
            tr.addView(scoreInt);
            /* Add row to TableLayout. */
            //layout.setBackgroundResource(R.drawable.sf_gradient_03);
            layout.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

    }

    private void prepareMyTableLayout(){
        TableLayout layout = (TableLayout)findViewById(R.id.myTableLayout);
        for(Map.Entry<String,String> raw : highScore.getMapScore().entrySet()){
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            /* Create a TextView to be the user id container */
            TextView userName = new TextView(this);
            userName.setText(raw.getKey().toUpperCase());
            userName.setTextColor(Color.RED);
            userName.setGravity(Gravity.CENTER);
            userName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            /* Create a TextView to be the score container */
            TextView score = new TextView(this);
            score.setText(raw.getValue().toUpperCase());
            score.setGravity(Gravity.CENTER);
            score.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
            /* Add Button to row. */
            tr.addView(userName);
            tr.addView(score);
            /* Add row to TableLayout. */
            //layout.setBackgroundResource(R.drawable.sf_gradient_03);
            layout.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}
