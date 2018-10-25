package pt.ulp.ei.projeto_21604636;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SubAtividadeCalculoIUC extends AppCompatActivity {

    private Double resultado = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_atividade_calculo_iuc);


        Intent intent = getIntent();
        double valor_cilindrada = intent.getDoubleExtra("CILINDRADA",0);
        double valor_carbono = intent.getDoubleExtra("CARBONO",0);

        resultado = valor_cilindrada + valor_carbono;


        TextView textView = findViewById(R.id.resultado_sub);
        textView.setText("" +resultado);

    }


    public void regressar(View view){

        Intent intent = new Intent(this, AtividadeCalculoIUC.class);
        intent.putExtra("resultado",resultado.toString());
        startActivity(intent);
        Toast.makeText(this, "IUC a pagar "+resultado, Toast.LENGTH_SHORT).show();
    }

    public void terminar(View view){
        this.finish();


    }


}
