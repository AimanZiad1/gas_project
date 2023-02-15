package com.example.pc.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class show_last_data extends AppCompatActivity {
    RecyclerView rv;ArrayList<info_tasjeel> info1; myadapter2 dp; databasehelper db;
    Button btadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_last_data);







    }

    public void finsh_this(View view) {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        info1 =new ArrayList<>();

        db =new databasehelper(show_last_data.this);

                info1 = db.Readdata_allinfo();


        rv=(RecyclerView) findViewById(R.id.rv1);

        dp =new myadapter2(info1,show_last_data.this);

        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(dp);
    }
}
