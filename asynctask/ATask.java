package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ATask extends AsyncTask<Void, String, Void> {
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private boolean isRunning = true;

    public ATask(ArrayAdapter<String> adapter, List<String> dataList) {
        this.adapter = adapter;
        this.dataList = dataList;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int counter = 1;
        while (isRunning) {
            // Symulujemy dodawanie danych co 5 sekund
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress("New Item " + counter++);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        // Dodajemy nowe dane do listy
        dataList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    public void stopTask() {
        isRunning = false;
    }
}

