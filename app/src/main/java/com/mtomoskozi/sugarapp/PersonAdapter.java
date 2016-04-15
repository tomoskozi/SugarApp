package com.mtomoskozi.sugarapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mtomoskozi on 4/15/16.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    HashMap<Person, Integer> mIdMap = new HashMap<Person, Integer>();

    public PersonAdapter(Context context, int textViewResourceId,
                         List<Person> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        Person item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


}
