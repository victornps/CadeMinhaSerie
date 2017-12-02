package com.victorn.cademinhaserie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {

    TextView txtNome,txtAno,txtCriador,txtElencoPrincipal,txtTemporadas,txtAtividade,txtTrama,txtGeneros,txtPaisOrigem,txtTempoEpisodio;
    String nome,ano,criador,elencoPrincipal,temporadas,atividade,trama,generos,paisOrigem,tempoEpisodio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        Intent i = getIntent();

        nome = i.getStringExtra("nome");
        ano = i.getStringExtra("ano");
        criador = i.getStringExtra("criador");
        elencoPrincipal = i.getStringExtra("elencoPrincipal");
        temporadas = i.getStringExtra("temporadas");
        atividade = i.getStringExtra("atividade");
        trama = i.getStringExtra("trama");
        generos = i.getStringExtra("generos");
        paisOrigem = i.getStringExtra("paisOrigem");
        tempoEpisodio = i.getStringExtra("tempoEpisodio");

        txtNome = (TextView) findViewById(R.id.nome);
        txtAno = (TextView) findViewById(R.id.ano);
        txtCriador = (TextView) findViewById(R.id.criador);
        txtElencoPrincipal = (TextView) findViewById(R.id.elencoPrincipal);
        txtTemporadas = (TextView) findViewById(R.id.temporadas);
        txtAtividade = (TextView) findViewById(R.id.atividade);
        txtTrama = (TextView) findViewById(R.id.trama);
        txtGeneros = (TextView) findViewById(R.id.generos);
        txtPaisOrigem = (TextView) findViewById(R.id.paisOrigem);
        txtTempoEpisodio = (TextView) findViewById(R.id.tempoEpisodio);

        txtNome.setText(nome);
        txtAno.setText(ano);
        txtCriador.setText(criador);
        txtElencoPrincipal.setText(elencoPrincipal);
        txtTemporadas.setText(temporadas);
        txtAtividade.setText(atividade);
        txtTrama.setText(trama);
        txtGeneros.setText(generos);
        txtPaisOrigem.setText(paisOrigem);
        txtTempoEpisodio.setText(tempoEpisodio);

    }
}
