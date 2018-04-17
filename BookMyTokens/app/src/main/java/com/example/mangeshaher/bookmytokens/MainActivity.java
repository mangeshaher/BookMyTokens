package com.example.mangeshaher.bookmytokens;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {

    private EditText studentid;
    private EditText name;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText roomno;
    private Button buttonSignup;
    private ProgressDialog progressDialog;
    private TextView textViewSignin;

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mrootref;
    private DatabaseReference nrootref;
    //private DatabaseReference nrootref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();
        final String url = "https://bookmytokens-a94d3.firebaseio.com/Users";
        mrootref = FirebaseDatabase.getInstance().getReferenceFromUrl(url);
        //initializing views
        studentid =(EditText)findViewById(R.id.studentid);
        name=(EditText)findViewById(R.id.name);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        roomno = (EditText) findViewById(R.id.roomno);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        textViewSignin  = (TextView) findViewById(R.id.textViewSignUp);
        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        textViewSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Profile.class));
            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = studentid.getText().toString();

                DatabaseReference child = mrootref.child(key);
                String urll = url.concat("/").concat(key).concat("/");
                nrootref=FirebaseDatabase.getInstance().getReferenceFromUrl(urll);
                String keyy1 = "email";
                String value1 = editTextEmail.getText().toString();
                String keyy2 = "password";
                String value2 = editTextPassword.getText().toString();
                String keyy3 = "roomno";
                String value3 = roomno.getText().toString();
                String keyy4 = "name";
                String value4 = name.getText().toString();
                //BackGround bg = new BackGround(MainActivity.this);
                //bg.execute(urll,value1,value2,value3);
                DatabaseReference child1 = nrootref.child(keyy1);
                child1.setValue(value1);
                DatabaseReference child2 = nrootref.child(keyy2);
                child2.setValue(value2);
                DatabaseReference child3 = nrootref.child(keyy3);
                child3.setValue(value3);
                DatabaseReference child4 = nrootref.child(keyy4);
                child4.setValue(value4);

            }
        });

    }
}
