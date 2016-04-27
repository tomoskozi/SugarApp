package com.mtomoskozi.sugarapp.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.mtomoskozi.sugarapp.BuildConfig;
import com.mtomoskozi.sugarapp.model.Person;
import com.mtomoskozi.sugarapp.R;
import com.mtomoskozi.sugarapp.presenter.MainPresenter;
import com.mtomoskozi.sugarapp.view.MainView;
import com.orm.SugarApp;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarAppApplication.injector.inject(this);

        SugarContext.init(this);

        findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person(((EditText) findViewById(R.id.editName)).getText().toString());
                mainPresenter.addPerson(p);
                mainPresenter.refreshPeople();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
        mainPresenter.refreshPeople();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showPeople(List<Person> people) {
        final ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < people.size(); ++i) {
            list.add(people.get(i));
        }
        ((ListView) findViewById(R.id.listView)).setAdapter(
                new PersonAdapter(getApplicationContext(), R.layout.list_item, list));
    }
}
