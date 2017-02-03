package perso.shit.bull.julien.japotruc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.dynamo.CredentialsManager;
import perso.shit.bull.julien.japotruc.dynamo.DynamoDBManager;
import perso.shit.bull.julien.japotruc.sqlite.ScoreBean;
import perso.shit.bull.julien.japotruc.sqlite.ScoreDBHelper;
import perso.shit.bull.julien.japotruc.sqlite.ScoreDBReader;
import perso.shit.bull.julien.japotruc.sqlite.ScoreDBWriter;

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

        /**
         * Tests for the DB  START
         */
        System.out.println("Starting DB tests");
        ScoreDBHelper dbHelper = new ScoreDBHelper(this.getApplicationContext());
        System.out.println("------------------------");
        System.out.println(dbHelper.getDatabaseName());
        System.out.println("------------------------");
        System.out.println("writing entries in the database");
        System.out.println("------------------------");
        ScoreDBWriter writer = new ScoreDBWriter(dbHelper);
        writer.writeScore("Julio", 20);
        writer.writeScore("Eliot", 2);
        writer.writeScore("renaud", 32);
        writer.writeScore("Stephanie", 39);
        writer.writeScore("Lisa", 120);
        writer.writeScore("Lea", 3);
        System.out.println("------------------------");
        System.out.println("values writed, time to read");
        System.out.println("------------------------");
        ScoreDBReader reader = new ScoreDBReader(dbHelper);
        for(ScoreBean bean : reader.getTableContent()) {
            System.out.println("Id : "+ bean.getId() +" Username : " + bean.getUserName() + " score : " + bean.getScore());
        }

        System.out.println("------------------------");
        System.out.println("Reading and printing the values");
        System.out.println("------------------------");


        /**
         * Tests for the DB  END
         */
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

    public void goToHighScore(View view) {
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
        logger.log(Level.INFO, "### Going to HighScores from Welcome ###");
    }
}
