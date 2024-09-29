package br.com.aula.text;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resultado extends AppCompatActivity {
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        double valorIMC = getIntent().getDoubleExtra("ValorIMC", 0.0);
        String resultadoIMC = getIntent().getStringExtra("resultadoIMC");

        TextView textoNumero = findViewById(R.id.textoNumero); // TextView para o valor numérico do IMC
        TextView textoTipo = findViewById(R.id.textoTipo); // TextView para o resultado string

        textoNumero.setText(String.format("%.2f", valorIMC));
        textoTipo.setText(resultadoIMC);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}