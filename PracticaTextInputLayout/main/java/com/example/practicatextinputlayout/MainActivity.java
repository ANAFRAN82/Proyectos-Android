package com.example.practicatextinputlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private ImageButton boton1;
    private ImageView boton2;
    private TextInputEditText txtNombre;
    private TextInputEditText txtPromedio;
    private TextInputEditText txtContrasenia;
    private AppCompatButton btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1=findViewById(R.id.button1);
        boton2=findViewById(R.id.button2);
        txtNombre=findViewById(R.id.textNombre);
        txtPromedio=findViewById(R.id.textPromedio);
        txtContrasenia=findViewById(R.id.textContrasenia);
        btnCalcular=findViewById(R.id.buttonCalcular);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Hola",Toast.LENGTH_SHORT).show();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double promedio=0.0;
                if(txtNombre.getText().toString().trim().length()==0){
                    txtNombre.setError("Debe ingresar Nombre");
                }else if(txtContrasenia.getText().toString().trim().length()==0){
                    txtContrasenia.setError("Debe Ingresar Contraseña");
                }else if(txtPromedio.getText().toString().length()==0){
                    try{
                        promedio=Double.parseDouble(txtPromedio.getText().toString());
                    }catch (NumberFormatException err){
                        txtPromedio.setError("Debe Ingresar Promedio");
                    }
                }else{
                    //Todo el codigo va a aqui(Enlazar TDA
                    Toast.makeText(MainActivity.this,
                            "NO HAY CAMPOS VACIOS",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
