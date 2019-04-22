package empresa.android.principal;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import empresa.android.controlador.EstudianteControlador;
import empresa.android.controlador.PersonalControlador;

public class Index extends AppCompatActivity
{
    ImageButton   btnpersonal,btnestudiante ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        iniComponents();
    }
    public  void  iniComponents()
    {   setContentView(R.layout.activity_index);
        btnpersonal=(ImageButton)findViewById(R.id.btnpersonal);

        btnpersonal.setOnClickListener(new View.OnClickListener()
        {   @Override
            public void onClick(View v)
            {
                IrAlPersonal();
            }
        });
        btnestudiante=(ImageButton)findViewById(R.id.btnestudiante);
        btnestudiante.setOnClickListener(new View.OnClickListener()
        {  @Override
            public void onClick(View v)
            {
               IrAlEstudiante();
            }
        });

    }
    public  void  IrAlPersonal()
    {   Intent   objIntentpersonal=new Intent(Index.this,PersonalControlador.class);
        startService(objIntentpersonal);
        finish();
    }
    public  void IrAlEstudiante()
    {
        Intent   objIntentpersonal=new Intent(Index.this, EstudianteControlador.class);
        startService(objIntentpersonal);
        finish();
    }
}
