package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Level;

import perso.shit.bull.julien.japotruc.logic.GameSession;

public class GameScreen extends BackToWelcome {

    private GameSession session;

    private TextView scoreTextVew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        scoreTextVew = (TextView)findViewById(R.id.scoreText);
        scoreTextVew.setText(0);
        session = new GameSession();
        setJapochiImage(session.getCurrentImage());
    }


    /**
     * Called each time the user provides a good answer
     */
    private void switchImage(){

    }

    /**
     * Check if if the picture is Chinese
     * If yes then launch display of new picture
     * If not then launch looser activity
     */
    public void checkChinese(View view){
        if(session.isCurrentJapanese()){
            //go to looser
            gotToLost(view);
        }
        else{
            // carry ON
            scoreTextVew.setText(session.getScore());
            session.nextImage();
            setJapochiImage(session.getCurrentImage());
        }
    }

    /**
     * Check if the picture is Japanese
     * If yes then launch display of new pic
     * If not then lauch looser activity
     * @param view
     */
    public void checkJapanese(View view){
        if(session.isCurrentJapanese()){
            //continue
            scoreTextVew.setText(session.getScore());
            session.nextImage();
            setJapochiImage(session.getCurrentImage());
        }
        else{
            //go to looser
            gotToLost(view);
        }
    }

    /**
     * Set the background image of the imageView to imageName
     * @param imageName
     */
    private void setJapochiImage(String imageName){
        ImageView japochiDisplay = (ImageView) findViewById(R.id.japochiDisplay);
        int imageId = getResources().getIdentifier(imageName , "drawable", getPackageName());
        japochiDisplay.setBackgroundResource(imageId);
    }

    public void gotToLost(View view){
        Intent intent = new Intent(this, LostScreen.class);
        startActivity(intent);
        myLogger.log(Level.INFO, "Go to Lost view from "+ view.getClass().toString());
    }

    public void tryAgain() {
        scoreTextVew.setText(0);
        this.session = new GameSession();
    }

}
