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





public class myadapterupdat extends RecyclerView.Adapter<myadapterupdat.viweholderstd> {

    ArrayList<info_accont> std;
    Context c;

    public myadapterupdat(ArrayList<info_accont> std, Context cc ) {
        this.std = std;
        this.c=cc;
    }

    @Override
    public viweholderstd onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.costom_layout,null,false);
        viweholderstd vhs=new viweholderstd(v);






        return vhs;
    }

    @Override
    public void onBindViewHolder(viweholderstd holder, int position) {
 final info_accont info=std.get(position);

        holder.name.setText(info.getName());
        holder.card.setText(info.getCard());
        holder.phon.setText(info.getPhon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(c, update_accont.class);

                i.putExtra("name",info.getName());
                i.putExtra("card",info.getCard());
                i.putExtra("phon",info.getPhon());

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
         TextView name,card,phon;


        public viweholderstd(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.et1);
            card=(TextView) itemView.findViewById(R.id.et2);
            phon=(TextView) itemView.findViewById(R.id.et3);






        }
    }
}
