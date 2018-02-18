package com.example.lfuzzatti.pocmvc.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mvcModel {

    private Context context;

    private SQLiteOpenHelper helper;
    private SQLiteDatabase database;

    private static final String DB_NAME = "tarefas_db";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "tarefa";


    public mvcModel(final Context context) {

        this.helper = new SQLiteOpenHelper(context, mvcModel.DB_NAME, null,
                                            mvcModel.DB_VERSION) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {

                String queryCreate = "CREATE TABLE tarefa (id integer primary key autoincrement," +
                        "titulo text not null)";

                sqLiteDatabase.execSQL(queryCreate);

            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

                String queryUpdate = "DROP TABLE IF EXISTS tarefa";
                sqLiteDatabase.execSQL(queryUpdate);
                this.onCreate(sqLiteDatabase);
            }
        };

        this.database = this.helper.getWritableDatabase();
    }

    public void addTarefa(ContentValues data) {
        this.database.insert(mvcModel.DB_TABLE, null, data);
    }

    public void deleteTarefa(String field_params) {
        this.database.delete(mvcModel.DB_TABLE, field_params, null);
    }

    public Cursor loadAllTarefa() {
        final Cursor c = this.database.query(
                mvcModel.DB_TABLE,
                new String[] {"titulo"},
                null,
                null,
                null,
                null,
                null);

        return c;
    }
}
