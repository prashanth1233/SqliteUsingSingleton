package com.example.prasanth.sqlite_singleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPageActivity extends Activity {
    private Button register,findAge;
    private EditText fstName,lstName;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        register=(Button)findViewById(R.id.register);
        findAge=(Button)findViewById(R.id.ageFind);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPageActivity.this,RegisterPageActivity.class);
                startActivity(intent);
            }
        });
        findAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frstName,lastName;
                fstName=(EditText)findViewById(R.id.firstName);
                lstName=(EditText)findViewById(R.id.LastName);
                 frstName=fstName.getText().toString();
                 lastName=lstName.getText().toString();
                SqlData sqlData=SqlData.getObject(LoginPageActivity.this);
                String nickName= sqlData.searchingData(frstName,lastName);
                if(nickName==null) {
                    Toast.makeText(LoginPageActivity.this, "DATA NOT FOUND.PLEASE REGISTER", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginPageActivity.this,"NICKNAME IS "+nickName,Toast.LENGTH_LONG).show();
            }
        });
    }


}
