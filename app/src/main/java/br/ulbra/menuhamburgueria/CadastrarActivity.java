package br.ulbra.menuhamburgueria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastrarActivity extends AppCompatActivity {
    EditText edtUsuarioC, edtNome, edtSenha, edtEmail, edtTelefone;
    Button btCadastrar;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telacadastro);
        db = new DBHelper(this);

        edtUsuarioC = findViewById(R.id.edtUsuarioC);
        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        btCadastrar = findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeUsuario = edtUsuarioC.getText().toString().trim();
                String password = edtSenha.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String telefone = edtTelefone.getText().toString().trim();

                if (nomeUsuario.isEmpty()) {
                    Toast.makeText(CadastrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(CadastrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (!telefone.matches("[0-9]+") || telefone.length() < 9 || telefone.length() > 15) {
                    Toast.makeText(CadastrarActivity.this, "INSIRA UM TELEFONE VÁLIDO", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(CadastrarActivity.this, "INSIRA UM EMAIL VÁLIDO", Toast.LENGTH_SHORT).show();
            } else {
                    long res = db.criarUtilizador(nomeUsuario, password, email, telefone);
                    if (res != -1) {
                        Toast.makeText(CadastrarActivity.this, "Registro OK", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(CadastrarActivity.this, "Usuário já existe ou erro ao registrar!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

