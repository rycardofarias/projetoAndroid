package com.projetoengenharia.projetoengenharia.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.projetoengenharia.projetoengenharia.R;
import com.projetoengenharia.projetoengenharia.adapter.AdapterCliente;
import com.projetoengenharia.projetoengenharia.contoller.ClienteController;
import com.projetoengenharia.projetoengenharia.model.Cliente;
import com.projetoengenharia.projetoengenharia.view.onClickListener.CreateClienteOnclickListener;
import com.projetoengenharia.projetoengenharia.view.onClickListener.RetrieveOnLongClickListener;

import java.util.ArrayList;
import java.util.List;

public class ListaClientesActivity extends AppCompatActivity {

    private Button btnAdicionarcliente;
    private Button btnVoltarCliente;
    ListView lvCliente;
    AdapterCliente adapterCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        //instanciando botões
        btnAdicionarcliente = findViewById(R.id.btnAdicionarClienteId);
         btnVoltarCliente = findViewById(R.id.btnVoltarClienteId);

        //criando ação de click do botão
        btnAdicionarcliente.setOnClickListener(new CreateClienteOnclickListener());
        btnVoltarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaClientesActivity.this, MainActivity.class));
            }
        });
        lvCliente = (ListView) findViewById(R.id.lvClientesId);
        adapterCliente = new AdapterCliente(this, getCliente());
        lvCliente.setAdapter(adapterCliente);
        contadorDeRegistro();

        //atualizarListaDeClientes();
    }

    private ArrayList<Cliente> getCliente() {
        ArrayList <Cliente> clientes2 = (ArrayList<Cliente>) new ClienteController(this).listCliente();

        return clientes2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clientes, menu);
        return true;
    }
    public void contadorDeRegistro() {
        String msg = "";
        int contador = new ClienteController(this).totalclientes();

        TextView txtContadorCliente = findViewById(R.id.contadorClienteId);

        if(contador == 0){
            msg = "Nenhum cliente cadastrado";
        }else if (contador==1){
            msg = contador+" Cliente cadastrado";
        }else{
            msg = contador+" Clientes cadastrados";
        }
        txtContadorCliente.setText(msg);
    }

}
