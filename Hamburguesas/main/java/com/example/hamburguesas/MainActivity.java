package com.example.hamburguesas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hamburguesas.model.VentaModel;

public class MainActivity extends AppCompatActivity {
    //Paso 1: Declarar los views a manipular
    private Spinner cmbTipoHamburguesa;
    private EditText txtCantidad;
    private Spinner cmbTipoPago;
    private Button btnCalcular;
    private Button btnNuevo;
    //Definir los elementos del ComboBOx(Spinner)
    String[] opcionesTipoHamburguesa={
            "--Seleccione--",
            "Sencilla",
            "Doble",
            "Triple"
    };
    String[] opcionesTipoPago={
            "--Seleccione--",
            "Tarjeta",
            "Efectivo"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paso 2: Referenciar los views con su Id del xml(interfaz)
        cmbTipoHamburguesa=findViewById(R.id.SpTipoHamburguesa);
        txtCantidad=findViewById(R.id.EtCantidad);
        cmbTipoPago=findViewById(R.id.SpTipoPago);
        btnCalcular=findViewById(R.id.btCalcular);
        btnNuevo=findViewById(R.id.btNuevo);

        //Creando el adaptador con el array de opciones
        ArrayAdapter<String> adapTipoHamburguesa= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                opcionesTipoHamburguesa
        );
        cmbTipoHamburguesa.setAdapter(adapTipoHamburguesa);

        ArrayAdapter<String>adapTipoPago= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                opcionesTipoPago
        );
        cmbTipoPago.setAdapter(adapTipoPago);


        //Paso 3: Crear los eventos para los botones
        //forma 2 (Recomendada)
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Extraer Datos de las EditText
                String tipo, tipoPago;
                byte cantidad;

                tipo=cmbTipoHamburguesa.getSelectedItem().toString();
                tipoPago=cmbTipoPago.getSelectedItem().toString();
                cantidad=Byte.parseByte(txtCantidad.getText().toString());

                //Unir con el TDA
                VentaModel venta = new VentaModel();
                venta.setTipoHamburguesa(tipo);
                venta.setCantidad(cantidad);
                venta.setTipoPago(tipoPago);

                Toast.makeText(getApplicationContext(),
                        venta.calcularVentas(),
                        Toast.LENGTH_LONG).show();



            }
        });

    }
    //forma 1 Eventos  (NO Recomendada)
    public void salir(View v){
        finish();
    }
}