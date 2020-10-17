package com.levinocriacoes.gerenciadordelivros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.levinocriacoes.gerenciadordelivros.data.LivroDAO;
import com.levinocriacoes.gerenciadordelivros.dominio.Livro;

public class EditarLivroActivity extends AppCompatActivity {

    private EditText edt_titulo, edt_autor, edt_editora;
    private CheckBox chk_emprestado;

    private LivroDAO livroDAO;

    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_livro);

        edt_titulo = findViewById(R.id.edit_titulo);
        edt_autor = findViewById(R.id.edit_autor);
        edt_editora = findViewById(R.id.edit_editora);
        chk_emprestado = findViewById(R.id.check_emprestado);

        livroDAO = LivroDAO.getInstance(this);

        livro = (Livro) getIntent().getSerializableExtra("livro");

        if (livro != null){
            edt_titulo.setText(livro.getTitulo());
            edt_autor.setText(livro.getAutor());
            edt_editora.setText(livro.getEditora());
            chk_emprestado.setChecked((livro.getEmprestado()==1) ? true : false);

        }

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

        String mensagem;

        if(livro == null) {
            livro = new Livro(titulo, autor, editora, emprestado);
            livroDAO.save(livro);
            mensagem = "Livro Cadastrado Com Sucesso! ID: "+livro.getId();

        }else {
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setEditora(editora);
            livro.setEmprestado(emprestado);

            livroDAO.update(livro);

            mensagem = "Livro Atualizado Com Sucesso! ID: "+livro.getId();
        }

        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT);

        setResult(RESULT_OK);
        finish();
    }

}