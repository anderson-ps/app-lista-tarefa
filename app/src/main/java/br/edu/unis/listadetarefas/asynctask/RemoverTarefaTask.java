package br.edu.unis.listadetarefas.asynctask;

import android.os.AsyncTask;

import br.edu.unis.listadetarefas.adapter.ListaTarefaAdapter;
import br.edu.unis.listadetarefas.room.dao.RoomTarefaDAO;
import br.edu.unis.listadetarefas.room.entity.Tarefa;

public class RemoverTarefaTask extends AsyncTask<Void,Void,Tarefa>{

    private final RoomTarefaDAO dao;
    private final ListaTarefaAdapter adapter;
    private final Tarefa tarefa;

    public RemoverTarefaTask(RoomTarefaDAO dao, ListaTarefaAdapter adapter, Tarefa tarefa) {
        this.dao = dao;
        this.adapter = adapter;
        this.tarefa = tarefa;
    }


    @Override
    protected Tarefa doInBackground(Void... voids) {
        dao.remover(tarefa);
        return tarefa;
    }

    @Override
    protected void onPostExecute(Tarefa tarefa) {
        super.onPostExecute(tarefa);
        adapter.remove(tarefa);
        adapter.notifyDataSetChanged();
    }
}
