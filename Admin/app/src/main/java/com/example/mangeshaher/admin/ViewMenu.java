package com.example.mangeshaher.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewMenu extends AppCompatActivity {

    private DatabaseReference dr ;
    private ListView lv;
    private List<Row> menulist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menu);
        menulist = new ArrayList<>();
        dr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu");
        lv = (ListView) findViewById(R.id.menulist);
    }

    @Override
    protected void onStart(){
        super.onStart();
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menulist.clear();
                for(DataSnapshot menushot : dataSnapshot.getChildren()){
                    Row row = menushot.getValue(Row.class);
                    menulist.add(row);

                }

                MenuList adapter = new MenuList(ViewMenu.this,menulist);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
