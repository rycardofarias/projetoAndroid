package com.projetoengenharia.projetoengenharia.view.onClickListener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projetoengenharia.projetoengenharia.R;
import com.projetoengenharia.projetoengenharia.contoller.ClienteController;
import com.projetoengenharia.projetoengenharia.model.Cliente;
import com.projetoengenharia.projetoengenharia.model.Endereco;
import com.projetoengenharia.projetoengenharia.view.activity.ListaClientesActivity;
import com.projetoengenharia.projetoengenharia.view.activity.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ricardo Farias on 19/04/2018.
 */

public class CreateClienteOnclickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        //pegando o contexto da classe ListaClientes
        final Context context = view.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.cliente_form, null, false);

        final EditText nomeCliente = (EditText) formElementsView.findViewById(R.id.edtNomeClienteId);
        final EditText cpf = (EditText) formElementsView.findViewById(R.id.editTextCpfId);
        final EditText dataNascimento = (EditText) formElementsView.findViewById(R.id.edtDataNascimentoId);
        final EditText telefone = (EditText) formElementsView.findViewById(R.id.edtTelefoneId);
        final EditText email = (EditText) formElementsView.findViewById(R.id.edtEmailId);
        final EditText estado = (EditText) formElementsView.findViewById(R.id.edtEstadoId);
        final EditText cidade = (EditText) formElementsView.findViewById(R.id.edtCidadeId);
        final EditText bairro = (EditText) formElementsView.findViewById(R.id.edtBairroId);
        final EditText rua = (EditText) formElementsView.findViewById(R.id.edtRuaId);
        final EditText numero = (EditText) formElementsView.findViewById(R.id.edtNumeroId);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Cadastra Cliente")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String clienteNome = nomeCliente.getText().toString();
                String clienteCpf = cpf.getText().toString();

                String clienteDataNascimento = dataNascimento.getText().toString();

                String clienteTelefone = telefone.getText().toString();
                String clienteEmail = email.getText().toString();
                String clienteEstado = estado.getText().toString();
                String clienteCidade = cidade.getText().toString();
                String clienteBairro = bairro.getText().toString();
                String clienteRua = rua.getText().toString();
                int clienteNumero = Integer.parseInt(numero.getText().toString());

                Cliente cliente = new Cliente();
                Endereco endereco = new Endereco();

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date data_nascimento = formato.parse(clienteDataNascimento);
                    cliente.setDataNascimento(data_nascimento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                endereco.setEstado(clienteEstado);
                endereco.setCidade(clienteCidade);
                endereco.setBairro(clienteBairro);
                endereco.setLogadouro(clienteRua);
                endereco.setNumero(clienteNumero);

                cliente.setEndereco(endereco);

                cliente.setNome(clienteNome);
                cliente.setCPF(clienteCpf);

                cliente.setTelefone(clienteTelefone);
                cliente.setEmail(clienteEmail);

                boolean criadoComSucesso = new ClienteController(context).create(cliente);

                if(criadoComSucesso){
                    Toast.makeText(context, "Cadastro Realizado com Sucesso",Toast.LENGTH_LONG).show();
                    ((ListaClientesActivity)context).contadorDeRegistro();
                }else
                    Toast.makeText(context, "NÂO FUNCIONOU",Toast.LENGTH_LONG).show();
                dialogInterface.cancel();
            }

        }).show();

    }
}
