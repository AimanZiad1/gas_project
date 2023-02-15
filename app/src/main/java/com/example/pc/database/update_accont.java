package com.example.pc.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_accont extends AppCompatActivity {
    Button update_j,delet_j;
    EditText Nameupd,cardupd,phoneupd;
 public     String vm,n,m,p;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_accont);
        this.setTitle("تعديل بيانات الحسابات                                                                      ");

        //////////////take Rec
        update_j=(Button)findViewById(R.id.btupdate);
        delet_j=(Button)findViewById(R.id.btdelet);
        Nameupd=(EditText)findViewById(R.id.edtname_upd);
        cardupd=(EditText)findViewById(R.id.edt_card_upd);
        phoneupd=(EditText)findViewById(R.id.edt_num_phon_upd);
        ////////
        db=new databasehelper(update_accont.this);
        //////////

        n=getIntent().getStringExtra("name");
        m=getIntent().getStringExtra("card");
        p=getIntent().getStringExtra("phon");
        ///////


        Nameupd.setText(n);
        cardupd.setText(m);
        phoneupd.setText(p);
        if (Nameupd.getText().toString() == "الاسم")
        {
            Nameupd.setText("");
            if (cardupd.getText().toString() == "رقم البطاقه الشخصيه")
                cardupd.setText("");
            if (phoneupd.getText().toString() == "رقم التلفون")
               phoneupd.setText("");
        }



        update_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                vm=db.Readdata_al(n,m);

                if( phoneupd.length()!=0&&Nameupd.length()!=0){
                    db.update(vm, Nameupd.getText().toString(), cardupd.getText().toString(), phoneupd.getText().toString());
                    Toast.makeText(getBaseContext(), "تم التعديل بنجاح", Toast.LENGTH_LONG).show();
                    finish();
                }
                else{

                    Toast.makeText(update_accont.this, "  تاكد من كتابه الاسم ورقم البطاقه و رقم الهاتف حيث يجب ان يحتوي على 9 ارقام", Toast.LENGTH_LONG).show();

                }









            }





        });

        delet_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm=db.Readdata_al(n,m);
                db.delete(vm);


                Toast.makeText(getBaseContext(),"تم الحذف بنجاح",Toast.LENGTH_LONG).show();


                finish();

            }
        });

    }


}
