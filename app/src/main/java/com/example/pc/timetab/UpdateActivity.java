package com.example.pc.timetab;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    String day,prevSubject,fromTime;
    MyDatabase myDatabase;
    EditText editText1,editText2,editText3;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        prevSubject=this.getIntent().getExtras().getString("subject");
        day=this.getIntent().getExtras().getString("day");
        fromTime=this.getIntent().getExtras().getString("from");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myDatabase=new MyDatabase(this,"Time_Table_DB",null,1);
        editText1=(EditText)this.findViewById(R.id.editText4);
        editText2=(EditText)this.findViewById(R.id.editText5);
        editText3=(EditText)this.findViewById(R.id.editText6);
        Cursor cursor=myDatabase.getCursor(day);
        while (cursor.moveToNext()){
            String subCheck=cursor.getString(cursor.getColumnIndex("subject"));
            String dayCheck=cursor.getString(cursor.getColumnIndex("day"));
            if (dayCheck.equals(day)&&subCheck.equals(prevSubject)) {
                editText1.setText(subCheck);
                editText2.setText(cursor.getString(cursor.getColumnIndex("teacher")));
                editText3.setText("" + cursor.getInt(cursor.getColumnIndex("room")));
            }
        }
        fab=(FloatingActionButton)this.findViewById(R.id.updateFab);
        fab.setOnClickListener(this);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        String subject=editText1.getText().toString();
        String teacher=editText2.getText().toString();
        String ed3=editText3.getText().toString();
        int room=0;
        if (!ed3.equals("")) {
            room = Integer.parseInt(ed3);
        }
        if (!subject.equals("")&&!teacher.equals("")&&!ed3.equals("")) {
            boolean check = myDatabase.updateTable(day, subject, teacher, room,fromTime
            );
            if (check) {
                Toast.makeText(this, "Inserted in DB", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(this, "Please Fill All Values", Toast.LENGTH_SHORT).show();
    }
}
