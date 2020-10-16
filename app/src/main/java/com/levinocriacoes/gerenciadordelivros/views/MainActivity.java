package com.levinocriacoes.gerenciadordelivros.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.levinocriacoes.gerenciadordelivros.R;
import com.levinocriacoes.gerenciadordelivros.adapter.LivroAdapter;
import com.levinocriacoes.gerenciadordelivros.dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycleView = findViewById(R.id.recycleview);

        recycleView.setLayoutManager(new LinearLayoutManager(this));

        List<Livro> listaLivros = new ArrayList<>();

        listaLivros.add(new Livro(1L,"Android para Leigos","Michael Burton","Alta books",0));
        listaLivros.add(new Livro(2L,"Android para Programadores","Paul J, Deitel","Bookman",1));
        listaLivros.add(new Livro(3L,"Desenvolvimento para Android","Griffiths, David","Alta books",0));
        listaLivros.add(new Livro(4L,"Android Base de Dados","Queirós, Ricardo","FCA Editora",1));
        listaLivros.add(new Livro(5L,"Android em Ação","King, Chris","Elsevier - Campus",0));
        listaLivros.add(new Livro(6L,"Jogos em Android","Queirós, Ricardo","FCA - Editora",1));
        listaLivros.add(new Livro(7L,"Android Essencial com Kotlin","Ricardo R.","NOVATEC",0));

        LivroAdapter livroAdapter = new LivroAdapter(listaLivros,this);

        recycleView.setAdapter(livroAdapter);
    }
}