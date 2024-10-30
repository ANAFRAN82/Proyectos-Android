package com.example.aspirantecarrera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aspirantecarrera.model.VentaModel;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtPromedio;
    private Spinner cmbTipoBachiller;
    private Button btnImprimir;
    private Button btnSalir;

    String[] opcionesTipoBachiller={
            "--Seleccione Tipo de Bachiller--",
            "Fisico-Matematico",
            "Matematico",
            "Fisico"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre=findViewById(R.id.EtNombre);
        txtPromedio=findViewById(R.id.EtPromedio);
        cmbTipoBachiller=findViewById(R.id.SpTipoBachiller);
        btnImprimir=findViewById(R.id.btImprimir);

        ArrayAdapter<String> adapTipoBachiller = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                opcionesTipoBachiller);
        cmbTipoBachiller.setAdapter(adapTipoBachiller);

        btnImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte Promedio;

                VentaModel venta = new VentaModel();
                String tipo= cmbTipoBachiller.getSelectedItem().toString();
                Promedio= Byte.parseByte(txtPromedio.getText().toString());
                String nombre= txtNombre.getText().toString();

                venta.setTipoBachiller(tipo);
                venta.setPromedio(Promedio);
                venta.setNombre(nombre);

                Toast.makeText(getApplicationContext(),
                        venta.aspiranteInge(),
                        Toast.LENGTH_LONG).show();;
            }
        });
        }

    public void Salir (View v){finish();}
}