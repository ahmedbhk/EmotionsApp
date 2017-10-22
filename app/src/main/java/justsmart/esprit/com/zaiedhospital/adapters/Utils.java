package justsmart.esprit.com.zaiedhospital.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import justsmart.esprit.com.zaiedhospital.Fragments.PatientHistoryFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.PatientMoodFragment;
import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.entities.Mood;
import justsmart.esprit.com.zaiedhospital.entities.Patient;

/**
 * Created by BHK on 09/10/2017.
 */

public class Utils {
    public static Patient patientOn;
    public static boolean adminOn;
    public static String pass="0000";
    public static void saveMoods(Context mContext, List<Mood> moods){

        for (Mood m :
                moods) {
            m.setDate(new Date());
            SQLiteDatabase.loadLibs(mContext);
            SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
            ContentValues contentValues = new ContentValues();
            contentValues.put(FeedReaderContract.MoodsTable.COLUMN_NAME_NAME,m.getName());
            contentValues.put(FeedReaderContract.MoodsTable.COLUMN_NAME_LEVEL,m.getLevel());
            contentValues.put(FeedReaderContract.MoodsTable.COLUMN_NAME_EXPLAINATION,m.getExplaination());
            contentValues.put(FeedReaderContract.MoodsTable.COLUMN_NAME_DATE,m.getDate().toString());
            contentValues.put(FeedReaderContract.MoodsTable.COLUMN_NAME_PATIEN_ID,m.getPatientId());
            db.insert(FeedReaderContract.MoodsTable.TABLE_NAME,null,contentValues);
            db.close();
            LinearLayout l = (LinearLayout) PatientHistoryFragment.itemview.findViewById(R.id.moodItem);

            PatientHistoryFragment.dataModels.add(new MoodsListDataModel(m.getName(),m.getLevel(),m.getDate(),m.getName(),m.getExplaination(),l));
        }
        PatientHistoryFragment.adapter.notifyDataSetChanged();


    }
    public static void addPatient(Context mContext, Patient p){
            SQLiteDatabase.loadLibs(mContext);
            SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
            ContentValues contentValues = new ContentValues();
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_NAME,p.getName());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_AGE,p.getAge());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_GENDER,p.getGender());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_LOGIN,p.getLogin());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_PASSWORD,p.getPassword());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_BEDNUM,p.getBedNum());
            contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_NURSE,p.getNurse());
            db.insert(FeedReaderContract.PatientTable.TABLE_NAME,null,contentValues);
            db.close();

    }

    public static ArrayList<Mood> getMoods(Context mContext){
        ArrayList<Mood> moods = new ArrayList<>();
        SQLiteDatabase.loadLibs(mContext);
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.MoodsTable.TABLE_NAME +
                "' WHERE "+FeedReaderContract.MoodsTable.COLUMN_NAME_PATIEN_ID + " = "+Utils.patientOn.getPatientId()+" ;", null);
        while (cursor.moveToNext()){
            Mood mood = new Mood();
            mood.setName(cursor.getString(1));
            mood.setLevel(cursor.getString(2));
            mood.setExplaination(cursor.getString(3));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
            Date d=new Date();
            try {
                d= sdf.parse((cursor.getString(4)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mood.setDate(d);
            moods.add(mood);
//            Log.e("Cursor ID",cursor.getString(0));
        }
        cursor.close();
        return moods;
    }
    public static ArrayList<Patient> getPatients(Context mContext){
        ArrayList<Patient> patients = new ArrayList<>();
        SQLiteDatabase.loadLibs(mContext);
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.PatientTable.TABLE_NAME + "';", null);
        while (cursor.moveToNext()){
            Patient patient = new Patient();
            patient.setPatientId(cursor.getInt(0));
            patient.setName(cursor.getString(1));
            patient.setGender(cursor.getString(2));
            patient.setAge(cursor.getInt(3));
            patient.setLogin(cursor.getString(4));
            patient.setPassword(cursor.getString(5));
            patient.setBedNum(cursor.getInt(6));
            patient.setNurse(cursor.getString(7));
            patients.add(patient);
            Log.e("Mridh meskin",patient.toString());
        }
        cursor.close();
        return patients;
    }
    public static Patient getPatient(Context mContext,String login, String password){
        SQLiteDatabase.loadLibs(mContext);
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.PatientTable.TABLE_NAME + "' WHERE (("
                +FeedReaderContract.PatientTable.COLUMN_NAME_LOGIN+" like '"+login+"') AND ("+
                FeedReaderContract.PatientTable.COLUMN_NAME_PASSWORD+" like '"+password+"') );", null);
        Patient patient=new Patient();
        while (cursor.moveToNext()){
             patient = new Patient();
            patient.setPatientId(cursor.getInt(0));
            patient.setName(cursor.getString(1));
            patient.setGender(cursor.getString(2));
            patient.setAge(cursor.getInt(3));
            patient.setLogin(cursor.getString(4));
            patient.setPassword(cursor.getString(5));
            patient.setBedNum(cursor.getInt(6));
            patient.setNurse(cursor.getString(7));
//            Log.e("Mridha meskina",patient.toString());
        }
        cursor.close();
        return patient;
    }
    public static void registerPatient(Context c,String login, String password, String name, String gender){
        Patient p = new Patient();
        p.setName(name);
        p.setNurse("nurse");
        p.setBedNum(3);
        p.setPassword(password);
        p.setLogin(login);
        p.setAge(152);
        p.setGender(gender);
        Utils.addPatient(c,p);

    }
    public static void editPatient(Context mContext ,Patient p ){
        SQLiteDatabase.loadLibs(mContext);
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_NAME,p.getName());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_AGE,p.getAge());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_GENDER,p.getGender());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_LOGIN,p.getLogin());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_PASSWORD,p.getPassword());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_BEDNUM,p.getBedNum());
        contentValues.put(FeedReaderContract.PatientTable.COLUMN_NAME_NURSE,p.getNurse());
        db.update(FeedReaderContract.PatientTable.TABLE_NAME,contentValues,"_id="+p.getPatientId(),null);
        db.close();
    }
    public static void resetGenders(Context mContext){
        SQLiteDatabase.loadLibs(mContext);
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(mContext).getWritableDatabase(pass);
        db.execSQL("UPDATE "+FeedReaderContract.PatientTable.TABLE_NAME+" SET "+
        FeedReaderContract.PatientTable.COLUMN_NAME_GENDER+" = 'Female' where _id=5 ");
    }
}
