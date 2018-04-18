package com.example.mangeshaher.bookmytokens;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CalendarView cv;
    private Button bt;
    private DatabaseReference root;
    final String url = "https://bookmytokens-a94d3.firebaseio.com/Menu";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Button Defined
        bt = (Button)findViewById(R.id.bookbutton);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Calender Date Marking
        cv = (CalendarView) findViewById(R.id.cview);
        cv.setDate(System.currentTimeMillis(),false,true);
        cv.setMinDate(cv.getDate()+86400000);
        cv.setMaxDate(cv.getDate()+ 604800000 );

        //Database Setting of Days
        SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");
        long dt = cv.getDate();
        Date date1 = new Date(dt+86400000);
        Date date2 = new Date(dt+86400000+86400000);
        Date date3 = new Date(dt+86400000+86400000+86400000);
        Date date4 = new Date(dt+86400000+86400000+86400000+86400000);
        Date date5 = new Date(dt+86400000+86400000+86400000+86400000+86400000);
        Date date6 = new Date(dt+86400000+86400000+86400000+86400000+86400000+86400000);
        Date date7 = new Date(dt+86400000+86400000+86400000+86400000+86400000+86400000+86400000);



        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day1");
        DatabaseReference ch1 = root.child("Date");
        ch1.setValue(sf.format(date1));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day2");
        DatabaseReference ch2 = root.child("Date");
        ch2.setValue(sf.format(date2));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day3");
        DatabaseReference ch3 = root.child("Date");
        ch3.setValue(sf.format(date3));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day4");
        DatabaseReference ch4 = root.child("Date");
        ch4.setValue(sf.format(date4));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day5");
        DatabaseReference ch5 = root.child("Date");
        ch5.setValue(sf.format(date5));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day6");
        DatabaseReference ch6 = root.child("Date");
        ch6.setValue(sf.format(date6));
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bookmytokens-a94d3.firebaseio.com/Menu/Day7");
        DatabaseReference ch7 = root.child("Date");
        ch7.setValue(sf.format(date7));

        //Book Activity Reference Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,BookTokens.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id==R.id.book){
            startActivity(new Intent(Profile.this,BookTokens.class));
        }
        else if (id==R.id.view){
            startActivity(new Intent(Profile.this,Viewtoken.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
