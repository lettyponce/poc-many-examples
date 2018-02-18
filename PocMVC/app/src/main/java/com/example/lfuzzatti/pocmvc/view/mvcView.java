package com.example.lfuzzatti.pocmvc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lfuzzatti.pocmvc.R;
import com.example.lfuzzatti.pocmvc.controller.mvcController;

import java.util.List;

public class mvcView extends AppCompatActivity {

    private ListView lvTarefa;
    private Button btNovaTarefa;
    private EditText etNovaTarefa;

    private mvcController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new mvcController(this);

        lvTarefa = (ListView) findViewById(R.id.lvTarefa);
        btNovaTarefa = (Button) findViewById(R.id.btNovaTarefa);
        etNovaTarefa = (EditText) findViewById(R.id.etNovaTarefa);

        btNovaTarefa.setOnClickListener(btNovaTarefaAction);
    }

    private final View.OnClickListener btNovaTarefaAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            controller.addTarefa(etNovaTarefa.getText().toString());
            populaTarefas();
        }
    };

    private void populaTarefas() {
        List<String> tarefas = controller.getTarefas();

        lvTarefa.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                tarefas.toArray(new String[]{})));

        lvTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView row = (TextView) view;
                controller.deleteTarefa(row.getText().toString());
                populaTarefas();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
