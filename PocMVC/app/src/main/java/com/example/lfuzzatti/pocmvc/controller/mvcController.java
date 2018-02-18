package com.example.lfuzzatti.pocmvc.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.lfuzzatti.pocmvc.model.mvcModel;

import java.util.ArrayList;
import java.util.List;

public class mvcController {

    private List<String> tarefas;
    private mvcModel model;

    public mvcController(Context context) {
        this.tarefas = new ArrayList<>();
        this.model = new mvcModel(context);
    }

    public void addTarefa(final String titulo){
        final ContentValues data = new ContentValues();
        data.put("titulo", titulo);
        model.addTarefa(data);
    }

    public void deleteTarefa(final String titulo){
        model.deleteTarefa("titulo = '"+ titulo + "'");
    }

    public void deleteTarefa(final long id){
        model.deleteTarefa("id = '"+ id +"'");
    }

    public void deleteAllTarefa(){
        model.deleteTarefa(null);
    }

    public List<String> getTarefas() {

        Cursor cursor = model.loadAllTarefa();
        tarefas.clear();

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.isAfterLast() == false) {
                tarefas.add(cursor.getString(0));
                cursor.moveToNext();
            }

            cursor.close();
        }

        return tarefas;
    }
}
