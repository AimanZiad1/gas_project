package com.example.pc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by pc on 12/05/2022.
 */





public class databasehelper extends SQLiteOpenHelper {

    public static final String db_name = "student_db";
    public static final int db_version = 1;
    /////
    public static final String table_name = "stu_info";
    public static final String table_allinfo = "allinfo";
    public static final String stu_id = "id";
    public static final String stu_name = "name";
    public static final String stu_card = "cardn";
    public static final String stu_phone = "phonn";


    public static final String stu_gas = "gas";
    public static final String stu_Albagee = "albagee";
    public static final String stu_almdfoa = "almdfoa";
    public static final String stu_alajmalee = "alajmalee";


    public databasehelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase C) {

        String q = "CREATE TABLE " + table_name + " (" + stu_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + stu_name + " TEXT,"
                + stu_phone + " TEXT,"
                + stu_card + " TEXT)";

        C.execSQL(q);

        {
            String x = "CREATE TABLE " + table_allinfo + " (" + stu_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + stu_name + " TEXT,"
                    + stu_phone + " TEXT,"
                    + stu_card + " TEXT,"
                    + stu_gas + " TEXT,"
                    + stu_Albagee + " TEXT,"
                    + stu_almdfoa + " TEXT,"
                    + stu_alajmalee + " TEXT)";

            C.execSQL(x);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqldb, int i, int i1) {
        sqldb.execSQL("DROP TABLE IF EXISTS" + table_name + " ");

        sqldb.execSQL("DROP TABLE IF EXISTS" + table_allinfo + " ");
        onCreate(sqldb);


    }


    public boolean insert_accont(String name, String numbercard, String numberphone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(stu_name, name);
        cv.put(stu_phone, numberphone);
        cv.put(stu_card, numbercard);

        db.insert(table_name, null, cv);


        return true;
    }

    //////////////////insaert into allinfo
    public boolean insd22(String name, String numbercard, String numberphone, String numbergas, String Albagee, String almdfoa, String alajmalee) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(stu_name, name);
        cv.put(stu_phone, numberphone);
        cv.put(stu_card, numbercard);
        cv.put(stu_gas, numbergas);
        cv.put(stu_Albagee, Albagee);
        cv.put(stu_almdfoa, almdfoa);
        cv.put(stu_alajmalee, alajmalee);


        db.insert(table_allinfo, null, cv);


        return true;
    }

    ///////////end allinfo
///////////////select
    public ArrayList<info_accont> Readdata() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_name, null);
        ArrayList<info_accont> info = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                info.add(new info_accont(cursor.getString(1), cursor.getString(2), cursor.getString(3)));


            } while (cursor.moveToNext());


        }
        cursor.close();
        return info;


    }
    //////////select from table   allinfo for _get -id
//////////////select
   /* public int Readdata_allinfo_d(String name0, String numbercard0, String numberphone0, String numbergas0, String Albagee0, String almdfoa0, String alajmalee0){


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + stu_id + " FROM " + table_allinfo+" where " + stu_name + " like '" + name0 + "' ", null);
        int s=-1;
        if (cursor.moveToFirst()) {

                 s= (cursor.getInt(1));



        }
        cursor.close();


        return s;


    }
*/
    ////////    //////////select from table   allinfo
//////////////select


    ////////
    //////////select from table   allinfo
//////////////select
    public ArrayList<info_tasjeel> Readdata_allinfo() {


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_allinfo, null);
        ArrayList<info_tasjeel> info1 = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                info1.add(new info_tasjeel(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7)));


            } while (cursor.moveToNext());


        }
        cursor.close();


        return info1;


    }
/////////////////////////////////////////////////////////////////////////////////




    String mm;
    public String Readdata_al(String name12,String card12) {



        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id FROM " + table_name +" where name =='"+ name12 +"' or cardn == '" +card12 +"'", null);
         if (cursor.moveToFirst()) {
            do {
                 mm=cursor.getString(0);

            } while (cursor.moveToNext());


        }
        cursor.close();


        return mm;


    }
///////

    String dd;
    public String Readdata_alldu( String name, String numbercard, String numberphone, String numbergas, String Albagee ) {



        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id FROM " + table_allinfo +" where name =='" + name +"' or cardn == '" + numbercard +"' or phonn == '" +numberphone + "' and "+stu_Albagee+" == ' " +Albagee + "'  and "+stu_gas+" == ' " +numbergas + "'", null);
        if (cursor.moveToFirst()) {
            do {
               dd=cursor.getString(0);

            } while (cursor.moveToNext());


        }
        cursor.close();


        return dd;


    }
    /////////















    ////////////////////////////////////////////////////////////////////////////
    ////////
    ///////////////select

    public ArrayList<info_accont> Readdata1(String nameform_tasjeel) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_name + " where name like '%" + nameform_tasjeel + "%'", null);
        ArrayList<info_accont> info = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                info.add(new info_accont(cursor.getString(1), cursor.getString(2), cursor.getString(3)));


            } while (cursor.moveToNext());


        }
        cursor.close();
        return info;


    }
    //////


    //////////////update_accont
    public void update(String p_id, String name, String card, String Phon) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(stu_name, name);
        cv.put(stu_card, card);
        cv.put(stu_phone, Phon);
        db.update(table_name, cv, "id=?", new String[]{p_id});
        db.close();


    }

    //////////////
    //////////////update_accont
    public void update_tasgeel(String p_id, String name, String numbercard, String numberphone, String numbergas, String Albagee, String almdfoa, String alajmalee) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(stu_name, name);
        cv.put(stu_phone, numberphone);
        cv.put(stu_card, numbercard);
        cv.put(stu_gas, numbergas);
        cv.put(stu_Albagee, Albagee);
        cv.put(stu_almdfoa, almdfoa);
        cv.put(stu_alajmalee, alajmalee);
        db.update(table_allinfo, cv, "id=?", new String[]{p_id});
        db.close();


    }

    public void delete(String p_id) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(table_name, "id=?", new String[]{p_id});
        db.close();


    }

    ///////////////

    public void delete_tasgeel(String p_id) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(table_allinfo, "id=?", new String[]{p_id});
        db.close();


    }



}

    ////////




