package com.example.saaibi.parcial.Views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saaibi.parcial.Controller.ApplicationController;
import com.example.saaibi.parcial.Controller.UserController;
import com.example.saaibi.parcial.Domain.User;
import com.example.saaibi.parcial.R;

public class LoginActivity extends AppCompatActivity {
    private EditText campoUserName;
    private EditText campoPassword;
    private TextInputLayout tilNombre;
    private TextInputLayout tilTelefono;
    ApplicationController appController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appController =(ApplicationController)getApplication();

        // Referencias ETs
        campoUserName = (EditText) this.findViewById(R.id.campo_nombre);
        campoPassword = (EditText) this.findViewById(R.id.campo_password);

        // Referencias TILs
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_password);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.userCreate();
            }
        });
        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.btnLogin);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = tilNombre.getEditText().getText().toString();
                String password = tilTelefono.getEditText().getText().toString();

                appController.authenticate(nombre,password);
            }
        });
    }

    public void login (View view) {
        //System.out.println(userName.getText().toString() + " <:> " + password.getText().toString());
        //appController.authenticate(userName.getText().toString(), password.getText().toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
}
