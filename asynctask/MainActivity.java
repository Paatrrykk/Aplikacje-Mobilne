package com.example.asynctask;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnAdd, btnShowList;
    private EditText editTextItem;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private ATask updateTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        btnAdd = findViewById(R.id.btn_add);
        btnShowList = findViewById(R.id.btn_show_list);
        editTextItem = findViewById(R.id.editTextItem);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // Dodawanie nowego elementu do listy
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editTextItem.getText().toString();
                if (!newItem.isEmpty()) {
                    dataList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editTextItem.setText("");  // Czyścimy pole po dodaniu
                } else {
                    Toast.makeText(MainActivity.this, "Enter a valid item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Kliknięcie na element listy w celu edytowania
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Otwieramy dialog edycji elementu
            showEditDialog(position);
        });

        // Przycisk do pokazania pełnej listy
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFullListDialog();
            }
        });
    }

    // Funkcja do pokazywania pełnej listy w dialogu
    private void showFullListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Full List");

        // Tworzymy nową listę w formie Stringa
        StringBuilder listString = new StringBuilder();
        for (String item : dataList) {
            listString.append(item).append("\n");
        }

        builder.setMessage(listString.toString());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    // Funkcja do pokazywania dialogu edycji elementu listy
    private void showEditDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Edit Item");

        // Pole tekstowe do edycji
        final EditText input = new EditText(MainActivity.this);
        input.setText(dataList.get(position));
        builder.setView(input);

        // Ustawiamy przycisk "Save" do zatwierdzenia zmian
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editedItem = input.getText().toString();
                if (!editedItem.isEmpty()) {
                    dataList.set(position, editedItem);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Item cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Przycisk "Cancel", aby anulować operację
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}


