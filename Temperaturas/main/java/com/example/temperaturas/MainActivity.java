package com.example.temperaturas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.temperaturas.model.VentaModel;
import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbTipoConversion;
    private TextInputEditText txtTemperatura;
    private ImageButton botonC;
    private ImageButton botonS;
    private ImageButton botonN;

    String[] opcionesTipoConversion={
            "--Seleccione Temperatura--",
            "Celsius",
            "Fahrenheit",
            "Kelvin",
            "Rankine",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmbTipoConversion=findViewById(R.id.SpTipoConversion);
        txtTemperatura=findViewById(R.id.textTemperatura);
        botonC=findViewById(R.id.button1);
        botonN=findViewById(R.id.button2);
        botonS=findViewById(R.id.button3);


        ArrayAdapter<String> adpTipoConversion= new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                opcionesTipoConversion
        );
        cmbTipoConversion.setAdapter(adpTipoConversion);


        botonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo;
                byte temperatura;

                tipo=cmbTipoConversion.getSelectedItem().toString();
                temperatura=Byte.parseByte(txtTemperatura.getText().toString());

                VentaModel venta = new VentaModel();
                venta.setTipoTemperatura(tipo);
                venta.setTemperatura(temperatura);

                Toast.makeText(getApplicationContext(),
                        venta.calcularVenta(),
                        Toast.LENGTH_LONG).show();

            }
        });
        botonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTemperatura.setText(null);
                cmbTipoConversion.setSelection(0);
                Toast.makeText(getApplicationContext(),
                        "Limpio",Toast.LENGTH_SHORT).show();

            }
        });
        botonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

}