package com.example.deepak.sharedprefernces;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button submit, exit;
    String username, password;
    EditText userinput, passinput;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInit();
    }





    public void getInit() {
        submit = (Button) findViewById(R.id.submit);
        exit = (Button) findViewById(R.id.exit);
        userinput = (EditText) findViewById(R.id.userinput);
        passinput = (EditText) findViewById(R.id.passinput);
        submit.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    public void sharedPrefernces() {

        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Username", username);
        toEdit.putString("Password", password);
        toEdit.commit();

    }

    @Override
    public void onClick(View currentButton) {
        switch (currentButton.getId()) {
            case R.id.submit:
                username = userinput.getText().toString();
                password = passinput.getText().toString();
                sharedPrefernces();
                Toast.makeText(this, "Details are saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();
        }
    }




}
