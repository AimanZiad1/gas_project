package com.example.pc.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tasjeel_accont extends AppCompatActivity {





    private  EditText edtname_j,edtcard_j,edtnumberphon_j ;
    private Button btadd,btshow;
    private databasehelper db;
    private Boolean S=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasjeel_accont);
        this.setTitle("تسجيل حساب جديد                                                        ");


        edtname_j=(EditText)findViewById(R.id.edtname);
        edtcard_j=(EditText)findViewById(R.id.edtemile);
        edtnumberphon_j=(EditText)findViewById(R.id.ednumberphone);
        btadd=(Button)findViewById(R.id.btadd);
        btshow=(Button)findViewById(R.id.btshow);
         db=new databasehelper(tasjeel_accont.this);
    btadd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String name1 =edtname_j.getText().toString();
            String card = edtcard_j.getText().toString();
            String phon = edtnumberphon_j.getText().toString();
           String vn= db.Readdata_al(name1,card );
            Toast.makeText(getBaseContext(),"s  " +vn,Toast.LENGTH_LONG).show();
            if(vn==null) {
                if (name1 == "الاسم") {
                    name1 = "";
                    if (card == "رقم البطاقه الشخصيه")
                        card = "";
                    if (phon == "رقم التلفون")
                        phon = "";
                }


                if (phon.length() == 9 && card.length() != 0 && name1.length() != 0) {
                    try {
                        S = db.insert_accont(name1, card, phon);
                    } catch (Exception e) {
                        Toast.makeText(tasjeel_accont.this, "" + e, Toast.LENGTH_LONG).show();
                    }

                    if (S == true) {
                        Toast.makeText(tasjeel_accont.this, "تمت الاضافه بنجاح", Toast.LENGTH_LONG).show();
                        edtcard_j.setText("");
                        edtname_j.setText("");
                        edtnumberphon_j.setText("");

                    } else {
                        Toast.makeText(tasjeel_accont.this, "No", Toast.LENGTH_LONG).show();
                    }
                } else {
                    {
                        Toast.makeText(tasjeel_accont.this, "  تاكد من كتابه الاسم ورقم البطاقه و رقم الهاتف حيث يجب ان يحتوي على 9 ارقام", Toast.LENGTH_LONG).show();
                    }
                }
            }else {
                Toast.makeText(tasjeel_accont.this, "   لايمكنك الاضافه هذا الحساب موجود مسبقا", Toast.LENGTH_LONG).show();
            }
    }});

btshow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(tasjeel_accont.this,show_accont.class);
        startActivity(intent);
    }
});
    }



}
