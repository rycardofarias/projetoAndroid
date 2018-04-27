package com.projetoengenharia.projetoengenharia.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.projetoengenharia.projetoengenharia.R;

public class ListaOrdemServicoActivity extends AppCompatActivity {

    private Button btnAdicionarOrdemServico;
    private Button btnCancelarOrdemServico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ordem_servico);

        //instanciando os botoes
        btnAdicionarOrdemServico = (Button) findViewById(R.id.btnAdicionarOrdemServicoId);
        btnCancelarOrdemServico = (Button) findViewById(R.id.btnVoltarOrdemServicoId);

        //criando ação de click
        btnAdicionarOrdemServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaOrdemServicoActivity.this, CadastrarOrdemServicoActivity.class));
            }
        });
        btnCancelarOrdemServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaOrdemServicoActivity.this, MainActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ordem_servico, menu);
        return true;
    }
}
