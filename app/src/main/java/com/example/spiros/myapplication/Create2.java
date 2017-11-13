package com.example.spiros.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create2 extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef;

    Button submit;
    EditText  editlastname,editfirstname,editemail,edittel,editaddress, editcountry, edittk, editcomments;
    Spinner editrent,edithouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Log.d("TheApp", "application created");
        dbRef = db.getReference("/Adds/");



        editfirstname = (EditText)findViewById(R.id.firstname);
        editlastname = (EditText)findViewById(R.id.lastname);
        editemail = (EditText)findViewById(R.id.email);
        edittel = (EditText)findViewById(R.id.tel);
        editaddress = (EditText)findViewById(R.id.address);
        editcountry = (EditText)findViewById(R.id.country);
        edittk = (EditText)findViewById(R.id.tk);
        editcomments = (EditText)findViewById(R.id.comments);

        editrent= (Spinner) findViewById(R.id.rent);
        edithouse=(Spinner) findViewById(R.id.house);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {

                         addVasi();

            }
        });




    }


    public void addVasi(){
        String id = dbRef.push().getKey();
        String editLastname = editlastname.getText().toString().trim();
        String editFirstname = editfirstname.getText().toString().trim();
        String editEmail = editemail.getText().toString().trim();
        String editTel = edittel.getText().toString().trim();
        String editAddress = editaddress.getText().toString().trim();
        String editCountry = editcountry.getText().toString().trim();
        String editTk = edittk.getText().toString().trim();
        String editComments = editcomments.getText().toString().trim();
        String rent = editrent.getSelectedItem().toString();
        String house = edithouse.getSelectedItem().toString();
        Vasi2 vasi = new Vasi2(id,editLastname,editFirstname,editEmail,editTel,rent,house,editAddress,editCountry,editTk,editComments);

        dbRef.child(id).setValue(vasi);

    }

}
