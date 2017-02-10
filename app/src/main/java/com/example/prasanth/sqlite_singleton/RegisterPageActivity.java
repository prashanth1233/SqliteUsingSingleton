package com.example.prasanth.sqlite_singleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPageActivity extends Activity {

    private Button sndData;
    private EditText first_Name,last_Name,nickName;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        sndData=(Button)findViewById(R.id.button1);
        sndData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterPageActivity.this,"model object creatd",Toast.LENGTH_SHORT).show();
                first_Name=(EditText)findViewById(R.id.name1);
                last_Name=(EditText)findViewById(R.id.name2);
                nickName=(EditText)findViewById(R.id.age);
                Model model= new Model();
                model.setFirstName(first_Name.getText().toString());
                model.setLastName(last_Name.getText().toString());
                model.setNickName(nickName.getText().toString());
                SqlData sqlData=SqlData.getObject(getApplicationContext());
                long checking=sqlData.insertData(model);
                if(checking==-1)
                    Toast.makeText(RegisterPageActivity.this, "REGISTRATION FAILED", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(RegisterPageActivity.this,"DATA SUCSSFULLY INSERTED",Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterPageActivity.this, "SUCCESSFULLY REGISTERED", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterPageActivity.this,LoginPageActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
