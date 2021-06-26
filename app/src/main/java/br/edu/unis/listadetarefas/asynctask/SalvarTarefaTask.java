package br.edu.unis.listadetarefas.asynctask;

import android.os.AsyncTask;

import br.edu.unis.listadetarefas.adapter.ListaTarefaAdapter;
import br.edu.unis.listadetarefas.room.dao.RoomTarefaDAO;
import br.edu.unis.listadetarefas.room.entity.Tarefa;

public class SalvarTarefaTask extends AsyncTask<Void,Void,Void > {

    private final RoomTarefaDAO dao;
    //private final ListaTarefaAdapter adapter;
    private final Tarefa tarefa;

    public SalvarTarefaTask(RoomTarefaDAO dao, Tarefa tarefa) {
        this.dao = dao;
        //this.adapter = adapter;
        this.tarefa = tarefa;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.salvar(tarefa);
        return null;
    }

}
