package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pwd ;
    Button LoginBtn;
    SharedPreferences pref;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname =(EditText) findViewById(R.id.txtName);
        pwd = (EditText) findViewById(R.id.txtPwd);
        LoginBtn =(Button) findViewById(R.id.btnLogin);

        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        intent = new Intent(MainActivity.this,Activity2.class);
        if (pref.contains("username") && pref.contains("password")){
            startActivity(intent);

        }

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =uname.getText().toString();
                String password =pwd.getText().toString();
                if (username.equals("anisa") && password.equals("12345")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login succeed", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Credentials are not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void login(View view) {
    }
}