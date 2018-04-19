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

    private DatabaseReference drr,arr;
    private ListView lv;
    private List<Row> menulist ;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    private CheckBox cb11,cb12,cb21,cb22,cb31,cb32,cb41,cb42,cb51,cb52,cb61,cb62,cb71,cb72;
    private TextView d1,d2,d3,d4,d5,d6,d7,t11,t12,t21,t22,t31,t32,t41,t42,t51,t52,t61,t62,t71,t72;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tokens);
        drr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu");
        menulist = new ArrayList<>();
        bt1 = (Button) findViewById(R.id.bkbtn1);
        bt2 = (Button) findViewById(R.id.bkbtn2);
        bt3 = (Button) findViewById(R.id.bkbtn3);
        bt4 = (Button) findViewById(R.id.bkbtn4);
        bt5 = (Button) findViewById(R.id.bkbtn5);
        bt6 = (Button) findViewById(R.id.bkbtn6);
        bt7 = (Button) findViewById(R.id.bkbtn7);
        d1 = (TextView) findViewById(R.id.date1);
        d2 = (TextView)findViewById(R.id.date2);
        d3 = (TextView)findViewById(R.id.date3);
        d4 = (TextView)findViewById(R.id.date4);
        d5 = (TextView)findViewById(R.id.date5);
        d6 = (TextView)findViewById(R.id.date6);
        d7 = (TextView)findViewById(R.id.date7);
        t11 = (TextView) findViewById(R.id.it11);
        t21 = (TextView) findViewById(R.id.it21);
        t31 = (TextView) findViewById(R.id.it31);
        t41 = (TextView) findViewById(R.id.it41);
        t51 = (TextView) findViewById(R.id.it51);
        t61 = (TextView) findViewById(R.id.it61);
        t71 = (TextView) findViewById(R.id.it71);
        t12 = (TextView) findViewById(R.id.it12);
        t22 = (TextView) findViewById(R.id.it22);
        t32 = (TextView) findViewById(R.id.it32);
        t42 = (TextView) findViewById(R.id.it42);
        t52 = (TextView) findViewById(R.id.it52);
        t62 = (TextView) findViewById(R.id.it62);
        t72 = (TextView) findViewById(R.id.it72);
        cb11 = (CheckBox) findViewById(R.id.cb11);
        cb21 = (CheckBox) findViewById(R.id.cb21);
        cb31 = (CheckBox) findViewById(R.id.cb31);
        cb41 = (CheckBox) findViewById(R.id.cb41);
        cb51 = (CheckBox) findViewById(R.id.cb51);
        cb61 = (CheckBox) findViewById(R.id.cb61);
        cb71 = (CheckBox) findViewById(R.id.cb71);
        cb12 = (CheckBox) findViewById(R.id.cb12);
        cb22 = (CheckBox) findViewById(R.id.cb22);
        cb32 =(CheckBox) findViewById(R.id.cb32);
        cb42 = (CheckBox) findViewById(R.id.cb42);
        cb52 = (CheckBox) findViewById(R.id.cb52);
        cb62 = (CheckBox) findViewById(R.id.cb62);
        cb72 = (CheckBox) findViewById(R.id.cb72);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t11.getText().toString();
                String it_2 = t12.getText().toString();
                String Date = d1.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb11.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb12.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t21.getText().toString();
                String it_2 = t22.getText().toString();
                String Date = d2.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb21.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb22.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t31.getText().toString();
                String it_2 = t32.getText().toString();
                String Date = d3.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb31.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb32.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t41.getText().toString();
                String it_2 = t42.getText().toString();
                String Date = d4.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb41.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("");
                }
                if(cb42.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t51.getText().toString();
                String it_2 = t52.getText().toString();
                String Date = d5.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb51.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb52.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t61.getText().toString();
                String it_2 = t62.getText().toString();
                String Date = d6.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb61.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb62.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String it_1 = t71.getText().toString();
                String it_2 = t72.getText().toString();
                String Date = d7.getText().toString();
                String id = "18652";
                String base = "https://bookmytokens-a94d3.firebaseio.com/Admin";
                String bbase = base.concat("/").concat(id).concat("/");
                String bbbase = bbase.concat("/").concat(Date).concat("/");
                arr = FirebaseDatabase.getInstance().getReferenceFromUrl(bbbase);
                if(cb71.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue(it_1);
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue("0");
                }
                if(cb72.isChecked()){
                    DatabaseReference chhild1 = arr.child("Item1");
                    chhild1.setValue("0");
                    DatabaseReference chhild2 = arr.child("Item2");
                    chhild2.setValue(it_2);
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        drr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot menushot : dataSnapshot.getChildren()){
                    Row row = menushot.getValue(Row.class);
                    menulist.add(row);
                }
                d1.setText(menulist.get(0).getDate().toString());
                d2.setText(menulist.get(1).getDate().toString());
                d3.setText(menulist.get(2).getDate().toString());
                d4.setText(menulist.get(3).getDate().toString());
                d5.setText(menulist.get(4).getDate().toString());
                d6.setText(menulist.get(5).getDate().toString());
                d7.setText(menulist.get(6).getDate().toString());
                t11.setText(menulist.get(0).getItem1().toString());
                t21.setText(menulist.get(1).getItem1().toString());
                t31.setText(menulist.get(2).getItem1().toString());
                t41.setText(menulist.get(3).getItem1().toString());
                t51.setText(menulist.get(4).getItem1().toString());
                t61.setText(menulist.get(5).getItem1().toString());
                t71.setText(menulist.get(6).getItem1().toString());
                t12.setText(menulist.get(0).getItem2().toString());
                t22.setText(menulist.get(1).getItem2().toString());
                t32.setText(menulist.get(2).getItem2().toString());
                t42.setText(menulist.get(3).getItem2().toString());
                t52.setText(menulist.get(4).getItem2().toString());
                t62.setText(menulist.get(5).getItem2().toString());
                t72.setText(menulist.get(6).getItem2().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
