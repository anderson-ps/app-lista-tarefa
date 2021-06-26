package br.edu.unis.listadetarefas.asynctask;

import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.unis.listadetarefas.room.dao.RoomUsuarioDAO;
import br.edu.unis.listadetarefas.room.entity.Usuario;

public class AutenticarUsuariotask extends AsyncTask<Void,Void,Boolean> {

    private final RoomUsuarioDAO dao;
    private final
    String usuario;
    String senha;
    boolean autenticado;

    public AutenticarUsuariotask(RoomUsuarioDAO dao, String usuario,String senha) {
        this.dao = dao;
        this.usuario = usuario;
        this.senha = senha;
    }


    @Override
    protected Boolean doInBackground(Void...Void) {


        Usuario usuarioRecuperado = dao.autenticarUsuario(usuario, senha);

        if (usuarioRecuperado != null && usuario.equals(usuarioRecuperado.getUsuario())) {
            autenticado = true ;
        }else{
            autenticado = false;
        }

        return autenticado;
    }

    @Override
    protected void onPostExecute(Boolean autenticado) {

        super.onPostExecute(autenticado);

    }

}



