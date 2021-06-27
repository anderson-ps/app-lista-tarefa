package br.edu.unis.listadetarefas.asynctask;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import br.edu.unis.listadetarefas.activity.ListaTarefasActivity;
import br.edu.unis.listadetarefas.model.MinhasPreferencias;
import br.edu.unis.listadetarefas.room.dao.RoomUsuarioDAO;
import br.edu.unis.listadetarefas.room.entity.Usuario;

public class AutenticarUsuariotask extends AsyncTask<String,Void,Usuario> {

    private final RoomUsuarioDAO dao;
    private final Context context;
    private boolean found;

    public AutenticarUsuariotask(RoomUsuarioDAO dao, Context context) {
        this.dao = dao;
        this.context = context;
    }


    @Override
    protected Usuario doInBackground(String... strings) {
        String nome = strings[0];
        String senha = strings[1];

        Usuario usuarioRec = dao.autenticarUsuario(nome,senha);

        if(usuarioRec != null){
            this.found = true;
        }
        return usuarioRec;

    }

    @Override
    protected void onPostExecute(Usuario usuario) {

        if(found == false){
            Toast.makeText(this.context,"Usuario ou Senha Incorretos" , Toast.LENGTH_LONG).show();
        }else{
            salvarPreferencias(usuario.getUsuario());
            abreListaDeTarefas();

        }
        super.onPostExecute(usuario);
    }

    public void abreListaDeTarefas() {

        Intent intent = new Intent(this.context, ListaTarefasActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        this.context.startActivity(intent);

    }

    public void salvarPreferencias(String name) {
        SharedPreferences.Editor editor = MinhasPreferencias.getMinhasPreferenciasEditor(this.context);
        editor.putString(MinhasPreferencias.PREFERENCIA_USUARIO, name);
        editor.commit();
    }

}



