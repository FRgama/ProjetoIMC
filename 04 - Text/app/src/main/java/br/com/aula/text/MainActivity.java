package br.com.aula.text;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(view -> {
            calcular(view);
            resultado(view);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private Double imc; //Criada variavel imc para ser chamada tanto na função calcular quanto na resultado
    private Double peso;
    private Double altura;
    private Button btnCalcular;

    public void calcular(View view) {
        // intencionamento dos elementos view
        TextInputEditText campoNome = findViewById(R.id.textInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.textInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.textInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);
        TextView resultadoNome = findViewById(R.id.textoResultadoNome); //Novo textview que mostra o nome inserido


        // extrai dos objetos, recuperando a string que compoem

        String nome = campoNome.getText().toString();
        String strPeso = campoPeso.getText().toString();
        String strAltura = campoAltura.getText().toString();

        try {
            // Converter String para Numérico
            Double peso = Double.parseDouble(strPeso);
            Double altura = Double.parseDouble(strAltura);

            imc = peso / (altura * altura); // Utilização da variável imc no cálculo

            // Formatação para apresentação do resultado
            DecimalFormat df = new DecimalFormat("#.##");
            String stringImc = df.format(imc);

            // Apresentando os resultados
            resultadoNome.setText(nome + ", Seu IMC é:");
            resultado1.setText(stringImc);

        } catch (NumberFormatException e) {
            // Em caso de erro de formatação, chama a função de erro
            erro(view);
        }
    }

    public void limpar (View view){

        TextInputEditText campoNome = findViewById(R.id.textInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.textInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.textInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);

        // Limpando as informações:
        resultado1.setText("");
        resultado2.setText("");
        campoNome.setText("");
        campoAltura.setText("");
        campoPeso.setText("");
    }

    public void resultado (View view) { //Sequencia de "ifs" para informar o resultado do teste de IMC
        TextView resultado2 = findViewById(R.id.textoResultado2);

        Intent intent = null;
        if (imc != null) { // caso seja nulo, chama a função erro
            intent = new Intent(this, resultado.class);

            intent.putExtra("ValorIMC", imc);
            if (imc <= 10.0) {
                erro(view);
            } else if (imc < 16.9) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Muito Baixo do Peso");
            } else if (imc < 18.4) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Abaixo do Peso");
            } else if (imc < 24.9) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Peso Normal");
            } else if (imc < 29.9) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Acima do Peso");
            } else if (imc < 34.9) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Obesidade Grau 1");
            } else if (imc < 40) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Obesidade Grau 2");
            } else if (imc <= 80) {
                intent.putExtra("resultadoIMC", "Seu IMC é considerado como Obesidade Grau 3");
            } else if (imc >= 80) {
                erro(view);
            }
        } else {
            erro(view);
        }

        startActivity(intent);
    }

    public void botao(View view){ //função criada para chamar tanto a função calcular quanto a resultado no OnClick
        calcular(view);
        resultado(view);
    }
    public void erro(View view){ // função será ativada quando a entrada estiver com algum problema
        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);
        resultado1.setText("Erro");
        resultado2.setText("Entrada inválida");
    }


}