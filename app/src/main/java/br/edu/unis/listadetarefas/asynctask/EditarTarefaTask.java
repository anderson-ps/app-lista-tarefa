package br.edu.unis.listadetarefas.asynctask;

import android.os.AsyncTask;

import br.edu.unis.listadetarefas.room.dao.RoomTarefaDAO;
import br.edu.unis.listadetarefas.room.entity.Tarefa;

public class EditarTarefaTask extends AsyncTask<Void,Void,Void> {

    private final RoomTarefaDAO dao;
    private final Tarefa tarefa;

    public EditarTarefaTask(RoomTarefaDAO dao, Tarefa tarefa) {
        this.dao = dao;
        this.tarefa = tarefa;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.editar(tarefa);
        return null;
    }
}
