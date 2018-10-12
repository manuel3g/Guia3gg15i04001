package org.dev4u.hv.guia3_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {
    private AdaptadorMensaje adatadorMensaje;
    private ArrayList<Mensaje> mensajesArrayList;
    private EditText txtConteniddo;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        txtConteniddo = (EditText) findViewById(R.id.txtEntrada);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        mensajesArrayList = new ArrayList<>();
        //Inicializando el adaptador
        adatadorMensaje = new AdaptadorMensaje(this,  mensajesArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adatadorMensaje);
    }

    public void onClickEnviar(View view){
        if(txtConteniddo.getText().toString().isEmpty()){
            Toast.makeText(MensajeActivity.this,"Mensaje Vacio",Toast.LENGTH_SHORT).show();
        }else{
            Mensaje mensaje = new Mensaje(
                    txtConteniddo.getText().toString(),
                    new SimpleDateFormat( "E dd MMM yyyy HH:mm").format(Calendar.getInstance().getTime())
            );
            txtConteniddo.setText("");
            mensajesArrayList.add(mensaje);
            adatadorMensaje.notifyDataSetChanged();
        }
    }
}
