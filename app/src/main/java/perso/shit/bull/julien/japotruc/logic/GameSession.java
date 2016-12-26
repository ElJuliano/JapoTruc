package perso.shit.bull.julien.japotruc.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julien on 26/12/2016.
 */

public class GameSession {

    private static final int MAX = 31;

    private static final int MIN = 1;

    private final String JAP_PREFIX = "jap";

    private final String CHI_PREFIX = "chi";

    private String currentImage;

    private List<String> previousImages;

    private int id;

    private int score;

    public GameSession(){
        this.previousImages = new ArrayList<String>();
        this.score = 0;
    }

    public GameSession(String imageName){
        this.previousImages = new ArrayList<String>();
        this.currentImage = imageName;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int value){
        this.score = value;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int currentId){
        this.id = currentId;
    }

    public String getCurrentImage() {
        return this.currentImage;
    }


    /**
     * Determine the next image to be displayed by generating an int between MIN and MAX
     * and verifying that the images created aint in the previous image list.
     */
    private String determineNextImage() {
        String result = null;
        int randomNumber = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
        if(randomNumber % 2 == 0){
            result = CHI_PREFIX;
        }
        else{
            result = JAP_PREFIX;
        }
        result += String.valueOf(randomNumber);
        // generate the name of the next image
        if(result == null || previousImages.contains(result)) {
            return determineNextImage();
        }
        previousImages.add(result);
        currentImage = result;
        return result;
    }

    /**
     * Check whether an image is japanese
     * @return
     */
    public boolean isCurrentJapanese(){
        return this.currentImage.contains(JAP_PREFIX);
    }

    public void nextImage(){
        determineNextImage();
        this.score ++;
    }


}
