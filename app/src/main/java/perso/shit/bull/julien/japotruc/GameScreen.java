package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import perso.shit.bull.julien.japotruc.logic.GameSession;

public class GameScreen extends BackToWelcome {

    private GameSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        session = new GameSession();
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
        }
        else{

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
            //go to looser
        }
        else{

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


}
