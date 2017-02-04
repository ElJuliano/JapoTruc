package perso.shit.bull.julien.japotruc.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julien on 03/02/2017.
 */

public class ScoreDBReader {

    private SQLiteDatabase db;

    private ScoreDBHelper helper;

    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
    private String[] projection = {
            ScoreDBContract.scoreTableContent._ID,
            ScoreDBContract.scoreTableContent.COLUMN_NAME_TITLE,
            ScoreDBContract.scoreTableContent.COLUMN_NAME_SUBTITLE};

    // Filter results WHERE "title" = 'My Title'
    private String selection = ScoreDBContract.scoreTableContent.COLUMN_NAME_TITLE + " = ?";
    // How you want the results sorted in the resulting Cursor
    private String sortOrder = ScoreDBContract.scoreTableContent.COLUMN_NAME_SUBTITLE + " DESC";

    private Cursor cursor;

    public ScoreDBReader(ScoreDBHelper h) {
        this.db = h.getReadableDatabase();
        this.helper = h;
    }

    /**
     * Iterate over the database and populate a map with all scores entries;
     * @return A Map
     */
    public List<ScoreBean> getTableContent() {
        if (!db.isOpen()) {
            db = helper.getWritableDatabase();
        }
        //Getting a cursor over the whole table
        Cursor cursor = db.query(
                ScoreDBContract.scoreTableContent.TABLE_NAME, // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        ArrayList<ScoreBean> scoreList = new ArrayList<ScoreBean>();
        while (cursor.moveToNext()) {
            scoreList.add(new ScoreBean(Integer.valueOf(cursor.getString(0)),
                    cursor.getString(1),
                    Integer.valueOf(cursor.getInt(2))));
        }
        return scoreList;
    }
}