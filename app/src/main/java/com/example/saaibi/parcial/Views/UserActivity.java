package com.example.saaibi.parcial.Views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.saaibi.parcial.Controller.EventController;
import com.example.saaibi.parcial.Domain.Event;
import com.example.saaibi.parcial.R;
import com.example.saaibi.parcial.Views.Adapter.EventAdapter;

import java.util.ArrayList;
import java.util.List;


public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerStudents;
    private RecyclerView.LayoutManager mLayoutManager;
    private EventAdapter eventAdapter;
    private EventController appController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set AppController
        appController = new EventController(getApplicationContext());

        recyclerStudents = (RecyclerView) findViewById(R.id.recyclerStudents);
        recyclerStudents.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        recyclerStudents.setLayoutManager(mLayoutManager);

        //specify an adapter
        eventAdapter = new EventAdapter(this , appController.fillEvents());
        recyclerStudents.setAdapter(eventAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void ShowEvent(View view) {

        Snackbar.make(view, "hola!!!!!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
