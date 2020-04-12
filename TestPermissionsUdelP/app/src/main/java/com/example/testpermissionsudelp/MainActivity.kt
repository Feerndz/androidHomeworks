package com.example.testpermissionsudelp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.testpermissionsudelp.Tools.PermissionsApplications
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1
    val permission = PermissionsApplications(this@MainActivity)
    val listPermissions = arrayOf(android.Manifest.permission.CAMERA,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!permission.hasPermissions(listPermissions)){
            permission.requestPermission(listPermissions,REQUEST_CODE)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when(requestCode){

            REQUEST_CODE -> {

                if(grantResults.size>0){

                    if(grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this@MainActivity,"Es obligatorio aceptar los permisos para utilizar la aplicación.",Toast.LENGTH_LONG).show()
                        finish()
                    }
                }
                else{
                    Toast.makeText(this@MainActivity,"Es obligatorio aceptar los permisos para utilizar la aplicación.",Toast.LENGTH_LONG).show()
                    finish()
                }

            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
