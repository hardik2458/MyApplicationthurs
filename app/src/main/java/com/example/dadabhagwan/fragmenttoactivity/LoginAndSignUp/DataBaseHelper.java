package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadabhagwan on 12/21/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "login";
    private static final String DB_TABLE = "signup";
    private static final String ID = "_id";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private String CREATE_TABLE = "create table signup(_id integer primary key autoincrement, name varchar(255), username varchar(255), email varchar(255), password varchar(255)); ";

    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST" + DB_TABLE);
        onCreate(sqLiteDatabase);
    }

    public String insertData(UserObject userObject) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userObject.getName());
        contentValues.put(PASSWORD, userObject.getPassword());
        contentValues.put(USER_NAME, userObject.getUsername());
        contentValues.put(EMAIL, userObject.getEmail());
        sqLiteDatabase.insert(DB_TABLE, null, contentValues);

        return "Data Saved Successfully";
    }

    public String searchPass(String username) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "select username, password from " + DB_TABLE;
        String a, b;
        b = "No user Found..!!";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(cursor.getColumnIndex(USER_NAME));
                if (a.equals(username))

                {
                    b = cursor.getString(cursor.getColumnIndex(PASSWORD));
                    break;
                }

            } while (cursor.moveToNext());


        }

        return b;


    }

    public List<UserObject> getFullData() {

        List<UserObject> userObjects = new ArrayList<>();
        String query = "select * from "+DB_TABLE;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                UserObject userObject = new UserObject();
                String id = cursor.getString(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String username = cursor.getString(cursor.getColumnIndex(USER_NAME));
                String email = cursor.getString(cursor.getColumnIndex(EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
                userObject.setName(id+"");
                userObject.setName(name);
                userObject.setUsername(username);
                userObject.setEmail(email);
                userObject.setPassword(password);
                userObjects.add(userObject);
                cursor.moveToNext();
            }
        }

        return userObjects;
    }
}
