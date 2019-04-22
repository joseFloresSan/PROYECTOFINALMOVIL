package empresa.android.controlador;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import empresa.android.principal.FrmLoginPersonal;
import empresa.android.principal.Index;

public class PersonalControlador extends Service
{
    public PersonalControlador()
    {
    }
    @Override
    public void onCreate()
    {   super.onCreate();

        Intent   objIntentpersonal=new Intent(PersonalControlador.this,FrmLoginPersonal.class);
        startActivity(objIntentpersonal);

    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
