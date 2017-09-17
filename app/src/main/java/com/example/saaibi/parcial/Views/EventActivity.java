
package com.example.saaibi.parcial.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.example.saaibi.parcial.R;
import com.example.saaibi.parcial.Viewmodel.EventViewModel;
import com.example.saaibi.parcial.databinding.EventActivityBinding;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by SAAIBI on 13/9/2017.
 */

public class EventActivity extends AppCompatActivity implements Observer {

    private EventActivityBinding eventActivityBinding;
    private EventViewModel eventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initDataBinding();
        setSupportActionBar(eventActivityBinding.toolbar);
        setupListPeopleView(eventActivityBinding.listEvent);
        setupObserver(eventViewModel);
        eventViewModel.onClickFabLoad(null);
    }

    private void initDataBinding() {
        eventActivityBinding = DataBindingUtil.setContentView(this, R.layout.event_activity);
        eventViewModel = new EventViewModel(this);
        eventActivityBinding.setMainViewModel(eventViewModel);
    }

    private void setupListPeopleView(RecyclerView listPeople) {
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_github) {
            startActivityActionView();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startActivityActionView() {
        //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PeopleFactory.PROJECT_URL)));
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof EventViewModel) {
            EventAdapter eventAdapter = (EventAdapter) eventActivityBinding.listEvent.getAdapter();
            EventViewModel eventViewModel = (EventViewModel) observable;
            eventAdapter.setEventList(eventViewModel.getEventList());
        }
    }
}
