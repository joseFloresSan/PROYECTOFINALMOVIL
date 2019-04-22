package empresa.android.controlador;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import empresa.android.bean.UsuarioBean;
import empresa.android.dao.UsuarioDAO;
import empresa.android.principal.FrmLoginEstudiante;
import empresa.android.principal.FrmPrincipalEstudiante;

public class EstudianteControlador extends Service {

    @Override
    public void onStart(Intent intent, int startId) {


        super.onStart(intent, startId);
        String opcad;
        int op;

        Bundle objBundle = intent.getExtras();
        opcad = objBundle.getString("op");

        op = Integer.parseInt(opcad);
        switch (op)
        {
            case 1: {

                Intent objIntentestudiante = new Intent( EstudianteControlador.this,FrmLoginEstudiante.class);
                startActivity(objIntentestudiante);

                break; }

            case 2:
            {
                UsuarioBean objUsuario=(UsuarioBean)objBundle.getSerializable("datos");
                String usuario=objUsuario.getUsuario();
                String clave=objUsuario.getPassword();

                UsuarioBean objUsuBean=new UsuarioBean();
                            objUsuBean.setUsuario(usuario);
                            objUsuBean.setPassword(clave);
                            objUsuBean.setTipousuario("3");

                UsuarioDAO objUsuDAO= new UsuarioDAO();
                boolean estado=objUsuDAO.ValidarUsuario(objUsuBean);

                if(estado)
                {
                    Intent objIntentestudiante= new Intent( EstudianteControlador.this, FrmPrincipalEstudiante.class);
                    startActivity(objIntentestudiante);

                }else
                {
                 Intent objIntentestudiante=new Intent( EstudianteControlador.this,FrmLoginEstudiante.class);
                 Bundle obj=new Bundle();
                 objBundle.putString("msj","Usuario y clave Incorrecto !!!");
                 objIntentestudiante.putExtras(objBundle);
                 startActivity(objIntentestudiante);
                }
                break; }
        }
    }



    @Override
    public IBinder onBind(Intent intent)
    {
      return null;
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
    }
}

