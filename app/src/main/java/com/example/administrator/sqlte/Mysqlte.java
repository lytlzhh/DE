package com.example.administrator.sqlte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/5/005.
 */
/*数据可帮助类*/
public class Mysqlte extends SQLiteOpenHelper {
    private static final String TAG = "Mysqlte";

    public Mysqlte(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERION);
    }

    public Mysqlte(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate--------------------------");

        String sql = "create table " + Constant.TABLE_NAME + "(" + Constant._ID +
                " Integer primary key," + Constant.NAME + " varchar(10)," +
                Constant.AGE + " Integer)";

       /* String sqll = "create table " + Constant.TABLE_NAME + "(" + Constant._ID +
                " Integer primary key," + Constant.NAME + " varchar(10)," +
                Constant.AGE + " Integer)";
*/
        db.execSQL(sql);
        // db.execSQL(sqll);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade########################### ");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i(TAG, "onOpen: &&&&&&&&&&&&&&&&&&&&&");
    }


}
