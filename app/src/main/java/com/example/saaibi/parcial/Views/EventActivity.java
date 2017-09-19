
package com.example.saaibi.parcial.Views;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;


import com.example.saaibi.parcial.Controller.EventController;
import com.example.saaibi.parcial.R;
import com.example.saaibi.parcial.Model.EventViewModel;
import com.example.saaibi.parcial.databinding.EventActivityBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by SAAIBI on 13/9/2017.
 */

public class EventActivity extends AppCompatActivity implements Observer,View.OnClickListener  {

    private EventActivityBinding eventActivityBinding;
    private EventViewModel eventViewModel;
    private MaterialSpinner spiTipeEvent;
    private int dia, mes, año, hora, minutos, AmPm;
    private TextInputLayout tilDateEvent, tilHourEvent;
    private EditText campoDateEvent, campoHourEvent;
    private LinearLayout area_dateEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();

        campoDateEvent = (EditText) findViewById(R.id.campo_dateEvent2);

        // Referencias TILs
        tilDateEvent = (TextInputLayout) findViewById(R.id.til_dateEvent);
        tilHourEvent = (TextInputLayout) findViewById(R.id.til_hourEvent);

        // Eventos Fecha y Hora
        campoDateEvent.setOnClickListener(this);

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

        spiTipeEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                eventViewModel.TipoBuscar(adapterView.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
        setSupportActionBar(eventActivityBinding.toolbar);
        setupListEventView(eventActivityBinding.listEvent);
        setupObserver(eventViewModel);

    }

    private void initDataBinding() {
        eventActivityBinding = DataBindingUtil.setContentView(this, R.layout.event_activity);
        eventViewModel = new EventViewModel(this);
        eventActivityBinding.setMainViewModel(eventViewModel);
    }

    private void setupListEventView(RecyclerView listPeople) {
        EventAdapter adapter = new EventAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof EventViewModel) {
            EventAdapter eventAdapter = (EventAdapter) eventActivityBinding.listEvent.getAdapter();
            EventViewModel eventViewModel = (EventViewModel) observable;
            eventAdapter.setEventList(eventViewModel.getEventList());
        }
    }

    @Override
    public void onClick(View v) {
            if (v == campoDateEvent) {
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                año = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        campoDateEvent.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }
                        , dia, mes, año);
                datePickerDialog.updateDate(año, mes, dia);
                datePickerDialog.show();
            }
            if (v == campoHourEvent || v == tilHourEvent) {
                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);
                AmPm = c.get(Calendar.AM_PM);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hora = hourOfDay;
                        minutos = minute;

                        String AM_PM;
                        if (hourOfDay < 12) {
                            AM_PM = "AM";

                        } else {
                            AM_PM = "PM";
                            hora = hora - 12;
                        }
                        campoHourEvent.setText(hora + ":" + minutos + " " + AM_PM);

                    }

                }, hora, minutos, false);
                timePickerDialog.show();
            }

    }
}
