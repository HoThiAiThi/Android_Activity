package com.example.w3_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText editUser, editPass;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        editUser = findViewById(R.id.txt_userupdate);
        editPass = findViewById(R.id.txt_passupdate);
        btnUpdate = findViewById(R.id.btn_update);

//       getSupportActionBar().setTitle("Activity 2");
        editUser.setText(getIntent().getStringExtra("key_user"));
        editPass.setText(getIntent().getStringExtra("key_pass"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });
    }
    private void backActivity() {
        String strUserUpdate = editUser.getText().toString().trim();
        String strPasslUpdate = editPass.getText().toString().trim();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("key_user",strUserUpdate);
        returnIntent.putExtra("key_pass",strPasslUpdate);
        setResult(Activity2.RESULT_OK,returnIntent);
        finish();


    }
}