package com.example.agendabd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendabd.db.DbContactos;

public class nuevo extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuarda;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

            txtNombre = findViewById(R.id.txtNombre);
            txtTelefono = findViewById(R.id.txtTelefono);
            txtCorreoElectronico = findViewById(R.id.txtCorreo);

            btnGuarda= findViewById(R.id.btnGuarda);
            btnGuarda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DbContactos dbContactos = new DbContactos(nuevo.this);
                    long id = dbContactos.insertaContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString());
                    if(id > 0){
                        Toast.makeText(nuevo.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpia();
                    } else{
                        Toast.makeText(nuevo.this, "ERROS AL GUARDAR", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

        private void limpia(){
            txtNombre.setText("");
            txtTelefono.setText("");
            txtCorreoElectronico.setText("");
        }
    }
}