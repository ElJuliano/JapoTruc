package perso.shit.bull.julien.japotruc;

import android.os.Bundle;
import android.widget.EditText;

public class SettingsScreen extends SwitchActivity {

    private int scoreToWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        EditText textVictoryNumber = (EditText)findViewById(R.id.victoryNumberTextField);
        textVictoryNumber.setText(String.valueOf(scoreToWin));
    }



}
