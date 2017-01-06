package com.example.administrator.demo_create_sqlte;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.sqlte.Constant;
import com.example.administrator.sqlte.DB;
import com.example.administrator.sqlte.Mysqlte;

public class Main_SQLTE extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Main_SQLTE";
    private Mysqlte helper;
    private Button btn;
    private Button insert_data;
    private Button update_data;
    private Button delet_data;
    private LinearLayout activity_main__sqlte;
    SQLiteDatabase dbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__sqlte);
        helper = DB.getInstance(this);/*获取帮助类的对象*/
        initView();
    }


    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        insert_data = (Button) findViewById(R.id.insert_data);
        update_data = (Button) findViewById(R.id.update_data);
        delet_data = (Button) findViewById(R.id.delete_data);
        activity_main__sqlte = (LinearLayout) findViewById(R.id.activity_main__sqlte);

        btn.setOnClickListener(this);
        insert_data.setOnClickListener(this);
        update_data.setOnClickListener(this);
        delet_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Log.i(TAG, "onClick:****************************** ");
                //helper.getReadableDatabase(); helper.getWritableDatabase()/*打开或者是创建数据库，
                // 没人情况下都是可以读写数据库的，只是在有些特殊的情况下，比如：磁盘已满或者是权限不够才只是读*/

                SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
                break;

            case R.id.insert_data:
                dbs = helper.getWritableDatabase();
                String mysql = "insert into " + Constant.TABLE_NAME + " values(1,'zhansan',20)";
                DB.excemySQL(dbs, mysql);
                String mysql1 = "insert into " + Constant.TABLE_NAME + " values(2,'lisi',25)";
                DB.excemySQL(dbs, mysql1);

                /*所有格式都必须要和以下一致*/
                /* String sql = "create table " + Constant.TABLE_NAME + "(" + Constant._ID +
                " Integer primary key," + Constant.NAME + " varchar(10)," +
                Constant.AGE + " Integer)";*/
                dbs.close();
                break;
            /*修改数据*/
            case R.id.update_data:
                dbs = helper.getWritableDatabase();
                String updata_data = "update " + Constant.TABLE_NAME + " set " + Constant.NAME + "= '五五' where " + Constant._ID + "= 1 ";
                DB.excemySQL(dbs, updata_data);
                dbs.close();
                break;

            case R.id.delete_data:
                dbs = helper.getWritableDatabase();
                String delesql = "delete from " + Constant.TABLE_NAME + " where " + Constant._ID + "=2";
                DB.excemySQL(dbs, delesql);
                dbs.close();
                break;

        }
    }
}
