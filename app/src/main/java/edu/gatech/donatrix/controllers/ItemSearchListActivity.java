package edu.gatech.donatrix.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.donatrix.R;

/**
 * An Activity to display the list of searched items.
 */
public class ItemSearchListActivity extends AppCompatActivity {

    ListView listView;
    final List list = new ArrayList();
    ArrayAdapter adapter;

    /**
     * Activity initializer
     *
     * @param savedInstanceState the activity state
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_list);

        listView = findViewById(R.id.list_view);
        list.add("Orange");
        list.add("Orange");
        list.add("Orange");
        list.add("Orange");
        list.add("Orange");
        list.add("Orange");

        adapter = new ArrayAdapter(ItemSearchListActivity.this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}