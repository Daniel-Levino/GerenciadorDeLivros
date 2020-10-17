package com.levinocriacoes.gerenciadordelivros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.levinocriacoes.gerenciadordelivros.data.LivroDAO;
import com.levinocriacoes.gerenciadordelivros.dominio.Livro;

public class EditarLivroActivity extends AppCompatActivity {

    private EditText edt_titulo, edt_autor, edt_editora;
    private CheckBox chk_emprestado;

    private LivroDAO livroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_livro);

        edt_titulo = findViewById(R.id.edit_titulo);
        edt_autor = findViewById(R.id.edit_autor);
        edt_editora = findViewById(R.id.edit_editora);
        chk_emprestado = findViewById(R.id.check_emprestado);

        livroDAO = LivroDAO.getInstance(this);

    }


    public void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void processar(View view) {
        String titulo = edt_titulo.getText().toString();
        String autor = edt_autor.getText().toString();
        String editora = edt_editora.getText().toString();
        int emprestado = (chk_emprestado.isChecked()) ? 1 : 0;

        Livro livro = new Livro(titulo, autor, editora, emprestado);

        livroDAO.save(livro);

        String mensagem = "Livro Cadastrado Com Sucesso! ID: "+livro.getId();

        setResult(RESULT_OK);
        finish();
    }
}