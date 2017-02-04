package perso.shit.bull.julien.japotruc.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Julien on 03/02/2017.
 */

public class ScoreDBWriter {

    private SQLiteDatabase db;


    public ScoreDBWriter(ScoreDBHelper h) {
        this.db = h.getWritableDatabase();
    }

    public long writeScore(String userName, int score) {

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ScoreDBContract.scoreTableContent.COLUMN_NAME_TITLE, userName);
        values.put(ScoreDBContract.scoreTableContent.COLUMN_NAME_SUBTITLE, score);

        // Insert the new row, returning the primary key value of the new row
        try {
            return db.insert(ScoreDBContract.scoreTableContent.TABLE_NAME, null, values);
        } catch (SQLiteException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "An exception was raised when writting the DB : " + e.getMessage());
        }
        return -1;
    }
}


