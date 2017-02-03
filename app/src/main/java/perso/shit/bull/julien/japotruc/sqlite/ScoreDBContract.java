package perso.shit.bull.julien.japotruc.sqlite;

import android.provider.BaseColumns;

/**
 * Created by Julien on 01/02/2017.
 */

public final class ScoreDBContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + scoreTableContent.TABLE_NAME + " (" +
                    scoreTableContent._ID + " INTEGER PRIMARY KEY," +
                    scoreTableContent.COLUMN_NAME_TITLE + " TEXT," +
                    scoreTableContent.COLUMN_NAME_SUBTITLE + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + scoreTableContent.TABLE_NAME;

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ScoreDBContract() {}

    /* Inner class that defines the table contents */
    public static class scoreTableContent implements BaseColumns {
        public static final String TABLE_NAME = "scores";
        public static final String COLUMN_NAME_TITLE = "username";
        public static final String COLUMN_NAME_SUBTITLE = "score";
    }
}
