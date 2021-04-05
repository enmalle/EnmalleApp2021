package com.example.enmalleapp.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enmalleapp.R;
import com.example.enmalleapp.modelos.CreyenteTurnos;

import java.util.ArrayList;

public class AdaptadorRecyclerTurnos extends RecyclerView.Adapter <AdaptadorRecyclerTurnos.ViewHolderDatos>{
    ArrayList<CreyenteTurnos> listaDatosTurnos;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(AdaptadorRecyclerTurnos.OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerTurnos(ArrayList<CreyenteTurnos> listaDatosTurnos) {
        this.listaDatosTurnos = listaDatosTurnos;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerTurnos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_turnos_recycler,null,false);
        return new ViewHolderDatos(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerTurnos.ViewHolderDatos holder, int position) {
        holder.fechaturnos.setText(listaDatosTurnos.get(position).getFechaTurno());
        holder.accionturnos.setText(listaDatosTurnos.get(position).getAccionTurno());
    }

    @Override
    public int getItemCount() {
        return listaDatosTurnos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView fechaturnos, accionturnos;

        public ViewHolderDatos(@NonNull View itemView, OnItemClickListener mListener) {
            super(itemView);
            fechaturnos = itemView.findViewById(R.id.tvFechaTurno);
            accionturnos = itemView.findViewById(R.id.tvAccionTurno);
        }
    }
}
