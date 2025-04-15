package com.example.atividade4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.nome);
        EditText matricula = findViewById(R.id.matricula);
        EditText nota1 = findViewById(R.id.nota1);
        EditText nota2 = findViewById(R.id.nota2);
        Button calcular = findViewById(R.id.calcular);


    calcular.setOnClickListener(view ->{

        String nomeAluno = nome.getText().toString();
        String matriculaAluno = matricula.getText().toString();
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());

        double notaFinal = (n1 * 0.4) + (n2 * 0.6);

        Intent intent = new Intent(MainActivity.this, TelaResultado.class);

        intent.putExtra("nome", nomeAluno);
        intent.putExtra("matricula", matriculaAluno);
        intent.putExtra("notaFinal", notaFinal);

        startActivity(intent);

        }


    );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
