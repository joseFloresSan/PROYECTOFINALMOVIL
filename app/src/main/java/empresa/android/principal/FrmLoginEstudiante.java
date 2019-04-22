package empresa.android.principal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import empresa.android.bean.UsuarioBean;
import empresa.android.controlador.EstudianteControlador;
import empresa.android.dao.UsuarioDAO;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class FrmLoginEstudiante extends AppCompatActivity implements View.OnClickListener {
    EditText txtusuarioestudiante, txtpasswordestudiante;
    Button btnentrarestudiante;
    TextView lblmensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_login_estudiante);
        txtusuarioestudiante = (EditText) findViewById(R.id.txtusuarioestudiante);
        txtpasswordestudiante = (EditText) findViewById(R.id.txtpasswordestudiante);
        btnentrarestudiante = (Button) findViewById(R.id.btnentrarestudiante);
        btnentrarestudiante.setOnClickListener(this);
        lblmensaje =(TextView)findViewById(R.id.lblmensaje);

        if (getIntent().getExtras() != null) {
            lblmensaje.setText("Usuario y clave incorrecto");
        }

    }

    public void entrar() {
        String usuario, clave;
        usuario = txtusuarioestudiante.getText().toString();
        clave = txtpasswordestudiante.getText().toString();

        UsuarioBean objUsuario = new UsuarioBean();
        objUsuario.setUsuario(usuario);
        objUsuario.setPassword(clave);
        //objUsuario.setTipousuario("3");



        Intent objIntentestudiante = new Intent(FrmLoginEstudiante.this, EstudianteControlador.class);
        Bundle objBundle = new Bundle();
            objBundle.putSerializable("datos", objUsuario);
            objBundle.putString("op","2");
            objIntentestudiante.putExtras(objBundle);
        startService(objIntentestudiante);
        finish();

    }

    @Override
    public void onClick(View v) {
        if (v == btnentrarestudiante) {
            entrar();
        }
    }
}