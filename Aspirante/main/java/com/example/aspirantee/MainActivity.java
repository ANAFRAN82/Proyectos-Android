package com.example.aspirantee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aspirantee.modelo.DatosModelo;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //Views a manipular(3 botones,4 cajas de texto)
    private Spinner cmbCarrera;
    private TextInputEditText txtNombre;
    private TextInputEditText txtPromedio;
    private Spinner cmbTipoBachillerato;
    private ImageButton btnBoton1;
    private ImageButton btnBoton2;

    //Definir elementos del ComboBox(Spinner)
    String[] OpcionesCarrera = {
            "--Seleccione--",
            "Ing Industrial",
            "Ing Sistemas Computacionales"
    };
    String[] TipoBachillerato = {
            "--Seleccione--",
            "Fisico-Matematico",
            "Quimico-Biologicas",
            "Humanidaddes y Artes",
            "Economico-Administrativo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar views
        cmbCarrera = findViewById(R.id.SpCarrera);
        txtNombre = findViewById(R.id.txtNombre);
        txtPromedio = findViewById(R.id.txtPromedio);
        cmbTipoBachillerato = findViewById(R.id.SpBachillerato);
        btnBoton1 = findViewById(R.id.button1);
        btnBoton2 = findViewById(R.id.button2);

        //Creando adaptador con el array de opciones
        ArrayAdapter<String> adapOpcionesCarrera = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                OpcionesCarrera
        );
        cmbCarrera.setAdapter(adapOpcionesCarrera);
        ArrayAdapter<String> adapTipoBachillerato = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                TipoBachillerato
        );
        cmbTipoBachillerato.setAdapter(adapTipoBachillerato);

        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Extraer los datos de las cajas
                String tipoBachillerato;
                int promedio;
                tipoBachillerato = cmbTipoBachillerato.getSelectedItem().toString();
                promedio = Integer.parseInt(txtPromedio.getText().toString());

                //Unir con el TDA
                DatosModelo datos = new DatosModelo();
                datos.setTipoBachillerato(tipoBachillerato);
                datos.setPromedio(promedio);

                Toast.makeText(getApplicationContext(),
                        datos.Registro(),
                        Toast.LENGTH_LONG).show();
            }
        });

        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
