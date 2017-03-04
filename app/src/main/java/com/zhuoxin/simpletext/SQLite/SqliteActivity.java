package com.zhuoxin.simpletext.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhuoxin.simpletext.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SqliteActivity";
    MyHelp myHelp;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_score)
    EditText etScore;
    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.btn_select)
    Button btnSelect;
    @BindView(R.id.btn_delete)
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_insert, R.id.btn_select, R.id.btn_delete})
    public void onClick(View view) {
        myHelp = new MyHelp(this, "student.db", null, 1);
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String score = etScore.getText().toString();
        SQLiteDatabase database = myHelp.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        int id = view.getId();
        switch (id) {
            case R.id.btn_insert:
                contentValues.put("name", name);
                contentValues.put("age", age);
                contentValues.put("score", score);
                database.insert("student", null, contentValues);
                database.close();
                break;
            case R.id.btn_select:
                SQLiteDatabase database1 = myHelp.getReadableDatabase();
                Cursor cursor = database1.query("student", null, null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    String name1 = cursor.getString(cursor.getColumnIndex("name"));
                    int age1 = cursor.getInt(cursor.getColumnIndex("age"));
                    int score1 = cursor.getInt(cursor.getColumnIndex("score"));
                    Log.i(TAG, "onClick: 名字：" + name1 + "年龄" + age1 + "成绩" + score1);
                    database1.close();
                }

                break;
        }
    }
}
