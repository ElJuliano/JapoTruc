package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Julien on 26/12/2016.
 */

public class BackToWelcome extends AppCompatActivity {

    protected static Logger myLogger = Logger.getLogger("myLogger");
    /**
     * Allow switching back to welcome activity
     */
    public void switchToWelcome(View view){
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        myLogger.log(Level.INFO, "Back to welcome from "+view.getClass().toString());
    }
}
