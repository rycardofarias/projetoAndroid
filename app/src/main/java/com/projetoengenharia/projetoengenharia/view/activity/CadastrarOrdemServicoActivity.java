package com.projetoengenharia.projetoengenharia.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projetoengenharia.projetoengenharia.R;

public class CadastrarOrdemServicoActivity extends AppCompatActivity {

    private Button btnConfirmarCadastroOrdemServico;
    private Button btnCancelarCadastroOrdemServico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ordem_servico);

        // instanciando
        btnConfirmarCadastroOrdemServico = (Button) findViewById(R.id.btnConfirmarCadastroOrdemServicoId);
        btnCancelarCadastroOrdemServico = (Button)findViewById(R.id.btnVoltarCadastroOrdemServicoId);

        // criar ação de click
        btnConfirmarCadastroOrdemServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastrarOrdemServicoActivity.this, ListaOrdemServicoActivity.class));
                finish();
            }
        });
        btnCancelarCadastroOrdemServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastrarOrdemServicoActivity.this, ListaOrdemServicoActivity.class));
                finish();
            }
        });
    }
}
