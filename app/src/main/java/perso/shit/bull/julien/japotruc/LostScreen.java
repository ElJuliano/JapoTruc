package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.utils.Constants;

public class LostScreen extends SwitchActivity {

    private Logger logger = Logger.getLogger("LostLogger");

    private static final String NULL_NULL_NULL = "null..null..null";

    private static final String POOR_GUY_SENTENCE = "You suck dude!";

    private static final String CAN_DO_BETTER_SENTENCE = "Still not there mate...";

    private static final String GETTING_BETTER_SENTENCE = "Hey hey, looks like you re getting it !";

    private static final String REACHING_THE_TOP_SENTENCE = "Success's coming fella";

    private static final String MASTER_SENTENCE = "All right, you are good. Well done !!";

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lost_screen);
        Intent intent = getIntent();
        score = intent.getIntExtra(Constants.CURRENT_SCORE, 0);
        populateScore();
        populateSentence();
    }

    public void populateScore(){
        TextView scoreText = (TextView)findViewById(R.id.scoreTextView);
        scoreText.setText(Integer.toString(score));
    }

    private void populateSentence() {
        TextView conditional = (TextView)findViewById(R.id.conditionalText);
        conditional.setText(getSentence(score));
    }
    private String getSentence(int score) {
        if(score == 0){
            return NULL_NULL_NULL;
        }
        if( score < 5 ) {
            return POOR_GUY_SENTENCE;
        }
        else if(score < 10) {
            return CAN_DO_BETTER_SENTENCE;
        }
        else if(score < 15) {
            return GETTING_BETTER_SENTENCE;
        }
        else if ( score < 20) {
            return REACHING_THE_TOP_SENTENCE;
        }
        else {
            return MASTER_SENTENCE;
        }
    }

    /**
     * Go to high score screen
     */
    public void switchToHighScores(View view) {
        if(checkNameIsSet()) {
            Intent intent = new Intent(this, HighScores.class);
            startActivity(intent);
            logger.log(Level.INFO, "### Going to Highcores from Lost ###");
        }
    }

    @Override
    public void switchToWelcome(View view) {
        checkNameIsSet();
        super.switchToWelcome(view);
    }

    @Override
    public void switchToGame(View view) {
        checkNameIsSet();
        super.switchToGame(view);
    }

    private boolean checkNameIsSet() {
        EditText nameText = (EditText)findViewById(R.id.nameField);
        TextView enterName = (TextView)findViewById(R.id.enterName);

        if(nameText.getText().length() == 0) {
            if (enterName.getText().toString().indexOf("mandatory") < 0) {
                enterName.append(" (mandatory)");
            }
            enterName.setTextColor(Color.RED);
            return false;
        }
        else {
            enterName.setTextColor(Color.BLACK);
            //Write score in DB
            getWriter().writeScore(nameText.getText().toString(), score);
            return true;
        }
    }
}
