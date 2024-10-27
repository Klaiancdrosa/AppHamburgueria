package br.ulbra.menuhamburgueria;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btEntrar, btRegistrar;
    EditText edtUsuario, edtSenha;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telalogin);

        db = new DBHelper(this);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btEntrar = findViewById(R.id.btLogar);
        btRegistrar = findViewById(R.id.btCadastrarL);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsuario.getText().toString().trim();
                String password = edtSenha.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Usuário não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                    return;
                }

                String res = db.validarLogin(username, password);
                if ("OK".equals(res)) {
                    Toast.makeText(MainActivity.this, "Login OK !!", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(MainActivity.this, MenuHActivity.class);
                    startActivity(k);
                } else {
                    Toast.makeText(MainActivity.this, "Login ou Senha errados!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(i);
            }
        });
    }
}
