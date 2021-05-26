/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*       Clase que invoca un metodo que llama a la vista activity_acerca_de.xml
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Pedro Francisco Reza Jara
:*  Fecha       : 26/03/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Esta clase posee una funcion por default, dentro de el
:*                 Cargamos el metodo SetContentView para invocar una vista XML
:*                 en este caso la vista activity_acerca_de.xml
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c85360673.u4tomarfotosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaDeActivity extends AppCompatActivity {

    //-----------------------------------------------------------------------------------
    // Metodo que se define por default, en el cual cargamos la vista activity_acerca_de.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_acerca_de );
    }
}