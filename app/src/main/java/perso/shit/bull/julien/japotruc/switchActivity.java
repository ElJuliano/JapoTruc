package perso.shit.bull.julien.japotruc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.sqlite.ScoreDBHelper;
import perso.shit.bull.julien.japotruc.sqlite.ScoreDBReader;
import perso.shit.bull.julien.japotruc.sqlite.ScoreDBWriter;

/**
 * Created by Julien on 26/12/2016.
 */

public class SwitchActivity extends AppCompatActivity {

    protected static Logger myLogger = Logger.getLogger("myLogger");

    //SQL lite DB management
    private ScoreDBHelper helper;

    private ScoreDBReader reader;

    private ScoreDBWriter writer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = ScoreDBHelper.getInstance(getApplication());
        reader = new ScoreDBReader(helper);
        writer = new ScoreDBWriter(helper);
    }

    /**
     * Allow switching back to welcome activity
     */
    public void switchToWelcome(View view){
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        myLogger.log(Level.INFO, "Back to welcome from "+view.getClass().toString());
    }

    public void switchToGame(View view) {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
        myLogger.log(Level.INFO, "### Going to Game from "+view.getClass().toString()+" ###");
    }

    public ScoreDBReader getReader() {
        return reader;
    }

    public ScoreDBWriter getWriter() {
        return writer;
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }

}
