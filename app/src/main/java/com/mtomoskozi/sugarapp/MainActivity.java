package com.mtomoskozi.sugarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Person> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);

        if (BuildConfig.FLAVOR == "mock") {
            values = new LinkedList<>();
            values.add(new Person("Mama"));
            values.add(new Person("Papa"));
        }

        showList();

        findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person(((EditText) findViewById(R.id.editName)).getText().toString());

                savePerson(p);
                showList();
            }
        });
    }

    protected void savePerson(Person p) {
        if (BuildConfig.FLAVOR == "mock") {
            values.add(p);
        }
        else {
            p.save();
        }
    }

    protected void showList() {
        if (BuildConfig.FLAVOR == "prod") {
            values = Person.listAll(Person.class);
        }
        final ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < values.size(); ++i) {
            list.add(values.get(i));
        }
        ((ListView) findViewById(R.id.listView)).setAdapter(
                new PersonAdapter(getApplicationContext(), R.layout.list_item, list));
    }
}
