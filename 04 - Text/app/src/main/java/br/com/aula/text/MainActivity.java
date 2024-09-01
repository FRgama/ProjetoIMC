package br.com.aula.text;

import android.os.Bundle;
import android.view.View;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private Double imc; //Criada variavel imc para ser chamada tanto na função calcular quanto na resultadoo

    public void calcular(View view){
        // intencionamento dos elementos view
        TextInputEditText campoNome = findViewById(R.id.textInputEditNome);
        TextInputEditText campoPeso = findViewById(R.id.textInputEditPeso);
        TextInputEditText campoAltura = findViewById(R.id.textInputEditAltura);

        TextView resultado1 = findViewById(R.id.textoResultado1);
        TextView resultado2 = findViewById(R.id.textoResultado2);
        TextView resultadoNome = findViewById(R.id.textoResultadoNome); //Novo textview que mostra o nome inserido

        // extrai dos objetos, recuperando a string que compoem

        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();


        // Apresentação do nome do Usuário
        resultadoNome.setText(nome + ", Seu IMC é:");

        // converter String para Numerico

        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        imc = numPeso/(numAltura*numAltura); //utilização da variavel imc no calculo

        //Converter o resultado para string

        String stringImc = String.valueOf(imc);

        //Formatação para apresentação do resultado

        DecimalFormat df = new DecimalFormat("#.##");
        stringImc = df.format(imc);

        //apresentando
        resultado1.setText(stringImc);
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

    public void resultado (View view){ //Sequencia de "ifs" para informar o resultado do teste de IMC
        TextView resultado2 = findViewById(R.id.textoResultado2);

        if (imc < 16.9){
            resultado2.setText("Seu IMC é considerado como Muito Baixo do Peso");
        }
        else if(imc < 18.4){
            resultado2.setText("Seu IMC é considerado como Abaixo do Peso");
        }
        else if(imc < 24.9){
            resultado2.setText("Seu IMC é considerado como Peso Normal");
        }
        else if(imc < 29.9){
            resultado2.setText("Seu IMC é considerado como Acima do Peso");
        }
        else if(imc < 34.9){
            resultado2.setText("Seu IMC é considerado como Obesidade Grau 1");
        }
        else if(imc < 40){
            resultado2.setText("Seu IMC é considerado como Obesidade Grau 2");
        }
        else if(imc >= 40){
            resultado2.setText("Seu IMC é considerado como Obesidade Grau 3");
        }
    }

    public void botao(View view){ //função criada para chamar tanto a função calcular quanto a resultado no OnClick
        calcular(view);
        resultado(view);
    }

}