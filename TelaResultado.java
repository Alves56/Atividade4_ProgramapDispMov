package com.example.atividade4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);

        TextView resultado = findViewById(R.id.resultado);

        String nome = getIntent().getStringExtra("nome");
        String matricula = getIntent().getStringExtra("matricula");
        double notaFinal = getIntent().getDoubleExtra("notaFinal", 0.0);

        String mensagem = "bem vindo " + nome + " - matricula " + matricula +
                "\nSua nota final é: " + String.format("%.2f", notaFinal);

        resultado.setText(mensagem);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
