package perso.shit.bull.julien.japotruc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.logging.Level;

import perso.shit.bull.julien.japotruc.logic.GameSession;

public class GameScreen extends BackToWelcome {

    private GameSession session;

    private TextView scoreTextView;

    private MediaPlayer mediaPlayerWin, mediaPlayerLose;

    private ImageView japochiDisplay;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayerWin = MediaPlayer.create(getApplicationContext(), R.raw.japosiffle1);
        mediaPlayerLose = MediaPlayer.create(getApplicationContext(), R.raw.japosiffle2);
        japochiDisplay = (ImageView) findViewById(R.id.japochiDisplay);

        setContentView(R.layout.activity_game_screen);
        scoreTextView = (TextView) findViewById(R.id.scoreText);
        scoreTextView.setText(String.valueOf(0));

        session = new GameSession();
        setJapochiImage(session.getCurrentImage());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * Called each time the user provides a good answer
     */
    private void switchImage() {

    }

    /**
     * Check if if the picture is Chinese
     * If yes then launch display of new picture
     * If not then launch looser activity
     */
    public void checkChinese(View view) {
        if (session.isCurrentJapanese()) {
            //go to looser
            mediaPlayerLose.start();
            gotToLost(view);
        } else {
            // carry ON
            mediaPlayerWin.start();
            session.nextImage();
            scoreTextView.setText(String.valueOf(session.getScore()));
            setJapochiImage(session.getCurrentImage());
        }
    }

    /**
     * Check if the picture is Japanese
     * If yes then launch display of new pic
     * If not then lauch looser activity
     *
     * @param view
     */
    public void checkJapanese(View view) {
        if (session.isCurrentJapanese()) {
            //continue
            mediaPlayerWin.start();
            session.nextImage();
            scoreTextView.setText(String.valueOf(session.getScore()));
            setJapochiImage(session.getCurrentImage());
        } else {
            //go to looser
            mediaPlayerLose.start();
            gotToLost(view);
        }
    }

    /**
     * Set the background image of the imageView to imageName
     *
     * @param imageName
     */
    private void setJapochiImage(String imageName) {
        int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        japochiDisplay.setBackgroundResource(imageId);
    }

    public void gotToLost(View view) {
        Intent intent = new Intent(this, LostScreen.class);
        startActivity(intent);
        myLogger.log(Level.INFO, "Go to Lost view from " + view.getClass().toString());
    }

    public void tryAgain() {
        scoreTextView.setText(String.valueOf(0));
        this.session = new GameSession();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("GameScreen Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
