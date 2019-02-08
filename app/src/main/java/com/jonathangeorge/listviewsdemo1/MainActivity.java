package com.jonathangeorge.listviewsdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        ListView myList = (ListView) findViewById(R.id.myList);

        //array list of games we want in the list
        final ArrayList<String> gameNames = new ArrayList<String>();

        gameNames.add("Five Tribes");
        gameNames.add("Anachrony");
        gameNames.add("Trickerion");
        gameNames.add("A Feast for Odin");
        gameNames.add("Great Western Trial");
        gameNames.add("Blood Rage");

        //we could also build this differently...
        /*
        ArrayList<String> gameList = new ArrayList<string>(asList("Five Tribes", "...."));


        */


        //  now we put these names in list view
        //using array adaptor

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, gameNames);

        //attach
        myList.setAdapter(arrayAdapter);


        // making list clickable
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                this is adding functionality to code that is given already when we click
                adapter vVew is this list view what was taped... the ? is generic because we might
                not know what list view was selected... parent is the name
                Example:

                 parent.setVisibilty(View.Gone)

                 use if we wanted the table to vanish when clicked


                View view ---- this is esentually the row
                int position is the number in row starts with 0
                long id same as position?
                */

                //Log what was clicked
                Log.i("Game tapped: ", gameNames.get(position));

                //adding a toast
                Toast.makeText(getApplicationContext(), gameNames.get(position) + " Is a great game",
                        Toast.LENGTH_LONG).show();


            }
        });

    }
}
