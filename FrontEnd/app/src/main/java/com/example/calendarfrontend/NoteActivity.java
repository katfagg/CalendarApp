package com.example.calendarfrontend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class NoteActivity extends AppCompatActivity {

        static ArrayList<String> notes = new ArrayList<>();
        static ArrayAdapter arrayAdapter;


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.add_note_menu, menu);

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            super.onOptionsItemSelected(item);

            if (item.getItemId() == R.id.add_note) {
                Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);

                startActivity(intent);

                return true;
            }
            return false;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.notes);

            ListView listView = (ListView) findViewById(R.id.listView);

            SharedPreferences sharedPreferences = getApplication().getSharedPreferences("com.notes", Context.MODE_PRIVATE);

            HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

            if (set == null) {
                notes.add("Type note here...");
            } else {
                notes = new ArrayList<>(set);
            }


            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);

            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
                    intent.putExtra("noteId", i);
                    startActivity(intent);
                }

            });

            //                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                        int itemToDelete = i;
//
//                        new AlertDialog.Builder(getApplicationContext())
//                                .setIcon(android.R.drawable.ic_dialog_alert)
//                                .setTitle("Are you sure?")
//                                .setMessage("Do you want to delete this note?")
//                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                                        notes.remove(itemToDelete); //changed from 'i' to 'itemToDelete' so it doesn't call the above i
//                                        arrayAdapter.notifyDataSetChanged();
//
//                                        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("com.notes", Context.MODE_PRIVATE);
//
//                                        HashSet<String> set = new HashSet(MainActivity.notes);
//
//                                        sharedPreferences.edit().putStringSet("notes", set).apply(); // set is now updated when a note is deleted
//                                    }
//
//                                })
//                                .setNegativeButton("No", null)
//                                .show();
//                        return true;
//
//                    }
//                }); // add delete button and save button, fix note button
        }
    }