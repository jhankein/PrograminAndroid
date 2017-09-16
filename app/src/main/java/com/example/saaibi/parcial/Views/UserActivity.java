package com.example.saaibi.parcial.Views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.saaibi.parcial.Controller.EventController;
import com.example.saaibi.parcial.R;
import com.example.saaibi.parcial.Views.Adapter.EventAdapter;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerStudents;
    private RecyclerView.LayoutManager mLayoutManager;
    private EventAdapter eventAdapter;
    private EventController appController;

    private MaterialSpinner spiTipeEvent;

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

        //Id.R Campos
        spiTipeEvent = (MaterialSpinner) findViewById(R.id.spiTipeEvent);

        //Manejador del Spinner
        spiTipeEvent = (MaterialSpinner) findViewById(R.id.spiTipeEvent);
        List list = new ArrayList();
        list.add("Cultural");
        list.add("Gastronomico");
        list.add("Empresarial");
        list.add("Social");
        list.add("Deportivo");
        list.add("Academico");
        list.add("Religioso");

        ArrayAdapter arrayadapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiTipeEvent.setAdapter(arrayadapter);

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
