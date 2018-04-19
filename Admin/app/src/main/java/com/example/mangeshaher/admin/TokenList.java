package com.example.mangeshaher.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TokenList extends AppCompatActivity {

    private DatabaseReference dr ;
    private List<String> main ;
    private List<ListContainer> last;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_list);
        dr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Admin");
        main = new ArrayList<>();
        last = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listview);
    }

    @Override
    protected void onStart(){
        super.onStart();
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot idshot : dataSnapshot.getChildren()){
                    String id = idshot.getKey().toString();
                    for(DataSnapshot dateshot : idshot.getChildren()){
                        //loop 2 to go through all the child nodes of books node
                        String date = dateshot.getKey().toString();
                        main.add(id);
                        main.add(date);
                        for(DataSnapshot itemshot : dateshot.getChildren()){
                            //loop 2 to go through all the child nodes of books node
                            String item = itemshot.getValue(String.class);
                            main.add(item);

                            //main.add(item);
                        }
                        //ListContainer lc = new ListContainer(main.get(0).toString(),main.get(1).toString(),main.get(2).toString(),main.get(3).toString());

                        //last.add(lc);
                    }
                }
                for (int x=0; x<main.size(); x+=4){
                    ListContainer lc = new ListContainer(main.get(x).toString(),main.get(x+1).toString(),main.get(x+2).toString(),main.get(x+3).toString());
                    last.add(lc);
                }
                MenuListt adapter = new MenuListt(TokenList.this,last);
                lv.setAdapter(adapter);
                System.out.println(main);
                //id1.setText(main.get(0).gett1().toString());
                //date1.setText(main.get(0).gett2().toString());
                //it11.setText(main.get(1).gett1().toString());
                //it12.setText(main.get(1).gett2().toString());
                //id2.setText(main.get(2).gett1().toString());
                //date2.setText(main.get(2).gett2().toString());
                //it21.setText(main.get(3).gett1().toString());
                //it22.setText(main.get(3).gett2().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
