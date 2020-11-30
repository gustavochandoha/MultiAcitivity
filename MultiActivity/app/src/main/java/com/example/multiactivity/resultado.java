package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    // Desenvolvido por Gustavo Kepka Chandoha - GRR20176925

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView nome = findViewById(R.id.textViewNome);
        TextView resultado = findViewById(R.id.textViewResultado);

        Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if (params!=null){
                String name = params.getString("nome");
                String resultadofinal = params.getString("situacao");


                nome.setText(name);
                resultado.setText(resultadofinal);



            }

        }



    }
        public void voltar(View view){

            Intent i=new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();


    }





}