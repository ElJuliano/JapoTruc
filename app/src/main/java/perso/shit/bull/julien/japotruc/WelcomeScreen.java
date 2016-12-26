package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomeScreen extends AppCompatActivity {

    private Logger logger = Logger.getLogger("WelcomeLogger");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * Send the user to settings activity
     */
    public void goToSettings(View view){
        Intent intent = new Intent(this, SettingsScreen.class);
        startActivity(intent);
        logger.log(Level.INFO, "### Going to Settings from Welcome ###");
    }

    /**
     * Sends the user to Game activity
     */
    public void goToGame(View view){
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
        logger.log(Level.INFO, "### Going to Game from Welcome ###");
    }
}
