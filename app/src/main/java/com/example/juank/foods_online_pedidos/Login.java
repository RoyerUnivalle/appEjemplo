package com.example.juank.foods_online_pedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //INTENCIONES (IR DE UNA ACTIIVDAD A OTRA)
    //BUNDLE (CONTENEDOR DE PARAMETROS QUE PUEDE SER ENVIADO EN UNA INTENCIÒN)
    //CREAMOS UN OBJETO DE LA CLASE Cliente
    //CON LAS FLAG ESTAMOS CONTROLANDO EL TEMA DE BACKONPRESS
    public void irHome(View t){
        Intent intencion = new Intent(Login.this,Home.class);
        EditText nombre = findViewById(R.id.nombre);
        EditText direccion = findViewById(R.id.direccion);

        Cliente cliente = new Cliente(nombre.getText().toString(),direccion.getText().toString());

        Bundle datos = new Bundle();
        datos.putSerializable("cliente", (Serializable) cliente);
        datos.putInt("salario",1254215);
        intencion.putExtras(datos);

        //intencion.putExtra("cliente",(Serializable) cliente);


        intencion.addFlags(intencion.FLAG_ACTIVITY_CLEAR_TOP|intencion.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intencion);
    }
}
