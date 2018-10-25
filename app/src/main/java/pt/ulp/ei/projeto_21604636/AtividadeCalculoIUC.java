/*
Roberto Ferreira 18/10/2018
 */

package pt.ulp.ei.projeto_21604636;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AtividadeCalculoIUC extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_calculo_iuc);
    }

    // ALINEA a)

    // metodo que calcula o IUC
    public void calcularIUC(View v)
    {

        double local_cilindro =0.0;
        double local_carbono = 0.0;
        double local_resultado;

        //aceder ao radioGroup´s
        RadioGroup CilindradaGroup = findViewById(R.id.cilindrada);
        RadioGroup co2Group = findViewById(R.id.co2);

        //determinar qual raiobutton foi selecionado (ID)
        int op = CilindradaGroup.getCheckedRadioButtonId();
        int op1 = co2Group.getCheckedRadioButtonId();

        //ALINEA b)
        //verifica se os dois grupos de radiobuttons estão selecionados caso contrário mostra um aviso

        if(CilindradaGroup.getCheckedRadioButtonId()== -1 || co2Group.getCheckedRadioButtonId()== -1)
        {

            AlertDialog.Builder alerta = new AlertDialog.Builder(AtividadeCalculoIUC.this);
            alerta.setTitle("Aviso");

            //alertDialog com determinadas caracteristicas
            alerta
                    .setIcon(R.drawable.ic_action_aviso)
                    .setMessage("Um dos Grupos Não Selecionados")
                    //se for usado um botão na caixa de dialogo False caso contrário true
                    .setCancelable(true);
/*
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        // comportamento quando clica em "OK"
                        }

                    });
*/
            //cria um dialog e mostra na tela
            alerta.create();
            alerta.show();
        }else{

              //determina o valor a associar ao id do radiobutton da cilindrada
            switch (op){
                        case R.id.radioButton1: local_cilindro = 33.10;
                            break;

                        case R.id.radioButton2:
                            local_cilindro = 66.50;
                            break;

                        case R.id.radioButton3:
                            local_cilindro = 133.01;
                            break;

                        case R.id.radioButton4:
                            local_cilindro = 455.30;
                            break;
                         }
            //determina o valor a associar ao id do radiobutton do co2
            switch(op1){

                        case R.id.radioButton7:
                            local_carbono = 57;
                            break;

                        case R.id.radioButton8:
                            local_carbono = 86;
                            break;

                        case R.id.radioButton9:
                            local_carbono = 187;
                            break;

                        case R.id.radioButton10:
                            local_carbono = 321;
                            break;
                        }

            //soma dos valores , e apresentá-los na textview da app
            local_resultado = local_cilindro + local_carbono;
            TextView textViewResultado = findViewById(R.id.textViewResultado);
            textViewResultado.setText("IUC: " +local_resultado);

            //ALINEA c)

            Intent intent = new Intent(this,SubAtividadeCalculoIUC.class);
            intent.putExtra("CILINDRADA",local_cilindro);
            intent.putExtra("CARBONO",local_carbono);
            startActivity(intent);






             }
        }


}
