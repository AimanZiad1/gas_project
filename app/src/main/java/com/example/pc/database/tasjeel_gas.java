package com.example.pc.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tasjeel_gas extends AppCompatActivity {
    /////////////////////////////////////////////////////////
     private   EditText Ed_name_j,Ed_card_j,Ed_phone,Ed_gas_j,Ed_tot_j,Ed_madfo_j,Ed_bagee_j;
    private String mm, n,g,m,p,gas_,total_,mdfoa_,bagee_ ;int for_update_and_delete;
    Button add1,updat1,delet1;

    String all;
databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasjeel_gas);


        this.setTitle("بيانات تسجيل الغاز                                                     ");
/////////////////////////////////////////////////////////////
        db = new databasehelper(tasjeel_gas.this);
        ///////////////////////////////////////
delet1=(Button)findViewById(R.id.btdelet_tasgeel);
        updat1=(Button)findViewById(R.id.btupdae_tasgeel);
        add1=(Button)findViewById(R.id.btadd1);
        Ed_name_j = (EditText) findViewById(R.id.ed_Name);
        Ed_card_j = (EditText) findViewById(R.id.ed_card);
        Ed_phone = (EditText) findViewById(R.id.edphone);
        //
        Ed_gas_j = (EditText) findViewById(R.id.edgas);
        Ed_tot_j = (EditText) findViewById(R.id.edtotal);
        Ed_madfo_j = (EditText) findViewById(R.id.edalmdfoa);
        Ed_bagee_j = (EditText) findViewById(R.id.edalmtbgee);
/////////////////////////////////////////////////////////////////
        Ed_madfo_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        g = getIntent().getStringExtra("name");
        m = getIntent().getStringExtra("card");
        p = getIntent().getStringExtra("phon");
        gas_ = getIntent().getStringExtra("gas");
        total_ = getIntent().getStringExtra("total");
        mdfoa_ = getIntent().getStringExtra("mdfoa");
        bagee_ = getIntent().getStringExtra("bagee");
        for_update_and_delete=getIntent().getIntExtra("for_update_and_delete",2);
       int s=1;
        if(for_update_and_delete==s) {
            this.setTitle("تعديل بيانات تسجيل الغاز                                                     ");

            add1.setVisibility(add1.GONE);
            updat1.setVisibility(updat1.VISIBLE);
            delet1.setVisibility(delet1.VISIBLE);
        }



        Ed_name_j.setText(g);
        Ed_card_j.setText(m);
        Ed_phone.setText(p);
//////////////
        Ed_gas_j.setText(gas_);
        Ed_tot_j.setText(total_);
        Ed_madfo_j.setText(mdfoa_);
        Ed_bagee_j.setText(bagee_);

////////////////////////////////////////////

          mm=db.Readdata_alldu(g,m,p,gas_,bagee_);
    }

//////////////////////////////////

    public void add1(View view) {


        if ((Ed_gas_j.getText().length() != 0) && (Ed_madfo_j.getText().length() != 0)) {


            ////////حساب الاجمالي والمتبقي

            {
                String gas = Ed_gas_j.getText().toString();
                int s = new Integer(gas);
                int tot = 6000;
                all = String.valueOf(s * tot);
                Ed_tot_j.setText(all);
            }

            {
                String m = Ed_madfo_j.getText().toString();
                String all = Ed_tot_j.getText().toString();
                int hh = new Integer(all);

                int nn = new Integer(m);
                int f = hh - nn;
                Ed_bagee_j.setText(String.valueOf(f));
            }
            //////////////////
            /////////////////


            db.insd22(Ed_name_j.getText().toString(), Ed_card_j.getText().toString(), Ed_phone.getText().toString()
                    , Ed_gas_j.getText().toString(), Ed_tot_j.getText().toString(), Ed_madfo_j.getText().toString(), Ed_bagee_j.getText().toString());
            Toast.makeText(getBaseContext(), " تمت عملية الاضافة بنجاح ", Toast.LENGTH_LONG).show();
            finish();

        } else {
            Toast.makeText(getBaseContext(), "تاكد من كتابه البيانات", Toast.LENGTH_SHORT).show();
        }
        /////////////////


    }



    public void update_tasgeel(View view) {
        ////////////////////////////////////////////////////////////////////
        if( (Ed_gas_j.getText().length()!=0)&&(Ed_madfo_j.getText().length()!=0)){


            ////////حساب الاجمالي والمتبقي

            {  String gas= Ed_gas_j.getText().toString();
                int s=new Integer(gas);
                int tot=6000;
                all=String.valueOf(s*tot);
                Ed_tot_j.setText(all);}

            {  String m=Ed_madfo_j.getText().toString();
                String all=Ed_tot_j.getText().toString();
                int hh=new Integer(all);

                int nn=new Integer(m);
                int f=hh-nn;
                Ed_bagee_j.setText(String.valueOf(f));
            }
              //////////////////



            db.update_tasgeel(mm, Ed_name_j.getText().toString(), Ed_card_j.getText().toString(), Ed_phone.getText().toString(), Ed_gas_j.getText().toString(), Ed_tot_j.getText().toString(), Ed_madfo_j.getText().toString(), Ed_bagee_j.getText().toString());
            Toast.makeText(tasjeel_gas.this, "  تمت عمليه التعديل بنجاح", Toast.LENGTH_LONG).show();
            finish();
              /////////////////
        }

        else {Toast.makeText(getBaseContext(),"تاكد من كتابه البيانات",Toast.LENGTH_SHORT).show();}
        /////////////////


















    }

    public void delet_tasgeel(View view) {
        try {
            db.delete_tasgeel(mm);


            Toast.makeText(getBaseContext(), "تم الحذف بنجاح", Toast.LENGTH_LONG).show();
            finish();
        }catch (Exception e){            Toast.makeText(getBaseContext(),  ""+e, Toast.LENGTH_LONG).show();
        }

    }
}
