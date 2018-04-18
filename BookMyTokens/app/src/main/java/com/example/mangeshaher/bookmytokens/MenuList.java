package com.example.mangeshaher.bookmytokens;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mangeshaher on 7/4/18.
 */

public class MenuList extends ArrayAdapter<Row>  {

    private Activity context;
    private List<Row> menulist;
    TextView date,item1,item2;
    private Button bkbtn;
    private CheckBox cb1,cb2;
    private DatabaseReference drr,arr;
    RecyclerView.ViewHolder holder;

    public MenuList(Activity context, List<Row> menulist){
        super(context,R.layout.item_list,menulist);
        this.context=context;
        this.menulist=menulist;
    }

    @NonNull
    @Override
    public View getView(int pos, View convertview , ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.item_list,null,true);
        bkbtn = (Button) listviewitem.findViewById(R.id.bkbtn);
        bkbtn.setTag(pos);
        date = (TextView)listviewitem.findViewById(R.id.date);
        item1 = (TextView)listviewitem.findViewById(R.id.it1);
        item2 = (TextView)listviewitem.findViewById(R.id.it2);
        cb1 = (CheckBox) listviewitem.findViewById(R.id.cb1);
        cb2 = (CheckBox) listviewitem.findViewById(R.id.cb2);
        Row row = menulist.get(pos);
        date.setText(row.getDate());
        item1.setText(row.getItem1());
        item2.setText(row.getItem2());
        bkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //drr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Users/18652/Tokens");
                String it_1 = item1.getText().toString();
                String it_2 = item2.getText().toString();
                String Date = date.getText().toString();
                //DatabaseReference child1 = drr.child("ID");
                //DatabaseReference child2 = drr.child("Item1");
                //DatabaseReference child3 = drr.child("Item2");
                //DatabaseReference child4 = drr.child("Date");
                ////child1.setValue("18652");
                //child2.setValue(it_1);
                //child3.setValue(it_2);
                //child4.setValue(Date);
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb1.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                }
                if(cb2.isChecked()){
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        return listviewitem;
    }

}
