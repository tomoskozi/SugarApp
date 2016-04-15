package com.mtomoskozi.sugarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        Person.findById(Person.class, (long) 1);

        findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person(((EditText) findViewById(R.id.editName)).getText().toString());
                p.save();

                List<Person> values = Person.find(Person.class, "*");
                final ArrayList<Person> list = new ArrayList<Person>();
                for (int i = 0; i < values.size(); ++i) {
                    list.add(values.get(i));
                }
                ((ListView) findViewById(R.id.listView)).setAdapter(
                        new PersonAdapter(getApplicationContext(), R.layout.list_item, list));
            }
        });
    }
}
