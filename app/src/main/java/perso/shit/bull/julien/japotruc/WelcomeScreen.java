package perso.shit.bull.julien.japotruc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.dbbeans.Scores;
import perso.shit.bull.julien.japotruc.dynamo.CredentialsManager;
import perso.shit.bull.julien.japotruc.dynamo.DynamoDBManager;

public class WelcomeScreen extends Activity {

    private Logger logger = Logger.getLogger("WelcomeLogger");

    private CredentialsManager credentialsManager;

    private DynamoDBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        System.out.println("launching credential manager");
        credentialsManager = new CredentialsManager(getApplicationContext());
        System.out.println("launching db manager");
        dbManager = new DynamoDBManager(credentialsManager.getCredentialProvider());

        Runnable runnable = new Runnable() {
            public void run() {
                Scores score = new Scores();
                score.setUser_id("ElJuliano");
                score.setScore(1000);
                System.out.println("User created");
                dbManager.save(score);
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();

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
