package com.example.pc.timetab;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class TueActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabase myDatabase;
    String day;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<ListItem> listItems;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tue);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        day=this.getIntent().getExtras().getString("day");
        myDatabase=new MyDatabase(this,"Time_Table_DB",null,1);
        fab=(FloatingActionButton)this.findViewById(R.id.floatingActionButton4);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,FormActivity.class);
        intent.putExtra("day",day);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    private void createCards(){
        cursor=myDatabase.getCursor(day);
        listItems=new ArrayList<>();
        recyclerView=(RecyclerView)this.findViewById(R.id.recyclerViewTue);
        while (cursor.moveToNext()){
            String subject=cursor.getString(cursor.getColumnIndex("subject"));
            String teacher=cursor.getString(cursor.getColumnIndex("teacher"));
            int room=cursor.getInt(cursor.getColumnIndex("room"));
            int color=cursor.getInt(cursor.getColumnIndex("color"));
            String from=cursor.getString(cursor.getColumnIndex("time_from"));
            ListItem listItem=new ListItem(subject,teacher,room,from);
            listItem.setDay(day);
            listItem.setColor(color);
            listItems.add(listItem);
        }
        adapter=new MyAdapter(this,listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createCards();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDatabase.close();
    }
}
