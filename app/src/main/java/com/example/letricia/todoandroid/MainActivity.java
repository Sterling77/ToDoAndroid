package com.example.letricia.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    EditText text;
    Button addButton;
    ArrayAdapter<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.textView);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v){
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
    }

    @Override
    public boolean setOnItemLongClick(AdapterView<?>parent, View view, int postion, long id){
        String item = items.getItem(postion);
        items.remove(item);
        return true;
    }
}
