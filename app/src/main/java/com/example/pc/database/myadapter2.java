package com.example.pc.database;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 12/05/2022.
 */





public class myadapter2 extends RecyclerView.Adapter<myadapter2.viweholderstd> {

    ArrayList<info_tasjeel> std;
    Context c;

    public myadapter2(ArrayList<info_tasjeel> std, Context cc) {
        this.std = std;
        this.c=cc;
    }

    @Override
    public viweholderstd onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.costom_layout2,null,false);
        viweholderstd vhs=new viweholderstd(v);






        return vhs;
    }

    @Override
    public void onBindViewHolder(viweholderstd holder, int position) {
 final info_tasjeel info=std.get(position);
        holder.name.setText(info.getName());
        holder.card.setText(info.getCard());
        holder.phon.setText(info.getPhon());
         holder.gas.setText(info.getGss());
         holder.total.setText(info.getAlajmalee());
         holder.almdfoa.setText(info.getAlmdfoa());
         holder.almtbgee.setText(info.getAlmtbgee());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(c,tasjeel_gas.class);

                i.putExtra("name",info.getName());
                i.putExtra("phon",info.getPhon());
                i.putExtra("card",info.getCard());
                i.putExtra("gas",info.getGss());
                i.putExtra("total",info.getAlajmalee());
                i.putExtra("mdfoa",info.getAlmdfoa());
                i.putExtra("bagee",info.getAlmtbgee());

int s=1;
                i.putExtra("for_update_and_delete",s);


                c.startActivity(i);










            }
        });



 }
    @Override
    public int getItemCount() {
        return std.size();
    }

    //class for viwe holder
    public class viweholderstd extends RecyclerView.ViewHolder
    {
         TextView name,card,phon,gas,total,almdfoa,almtbgee;


        public viweholderstd(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.edname1);
            card=(TextView) itemView.findViewById(R.id.edcard1);
            phon=(TextView) itemView.findViewById(R.id.edphone1);
             gas=(TextView) itemView.findViewById(R.id.edgas11);
             total=(TextView) itemView.findViewById(R.id.edtotal121);
             almdfoa=(TextView) itemView.findViewById(R.id.edalmdfoa1);
             almtbgee=(TextView) itemView.findViewById(R.id.edalmtbgee11);





        }
    }
}
