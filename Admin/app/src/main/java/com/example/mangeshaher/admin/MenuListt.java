package com.example.mangeshaher.admin;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mangeshaher on 19/4/18.
 */

public class MenuListt extends ArrayAdapter<ListContainer> {
    private Activity context;
    private List<ListContainer> menulist;
    TextView date,id,item1,item2;

    public MenuListt(Activity context, List<ListContainer> menulist){
        super(context,R.layout.list_item,menulist);
        this.context=context;
        this.menulist=menulist;
    }

    @NonNull
    @Override
    public View getView(int pos, View convertview , ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.list_item,null,true);
        date = (TextView)listviewitem.findViewById(R.id.date);
        id = (TextView) listviewitem.findViewById(R.id.id) ;
        item1 = (TextView)listviewitem.findViewById(R.id.it1);
        item2 = (TextView)listviewitem.findViewById(R.id.it2);
        ListContainer row = menulist.get(pos);
        date.setText(row.getdate());
        id.setText(row.getid());
        item1.setText(row.gett1());
        item2.setText(row.gett2());
        return listviewitem;
    }
}
