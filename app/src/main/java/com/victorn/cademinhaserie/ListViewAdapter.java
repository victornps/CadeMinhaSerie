package com.victorn.cademinhaserie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<Seriado> seriadolist = null;
    private ArrayList<Seriado> arraylist;

    public ListViewAdapter(Context context,
                           List<Seriado> seriadolist) {
        mContext = context;
        this.seriadolist = seriadolist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Seriado>();
        this.arraylist.addAll(seriadolist);
    }

    public class ViewHolder {
        TextView nome;
        TextView ano;
        TextView elencoPrincipal;
    }

    @Override
    public int getCount() {
        return seriadolist.size();
    }

    @Override
    public Seriado getItem(int position) {
        return seriadolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);

            holder.nome = (TextView) view.findViewById(R.id.nome);
            holder.ano = (TextView) view.findViewById(R.id.ano);
            holder.elencoPrincipal = (TextView) view.findViewById(R.id.elencoPrincipal);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.nome.setText(seriadolist.get(position).getNome());
        holder.ano.setText(seriadolist.get(position).getAno());
        holder.elencoPrincipal.setText(seriadolist.get(position).getElencoPrincipal());

        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, SingleItemView.class);

                intent.putExtra("nome",
                        (seriadolist.get(position).getNome()));
                intent.putExtra("ano",
                        (seriadolist.get(position).getAno()));
                intent.putExtra("criador",
                        (seriadolist.get(position).getCriador()));
                intent.putExtra("elencoPrincipal",
                        (seriadolist.get(position).getElencoPrincipal()));
                intent.putExtra("temporadas",
                        (seriadolist.get(position).getTemporadas()));
                intent.putExtra("atividade",
                        (seriadolist.get(position).getAtividade()));
                intent.putExtra("trama",
                        (seriadolist.get(position).getTrama()));
                intent.putExtra("generos",
                        (seriadolist.get(position).getGeneros()));
                intent.putExtra("paisOrigem",
                        (seriadolist.get(position).getPaisOrigem()));
                intent.putExtra("tempoEpisodio",
                        (seriadolist.get(position).getTempoEpisodio()));

                mContext.startActivity(intent);
            }
        });

        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        seriadolist.clear();
        if (charText.length() == 0) {
            seriadolist.addAll(arraylist);
        } else {
            for (Seriado cms : arraylist) {
                if (cms.getNome().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    seriadolist.add(cms);
                }
            }
        }
        notifyDataSetChanged();
    }

}
