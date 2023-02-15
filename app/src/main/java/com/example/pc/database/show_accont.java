package com.example.pc.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class show_accont extends AppCompatActivity {
    RecyclerView rv;ArrayList<info_accont>info; myadapterupdat dp;databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_accont);
        this.setTitle("بيانات تسجيل الحسابات                                                 ");



            info = new ArrayList<>();
            db = new databasehelper(show_accont.this);

            info = db.Readdata();
            dp = new myadapterupdat(info, show_accont.this);
            rv = (RecyclerView) findViewById(R.id.rv_show);


        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(dp);












    }

    @Override
    protected void onResume() {
        super.onResume();

        info =new ArrayList<>();
        db =new databasehelper(show_accont.this);

        info=db.Readdata();
        dp =new myadapterupdat(info,show_accont.this);
        rv=(RecyclerView) findViewById(R.id.rv_show);

        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(dp);
    }
}
