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

    private Map<String, String> mapNameScore;

    private FileReader reader;

    private File memFile;

    private final static String FILE_PATH = "";

    public HighScores(){

    }

    /**
     * This method will setUp the file and read it in order to recover the list
     * of data to be displayed
     */
    private void retrieveScoreList() {

    }
}
