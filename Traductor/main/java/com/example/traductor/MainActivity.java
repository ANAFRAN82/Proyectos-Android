package com.example.traductor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traductor.javaModelo.Idioma;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText Et_Idioma_Origen;
    TextView Tv_Idioma_Destino;
    MaterialButton Btn_Elegir_Idioma;
    MaterialButton Btn_Idioma_Elegido;
    MaterialButton Btn_Traducir;
    private ProgressDialog progressDialog;

    private ArrayList<Idioma> IdiomasArrayList;
    private static final String REGISTRO = "MisRegistros";

    private String codigoIdiomaOrigen = "es";
    private String tituloIdiomaOrigen = "Español";

    private String codigoIdiomaDestino = "en";
    private String tituloIdiomaDestino = "Ingles";

    private TranslatorOptions translatorOptions;
    private Translator translator;
    private String textoIdiomaOrigen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarVistas();
        IdiomasDisponibles();

        Btn_Elegir_Idioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Elegir idioma", Toast.LENGTH_SHORT).show();
                ElegirIdiomaOrigen();
            }
        });

        Btn_Idioma_Elegido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Idioma Elegido", Toast.LENGTH_SHORT).show();
                ElegirIdiomaDestino();
            }
        });

        Btn_Traducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Traducir", Toast.LENGTH_SHORT).show();
                ValidarDatos();
            }
        });
    }

    private void InicializarVistas(){
        Et_Idioma_Origen = findViewById(R.id.Et_Idioma_Origen);
        Tv_Idioma_Destino = findViewById(R.id.Tv_Idioma_Destino);
        Btn_Elegir_Idioma = findViewById(R.id.Btn_Elegir_Idioma);
        Btn_Idioma_Elegido = findViewById(R.id.Btn_Idioma_Elegido);
        Btn_Traducir = findViewById(R.id.Btn_Traducir);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Espere por favor");
        progressDialog.setCanceledOnTouchOutside(false);
    }

    private void IdiomasDisponibles(){
        IdiomasArrayList = new ArrayList<>();
        List<String> ListasCodigoIdioma = TranslateLanguage.getAllLanguages();

        for(String codigoLenguaje : ListasCodigoIdioma){
            String tituloLenguaje = new Locale(codigoLenguaje).getDisplayLanguage();


            //Log.d(REGISTRO, "IdiomasDisponibles: codigoLenguaje: " + codigoLenguaje);
            //Log.d(REGISTRO, "IdiomasDisponibles : tituloLenguaje: " + tituloLenguaje);

            Idioma modeloIdioma = new Idioma(codigoLenguaje, tituloLenguaje);
            IdiomasArrayList.add(modeloIdioma);
        }
    }

    private void ElegirIdiomaOrigen(){
        PopupMenu popupMenu = new PopupMenu(this, Btn_Elegir_Idioma);
        for(int i=0;i<IdiomasArrayList.size(); i++){
            popupMenu.getMenu().add(Menu.NONE, i, i, IdiomasArrayList.get(i).getTituloIdioma());
        }
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int posicion = item.getItemId();
                codigoIdiomaOrigen = IdiomasArrayList.get(posicion).getCodigoIdioma();
                tituloIdiomaOrigen = IdiomasArrayList.get(posicion).getTituloIdioma();
                Btn_Elegir_Idioma.setText(tituloIdiomaOrigen);
                Et_Idioma_Origen.setHint("Ingrese texto en: " + tituloIdiomaOrigen);

                Log.d(REGISTRO, "OnMenuItemClick: codigoIdiomaOrigen: " + codigoIdiomaOrigen);
                Log.d(REGISTRO, "OnMenuItemClick: tituloIdiomaOrigen: " + tituloIdiomaOrigen);
                return false;
            }
        });
    }

    private void ElegirIdiomaDestino(){
        PopupMenu popupMenu = new PopupMenu(this, Btn_Idioma_Elegido);
        for(int i=0;i<IdiomasArrayList.size(); i++){
            popupMenu.getMenu().add(Menu.NONE, i, i, IdiomasArrayList.get(i).getTituloIdioma());
        }
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int posicion = item.getItemId();
                codigoIdiomaDestino = IdiomasArrayList.get(posicion).getCodigoIdioma();
                tituloIdiomaDestino = IdiomasArrayList.get(posicion).getTituloIdioma();
                Btn_Idioma_Elegido.setText(tituloIdiomaDestino);

                Log.d(REGISTRO, "OnMenuItemClick: codigoIdiomaDestino: " + codigoIdiomaDestino);
                Log.d(REGISTRO, "OnMenuItemClick: tituloIdiomaDestino: " + tituloIdiomaDestino);
                return false;
            }

    });
}

    private void ValidarDatos() {
        textoIdiomaOrigen = Et_Idioma_Origen.getText().toString().trim();
        Log.d(REGISTRO, "ValidarDatos: textoIdiomaOrigen" + textoIdiomaOrigen);

        if(textoIdiomaOrigen.isEmpty()){
            Toast.makeText(this, "Ingrese texto", Toast.LENGTH_SHORT).show();
        }else{
            traducirTexto();
        }
    }

    private void traducirTexto() {
        progressDialog.setMessage("Procesando");
        progressDialog.show();

        translatorOptions = new TranslatorOptions.Builder()
                .setSourceLanguage(codigoIdiomaOrigen)
                .setTargetLanguage(codigoIdiomaDestino)
                .build();

        translator = Translation.getClient(translatorOptions);
        DownloadConditions downloadConditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        translator.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //Los paquetes de traduccion se descargaron con exito
                        Log.d(REGISTRO, "onSuccess: El paquete se ha descargado con exitp");
                        progressDialog.setMessage("Traduciendo Texto");
                        translator.translate(textoIdiomaOrigen)
                                .addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String textoTraducido) {
                                        progressDialog.dismiss();
                                        Log.d(REGISTRO, "onSuccess : textoTrducido"+ textoTraducido) ;
                                        Tv_Idioma_Destino.setText(textoTraducido);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Log.d(REGISTRO, "onFailure" + e);
                                        Toast.makeText(MainActivity.this, "" +e, Toast.LENGTH_SHORT).show();

                                    }
                                });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //LOs paquetes no se descargaron
                        progressDialog.dismiss();
                        Log.d(REGISTRO, "onFailure" + e);
                        Toast.makeText(MainActivity.this, "" +e, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Menu_Limpiar_Texto){
            String StringTexto = "Traduccion";
            Et_Idioma_Origen.setText("");
            Et_Idioma_Origen.setHint("Ingrese texto");
            Tv_Idioma_Destino.setText(StringTexto);
        }
        return super.onOptionsItemSelected(item);
    }
}