package cl.riemsianne.pruebadlatam2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class DetailsActivity extends AppCompatActivity {

    EditText txtText;
    Button btnGuardar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final Context context = this;
        SharedPreferences sharprefs = getSharedPreferences("ArchivoShared", context.MODE_PRIVATE);



        String prefer = getIntent().getStringExtra("prefer");
        txtText =(EditText)findViewById(R.id.txtText);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                String valor = sharpref.getString("MiPref","Sin Recordatorios");
                Toast.makeText(getApplicationContext(),"Recordatorio Guardado :" +valor,Toast.LENGTH_LONG).show();

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("MiPref", txtText.getText().toString());
                editor.commit();


            }
        });



    }


        }




