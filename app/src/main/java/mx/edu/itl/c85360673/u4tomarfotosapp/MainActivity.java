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
:*  Archivo     : MainActivity.java
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import util.permisos.ChecadorDePermisos;
import util.permisos.PermisoApp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.service.autofill.ImageTransformation;
import android.view.View;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final int CODIGO_CAPTURA_FOTO = 123;

    private PermisoApp [] permisosReq = {
            new PermisoApp  ( Manifest.permission.CAMERA, "Camara", true  ),
            new PermisoApp  ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true  ),
            new PermisoApp  ( Manifest.permission.WRITE_EXTERNAL_STORAGE, "Almacenamiento", true )
    };

    private Uri uriFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );


    }

    public void btnCapturaSimpleClick ( View v ) {
        //Formar el nombre del archivo basado en la fecha y hora
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strFechaHora = simpleDateFormat.format( new Date() );
        String archFoto = "foto" + strFechaHora + ".jpg";

        //definir un objeto file
        File fileFoto = new File( Environment.getExternalStorageDirectory () .getAbsolutePath () +
                File.separator +
                "DCIM" +
                File.separator +
                archFoto );
        //creamos el uri correspondiente al archivo del destino de la foto
        uriFoto = FileProvider.getUriForFile( this ,
                  getApplication().getPackageName()+ ".provider",
                fileFoto );

        //cREAMOS EL INTENT QUE LLAMARA A LA APP DE LA CAMARA DE FOTOS Y LE PASAMOS EL URI
        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
        intent.putExtra( MediaStore.EXTRA_OUTPUT, uriFoto );
        startActivityForResult( intent, CODIGO_CAPTURA_FOTO );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == CODIGO_CAPTURA_FOTO ) {
            if ( resultCode == RESULT_OK ) {
                //abrir el activity para mostrar la foto completa
                //se envia como argumento el uri de la foto como un string
                Intent intent = new Intent(this, MuestraFotoActivity.class);
                intent.putExtra("uri", uriFoto.toString() );
                startActivity( intent );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );

        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
        }
    }

    public void btnCapturaOpcionesClick (View v ) {
        Intent intent = new Intent ( this, CamaraActivity.class ) ;
        startActivity ( intent );
    }
    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class);
        startActivity ( intent );
    }
}
