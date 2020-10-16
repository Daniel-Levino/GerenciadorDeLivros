package com.levinocriacoes.gerenciadordelivros.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.levinocriacoes.gerenciadordelivros.R;
import com.levinocriacoes.gerenciadordelivros.dominio.Livro;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroHolder>{

    private List<Livro> livros;
    private Context context;

    public LivroAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @NonNull
    @Override
    public LivroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_livro,parent,false);

        LivroHolder livroHolder = new LivroHolder(view);

        return livroHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LivroHolder holder, int position) {
        Livro livro = livros.get(position);

        holder.titulo.setText(livro.getTitulo());
        holder.autor.setText(livro.getAutor());
        holder.editora.setText(livro.getEditora());

        if(livro.getEmprestado() == 1){
            holder.icon_livro.setColorFilter(Color.GRAY);
            holder.titulo.setTextColor(Color.GRAY);
            holder.icon_emprestado.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class LivroHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        public TextView titulo, autor, editora;
        public ImageView icon_livro, icon_emprestado;

        public LivroHolder(View view){
            super(view);

            titulo = view.findViewById(R.id.titulo);
            autor = view.findViewById(R.id.autor);
            editora = view.findViewById(R.id.editora);
            icon_livro = view.findViewById((R.id.icon_livro));
            icon_emprestado = view.findViewById(R.id.icon_emprestimo);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition()+1;
            //pos++;
            Toast.makeText(context,"OnClick pos: 0"+pos, Toast.LENGTH_SHORT).show();

        }

        @Override
        public boolean onLongClick(View view) {
            int pos = getAdapterPosition()+1;
            Toast.makeText(context, "OnLongClick pos: 0"+pos, LENGTH_SHORT).show();
            return true;
        }
    }
}
