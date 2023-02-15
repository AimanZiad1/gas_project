package com.example.pc.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class show_take_data_to_tasjeel extends AppCompatActivity {
    RecyclerView rv;ArrayList<info_accont> info; myadapter dp;databasehelper db;String n;
    Button btsearsh_j;EditText EDsearche_j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_take_data_to_tasjeel);
        btsearsh_j=(Button)findViewById(R.id.bt_search11);
        EDsearche_j=(EditText)findViewById(R.id.edsearsh11);

        info =new ArrayList<>();
        db =new databasehelper(show_take_data_to_tasjeel.this);

        try {
            n= EDsearche_j.getText().toString();
            Toast.makeText(show_take_data_to_tasjeel.this,""+n,Toast.LENGTH_LONG).show();
            info=db.Readdata1(n);
        }

        catch (Exception e){
            Toast.makeText(show_take_data_to_tasjeel.this,"ex"+e,Toast.LENGTH_LONG).show();}
        dp =new myadapter(info,show_take_data_to_tasjeel.this);

        rv=(RecyclerView) findViewById(R.id.rv22);

        RecyclerView.LayoutManager lm= new LinearLayoutManager(show_take_data_to_tasjeel.this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(dp);



        btsearsh_j.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        info =new ArrayList<>();
        db =new databasehelper(show_take_data_to_tasjeel.this);


            n= EDsearche_j.getText().toString();

     info=db.Readdata1(n);



        dp =new myadapter(info,show_take_data_to_tasjeel.this);

        rv=(RecyclerView) findViewById(R.id.rv22);

        RecyclerView.LayoutManager lm= new LinearLayoutManager(show_take_data_to_tasjeel.this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(dp);





    }
});




    }



}
