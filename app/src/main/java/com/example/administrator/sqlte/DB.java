package com.example.administrator.sqlte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2017/1/5/005.
 */

public class DB {
    private static Mysqlte mysqlte;

    public static Mysqlte getInstance(Context context) {

        if (mysqlte == null) {
            mysqlte = new Mysqlte(context);
        }
        return mysqlte;
    }


    public static void excemySQL(SQLiteDatabase db, String sql) {
        if (db != null) {
            if (sql != null && !"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }
}
