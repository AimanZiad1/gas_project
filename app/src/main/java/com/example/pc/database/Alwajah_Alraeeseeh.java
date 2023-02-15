package com.example.pc.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Alwajah_Alraeeseeh extends AppCompatActivity {
     Button add,tasjeelgas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alwajah__alraeeseeh);
        this.setTitle("الرئسية                                                                     ");

        add=(Button)findViewById(R.id.btadd);
        tasjeelgas=(Button)findViewById(R.id.bt_tasjeel);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplication(),tasjeel_accont.class);
                startActivity(i);
            }
        });
        tasjeelgas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplication(), show_take_data_to_tasjeel.class);
                startActivity(i);
            }});
    }

    public void opentagreer(View view) {
        Intent i=new Intent( Alwajah_Alraeeseeh.this,show_last_data.class);
        startActivity(i);
    }
}
