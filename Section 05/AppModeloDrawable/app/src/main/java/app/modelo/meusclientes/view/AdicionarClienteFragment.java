package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    TextView txtTitulo;
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtCep;
    EditText edtLogradouro;
    EditText edtNumero, edtBairro, edtCidade, edtEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }

    private void iniciarComponentesDeLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.adicionar_novo_cliente);

        edtNome = view.findViewById(R.id.edtNomeCompleto);
        edtTelefone = view.findViewById(R.id.edtTelefone);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtCep = view.findViewById(R.id.edtCep);
        edtLogradouro = view.findViewById(R.id.edtLogradouro);
        edtNumero = view.findViewById(R.id.edtNumero);
        edtBairro = view.findViewById(R.id.edtBairro);
        edtCidade = view.findViewById(R.id.edtCidade);
        edtEstado = view.findViewById(R.id.edtEstado);
        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();

        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if (TextUtils.isEmpty(edtNome.getText())) {
                    isDadosOK = false;
                    edtNome.setError("Digite o nome completo...");
                    edtNome.requestFocus();
                }

                if (TextUtils.isEmpty(edtTelefone.getText())) {
                    isDadosOK = false;
                    edtTelefone.setError("Informe um número de telefone válido");
                    edtTelefone.requestFocus();
                }

                if (TextUtils.isEmpty(edtEmail.getText())) {
                    isDadosOK = false;
                    edtEmail.setError("Informe um e-mail válido");
                    edtEmail.requestFocus();
                }

                if (TextUtils.isEmpty(edtCep.getText())) {
                    isDadosOK = false;
                    edtCep.setError("Informe um CEP válido");
                    edtCep.requestFocus();
                }

                if (TextUtils.isEmpty(edtLogradouro.getText())) {
                    isDadosOK = false;
                    edtLogradouro.setError("Informe um logradouro válido");
                    edtLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(edtNumero.getText())) {
                    isDadosOK = false;
                    edtNumero.setError("Informe um número válido");
                    edtNumero.requestFocus();
                }

                if (TextUtils.isEmpty(edtBairro.getText())) {
                    isDadosOK = false;
                    edtBairro.setError("Informe um bairro válido");
                    edtBairro.requestFocus();
                }

                if (TextUtils.isEmpty(edtCidade.getText())) {
                    isDadosOK = false;
                    edtCidade.setError("Informe um bairro válido");
                    edtCidade.requestFocus();
                }

                if (TextUtils.isEmpty(edtEstado.getText())) {
                    isDadosOK = false;
                    edtEstado.setError("Informe um bairro válido");
                    edtEstado.requestFocus();
                }

                if (isDadosOK) {

                    novoCliente.setNome(edtNome.getText().toString());
                    novoCliente.setTelefone(edtTelefone.getText().toString());
                    novoCliente.setEmail(edtEmail.getText().toString());

                    // CAST
                    novoCliente.setCep(Integer.parseInt(edtCep.getText().toString()));

                    novoCliente.setLogradouro(edtLogradouro.getText().toString());
                    novoCliente.setNumero(edtNumero.getText().toString());
                    novoCliente.setBairro(edtBairro.getText().toString());
                    novoCliente.setCidade(edtCidade.getText().toString());
                    novoCliente.setEstado(edtEstado.getText().toString());

                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());


                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "onClick: Dados correto...");
                } else {
                    Log.i("log_add_cliente", "onClick: Dados incorreto...");
                }

            }
        });
    }

}
