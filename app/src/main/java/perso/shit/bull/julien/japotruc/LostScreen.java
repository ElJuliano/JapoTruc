package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LostScreen extends switchActivity {

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
        score = intent.getIntExtra(GameScreen.CURRENT_SCORE, 0);
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
}
