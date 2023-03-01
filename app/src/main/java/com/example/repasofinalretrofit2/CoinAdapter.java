package com.example.repasofinalretrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasofinalretrofit2.modelos.Coin;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinVH> {
    //para trabajar este adapter necvesita una lista de DataItems llamada objects
    //

    private List<Coin> objects;
    private int resource;
    private Context context;

    public CoinAdapter(List<Coin> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public CoinVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //del tiron
        return new CoinVH(LayoutInflater.from(context).inflate(resource, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CoinVH holder, int position) {
        Coin mone = objects.get(position);
        holder.lblsimbolo.setText(mone.getName());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class CoinVH extends RecyclerView.ViewHolder {
        TextView lblsimbolo;
        TextView lblnomb;
        TextView lblprecio;
        TextView lblexplor;
        public CoinVH(@NonNull View itemView) {
            super(itemView);
            lblsimbolo = itemView.findViewById(R.id.lblsimbCard);
            lblnomb = itemView.findViewById(R.id.lblNameCard);
            lblprecio = itemView.findViewById(R.id.lblprice);
            lblexplor = itemView.findViewById(R.id.lblexplorerCard);
        }
    }
}

