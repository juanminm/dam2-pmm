package org.institutoserpis.juanminm.listatarea_ver2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juamar on 19/01/18.
 */

public class DataBaseHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "Personas";
    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_TABLE_PERSONA = "persona";
    public static final String SL_ID = "id";
    public static final String SL_NAME = "name";
    public static final String SL_GENDER = "gender";
    public static final String SL_BIRTH_DATE = "birth_date";
    public static final String SL_NATIONALITY = "nationality";
    public static final String SL_CITY = "city";
    private static final String DATABASE_CREATE_PERSONA = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT NOT NULL, %s TEXT NOT NULL, " +
                    "%s DATE NOT NULL, %s TEXT NOT NULL, %s TEXT)",
            DATABASE_TABLE_PERSONA,
            SL_ID,
            SL_NAME,
            SL_GENDER,
            SL_BIRTH_DATE,
            SL_NATIONALITY,
            SL_CITY
    );

    public DataBaseHelper(Context ctx) {
        this.mCtx = ctx;
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }

        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_PERSONA);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_PERSONA);
        }
    }

    public DataBaseHelper open() {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Cursor getItems() {
        return mDb.query(
                DATABASE_TABLE_PERSONA,
                new String[] {SL_ID, SL_NAME, SL_GENDER, SL_BIRTH_DATE, SL_NATIONALITY, SL_CITY},
                null,
                null,
                null,
                null,
                SL_NAME);
    }

    public long insertItem(String name, String gender, String birthDate, String nationality,
                           String city) {
        ContentValues initialValues = new ContentValues();

        initialValues.put(SL_NAME, name);
        initialValues.put(SL_GENDER, gender);
        initialValues.put(SL_BIRTH_DATE, birthDate);
        initialValues.put(SL_NATIONALITY, nationality);
        initialValues.put(SL_CITY, city);
        return mDb.insert(DATABASE_TABLE_PERSONA, null, initialValues);
    }

    public int delete(int mLastRowSelected) {
        return mDb.delete(DATABASE_TABLE_PERSONA, SL_ID + "=?", new String[]{Integer.toString(mLastRowSelected)});
    }

    public Cursor getItem(int itemId) {
        return mDb.rawQuery(
            String.format(
                "SELECT %s, %s, %s, %s, %s, %s FROM %s WHERE %s = ?",
                SL_ID,
                SL_NAME,
                SL_GENDER,
                SL_BIRTH_DATE,
                SL_NATIONALITY,
                SL_CITY,
                DATABASE_TABLE_PERSONA,
                SL_ID
            ),
            new String[]{Integer.toString(itemId)}
        );
    }

    public int updateItem(int ident, String name, String gender, String birthDate,
                          String nationality, String city) {
        ContentValues cv = new ContentValues();
        cv.put(SL_NAME, name);
        cv.put(SL_GENDER, gender);
        cv.put(SL_BIRTH_DATE, birthDate);
        cv.put(SL_NATIONALITY, nationality);
        cv.put(SL_CITY, city);
        return mDb.update(DATABASE_TABLE_PERSONA, cv, SL_ID + "=?",
                new String[]{Integer.toString(ident)});
    }
}
