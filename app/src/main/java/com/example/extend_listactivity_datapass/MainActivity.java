package com.example.extend_listactivity_datapass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

     ListView list_view;
     String [] str_array ={"Hello","world","java"};
     ArrayAdapter<String> str_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        list_view=getListView();

        str_adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,str_array);

        list_view.setAdapter(str_adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Way -> 1
                //Taking a string variable and storing the specific element inside it, using position as array index
                //code below -->


                String text_1 = str_array[position];
                Toast.makeText(MainActivity.this,text_1+" position is "+position,Toast.LENGTH_SHORT).show();


                //Way -> 2
                //Taking a string variable and storing the specific element inside it by using ArrayAdapter, using position as array index
                //code below -->

                String text_2 = str_adapter.getItem(position);
                Toast.makeText(MainActivity.this,text_2+" position is "+position,Toast.LENGTH_SHORT).show();


                //Way -> 3
                //Taking a string variable and storing the specific string text with textview.getText().toString() method
                //code below -->

                String text_3 = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this,text_3+" position is "+position,Toast.LENGTH_SHORT).show();


            }
        });


    }
}