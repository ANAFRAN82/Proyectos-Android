package com.tesjihellowkotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        println("Hola Mundo desde Kotlin")
        println("Cada dia mas ingeniero;)")
        //declarar PI
        val PI= 3.1416
        println("Valor de PI " + PI)
        //var
        var edad:Int = 21

        if(true){
            var edad = 17
            println("Edad =" + edad)
        }

        edad =edad + 1
        println("Edad =" + edad)
        if(edad<=18){
            println("Eres menor de edad")
        }else if(edad>18 && edad <=40){
            println("Eres joven")
        }else if (edad >40 && edad <=60){
            println("Ya eres adulto")
        }else{
            println("Eres adulto mayor")
        }
        var numMes:Int = 5
        var resultado:String = when(numMes){
            1->"Enero"
            2->"Febrero"
            3->"Marzo"
            4->"Abril"
            5->"Mayo"
            6->"Junio"
            7->"Julio"
            8->"Agosto"
            9->"Septiembre"
            10->"Octubre"
            11->"Noviembre"
            12->"Diciembre"
            else->"Mes no valido"
        }
        println(resultado)
        }
        }



