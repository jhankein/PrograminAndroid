package com.example.saaibi.parcial.Views;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.saaibi.parcial.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener  {

    private MaterialSpinner spiTipeEvent;
    private int dia, mes, año, hora, minutos, AmPm;

    private LinearLayout areaDateEvent ,areaHourEvent;
    private TextInputLayout tilDateEvent , tilHourEvent;
    private EditText campoDateEvent , campoHourEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Id.R de Fechas y horas
        tilDateEvent = (TextInputLayout) findViewById(R.id.til_dateEvent);
        tilHourEvent = (TextInputLayout) findViewById(R.id.til_hourEvent);

        // Referencias TILs
        campoDateEvent = (EditText) findViewById(R.id.campo_dateEvent);
        campoHourEvent = (EditText) findViewById(R.id.campo_hourEvent);

        campoDateEvent.setOnClickListener(this);
        campoHourEvent.setOnClickListener(this);

        tilDateEvent.setOnClickListener(this);
        tilHourEvent.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        spiTipeEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdminActivity.this, "Tipo de evento : " + String.valueOf(spiTipeEvent.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Fin manejador del spinner
    }

    //Metodos de fechas y horas
    @Override
    public void onClick(View v) {
        if (v == campoDateEvent || v == tilDateEvent) {
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
