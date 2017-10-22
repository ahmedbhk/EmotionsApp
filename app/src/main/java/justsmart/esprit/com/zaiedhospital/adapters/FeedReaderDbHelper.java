package justsmart.esprit.com.zaiedhospital.adapters;

/**
 * Created by BHK on 18/05/2017.
 */
import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static FeedReaderDbHelper instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ZayedDB2.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String DATE_TYPE = " DATETIME";
    private static final String NUMBER_TYPE = " INTEGER";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.MoodsTable.TABLE_NAME + " (" +
                    FeedReaderContract.MoodsTable._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.MoodsTable.COLUMN_NAME_NAME + TEXT_TYPE + "," +
                    FeedReaderContract.MoodsTable.COLUMN_NAME_LEVEL + TEXT_TYPE + "," +
                    FeedReaderContract.MoodsTable.COLUMN_NAME_EXPLAINATION + TEXT_TYPE + "," +
                    FeedReaderContract.MoodsTable.COLUMN_NAME_DATE + DATE_TYPE +" DEFAULT CURRENT_TIMESTAMP "+","+
                    FeedReaderContract.MoodsTable.COLUMN_NAME_PATIEN_ID + NUMBER_TYPE +
                    " )";
    public static final String SQL_CREATE_PATIENT_TABLE =
            "CREATE TABLE " + FeedReaderContract.PatientTable.TABLE_NAME + " (" +
                    FeedReaderContract.PatientTable._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_NAME + TEXT_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_GENDER + TEXT_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_AGE + NUMBER_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_LOGIN + TEXT_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_PASSWORD + TEXT_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_BEDNUM + NUMBER_TYPE + "," +
                    FeedReaderContract.PatientTable.COLUMN_NAME_NURSE + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.MoodsTable.TABLE_NAME;
    public static final String SQL_DELETE_PATIENTS =
            "DROP TABLE IF EXISTS " + FeedReaderContract.PatientTable.TABLE_NAME;

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static public synchronized FeedReaderDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new FeedReaderDbHelper(context);
        }
        return instance;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_PATIENT_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_PATIENTS);
        onCreate(db);
    }
    public static void reset(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PATIENTS);
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
