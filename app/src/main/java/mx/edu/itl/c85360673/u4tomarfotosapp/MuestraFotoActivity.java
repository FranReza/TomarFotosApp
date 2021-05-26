/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                  Clase que administra las opciones de telefono
:*
:*  Archivo     : MuestraFotoActivity.java
:*  Autor       : Pedro Francisco Reza Jara     171000063
:*  Fecha       : 26/Marzo/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n: Esta app despliega las diferentes funciones
:*
:*  Ultima modif:
:*  Fecha: 18/Abril/2021      Modificion:cambio de algunos textos    Motivo: Mejorar funcionalidad
:*==========================================================================================
:* Los cambios que sealizaron fueron a los textos, se creo una clase RR que provee los textos
:* de la aplicacion en ingles o en español dependiendo del idioma del dispositivo
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c85360673.u4tomarfotosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MuestraFotoActivity extends AppCompatActivity {

    private  ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_foto);

        imgFoto = findViewById( R.id.imgFoto );

        //ocultar la barra de acciones
        this.getSupportActionBar().hide();

        //obtenemos la ubicacion de la foto desde el parametro que viene desde los extras
        String strUri = getIntent().getStringExtra( "uri" );
        imgFoto.setImageURI( Uri.parse( strUri ) );
    }
}
