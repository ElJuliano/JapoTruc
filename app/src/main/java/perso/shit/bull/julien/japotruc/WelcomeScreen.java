package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.dynamo.CredentialsManager;
import perso.shit.bull.julien.japotruc.dynamo.DynamoDBManager;

public class WelcomeScreen extends SwitchActivity {

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
        /**
        System.out.println("Starting DB tests");
        System.out.println("------------------------");
        System.out.println(getHelper().getDatabaseName());
        System.out.println("------------------------");
        System.out.println("writing entries in the database");
        System.out.println("------------------------");
        getWriter().writeScore("Julio", 21);
        getWriter().writeScore("Eliot", 12);
        getWriter().writeScore("renaud", 32);
        getWriter().writeScore("Stephanie", 19);
        getWriter().writeScore("Lisa", 120);
        getWriter().writeScore("Lea", 3);
        System.out.println("------------------------");
        System.out.println("values writed, time to read");
        System.out.println("------------------------");
        System.out.println(getReader().getTableContent().size());
        for(ScoreBean bean : ScoreListHelper.sortDescending(getReader().getTableContent())) {
            System.out.println("Id : "+ bean.getId() +" Username : " + bean.getUserName() + " score : " + bean.getScore());
        }

        System.out.println("------------------------");
        System.out.println("Reading and printing the values");
        System.out.println("------------------------");
        System.out.println(getReader().getTableContent().size());

         **/

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
