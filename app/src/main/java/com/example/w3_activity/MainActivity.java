package com.example.w3_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUETS_CODE = 10;
    private EditText editUser,editPass;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = findViewById(R.id.txt_user);
        editPass = findViewById(R.id.txt_pass);
        btnSend = findViewById(R.id.btn_send);
     //   getSupportActionBar().setTitle("Activity 1");
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();

            }
        });
    }

    private void nextActivity() {
        String strUser = editUser.getText().toString().trim();
        String strPass = editPass.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("key_user",strUser);
        intent.putExtra("key_pass",strPass);
        startActivityForResult(intent,MY_REQUETS_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (MY_REQUETS_CODE == requestCode && resultCode == Activity.RESULT_OK){
            editUser.setText(data.getStringExtra("key_user"));
            editPass.setText(data.getStringExtra("key_pass"));
        }
    }
}