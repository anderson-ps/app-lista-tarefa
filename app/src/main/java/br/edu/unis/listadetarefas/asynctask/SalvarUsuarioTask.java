package br.edu.unis.listadetarefas.asynctask;

import android.os.AsyncTask;

import br.edu.unis.listadetarefas.room.dao.RoomUsuarioDAO;
import br.edu.unis.listadetarefas.room.entity.Usuario;

public class SalvarUsuarioTask extends AsyncTask<Void,Void,Void> {

    private final RoomUsuarioDAO dao;
    private final Usuario usuarioCriado;

    public SalvarUsuarioTask(RoomUsuarioDAO dao, Usuario usuarioCriado) {
        this.dao = dao;
        this.usuarioCriado = usuarioCriado;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        this.dao.salvar(usuarioCriado);
        return null;
    }
}
