package com.example.mangeshaher.bookmytokens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookTokens extends AppCompatActivity {

    private DatabaseReference dr ,drr,arr;
    private ListView lv;
    private List<Row> menulist ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tokens);
        menulist = new ArrayList<>();
        dr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu");
        lv = findViewById(R.id.menulist);

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

                MenuList adapter = new MenuList(BookTokens.this,menulist);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
