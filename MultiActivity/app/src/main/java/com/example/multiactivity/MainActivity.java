package com.example.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Desenvolvido por Gustavo Kepka Chandoha - GRR20176925

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcula(View view ){
        EditText nome = findViewById(R.id.editTextTextAluno);
        EditText nota1 = findViewById(R.id.editTextNumberNota1);
        EditText nota2 = findViewById(R.id.editTextNumberNota2);
        EditText frequencia = findViewById(R.id.editTextFrequencia);





        String nomeAluno = nome.getText().toString();



        if(nomeAluno.equals("") || nota1.getText().toString().trim().equals("")  || nota2.getText().toString().trim().equals("") || frequencia.getText().toString().trim().equals("")){
            Toast msg = Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }


        double nota01 = Double.parseDouble(nota1.getText().toString());
        double nota02 = Double.parseDouble(nota2.getText().toString());
        int frequenciaaluno = Integer.parseInt(frequencia.getText().toString());
        Double mediafinal;
        mediafinal = (nota01 + nota02) / 2;
        String mensagem ="";


        if(nota01 <= 0 || nota01>=10 ) {

            Toast msg = Toast.makeText(this, "Nota 1 - deve ser entre 0 a 10", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }
        if(nota02 <= 0 || nota02>=10 ) {

            Toast msg = Toast.makeText(this, "Nota 2 - deve ser entre 0 a 10", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }
        if(frequenciaaluno <= 0 || frequenciaaluno>=100 ) {

            Toast msg = Toast.makeText(this, "Frequencia - deve ser entre 0 a 100", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }




        if(mediafinal >= 7 && frequenciaaluno >= 75){
            mensagem = "Aprovado";
        }
        else if(mediafinal >= 4 && mediafinal <=6.9 && frequenciaaluno >= 75){
            mensagem = "Final";
        }
        else if(frequenciaaluno <75){
            mensagem = "Reprovado por falta";
        }
        else if(mediafinal <4){
            mensagem = "Reprovado por nota";
        }




            Intent it = new Intent(this, resultado.class);
            Bundle params = new Bundle();
            params.putString("nome", nomeAluno);
            params.putString("situacao", mensagem);
            it.putExtras(params);
            startActivity(it);
            finish();




    }


}