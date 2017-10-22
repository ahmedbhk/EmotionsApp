package justsmart.esprit.com.zaiedhospital.adapters;

/**
 * Created by BHK on 19/05/2017.
 */

import android.provider.BaseColumns;

public final class FeedReaderContract {
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class MoodsTable implements BaseColumns {
        public static final String TABLE_NAME = "Mood";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LEVEL = "level";
        public static final String COLUMN_NAME_EXPLAINATION = "explaination";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_PATIEN_ID = "patientId";
    }

    public static abstract class PatientTable implements BaseColumns {
        public static final String TABLE_NAME = "Patient";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_LOGIN = "login";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_BEDNUM = "bedNum";
        public static final String COLUMN_NAME_NURSE = "nurse";
    }

    public static abstract class AdminTable implements BaseColumns {
        public static final String TABLE_NAME = "Admin";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LOGIN = "login";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }

}