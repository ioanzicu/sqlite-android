package android.example.com.sqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.com.sqlite.data.PetContract.PetEntry;
import androidx.annotation.Nullable;

public class PetDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDBHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "shelter.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link PetDBHelper}.
     *
     * @param context of the app
     */
    public PetDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     *  Called when the database is created first time
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_BREED + " TEXT, "
                + PetEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 0, "
                + PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     * For example, when the database schema changed
     * - added or removed new column
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
