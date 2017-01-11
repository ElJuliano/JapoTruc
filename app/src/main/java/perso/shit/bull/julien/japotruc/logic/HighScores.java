package perso.shit.bull.julien.japotruc.logic;

/**
 * Created by Julien on 27/12/2016.
 */

import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * This class should handle the high score array that will be displayed at the end of a game.
 */
public class HighScores {

    private Map<String, String> mapScore;

    public HighScores(){

    }

    public void setMapScore(Map<String,String> scoreMap){
        this.mapScore = scoreMap;
    }

    public Map<String,String> getMapScore() {
        return this.mapScore;
    }

}
