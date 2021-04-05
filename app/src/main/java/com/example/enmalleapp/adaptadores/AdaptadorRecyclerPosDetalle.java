package com.example.enmalleapp.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.enmalleapp.R;
import com.example.enmalleapp.modelos.CreyentePosDetalle;
import java.util.ArrayList;

public class AdaptadorRecyclerPosDetalle extends RecyclerView.Adapter <AdaptadorRecyclerPosDetalle.ViewHolderDatos>{
    ArrayList<CreyentePosDetalle> listaDatosPosDetalle;
    private Context mContext = null;
    private OnItemClickListener mListener;
    private ViewHolderDatos viewHolder;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerPosDetalle(ArrayList<CreyentePosDetalle> listaDatosPosDetalle) {
        this.listaDatosPosDetalle = listaDatosPosDetalle;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerPosDetalle.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pos_detalle_recycler,null,false);
        return new ViewHolderDatos(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorRecyclerPosDetalle.ViewHolderDatos holder, final int position) {
        holder.idCreyentePosDetalle.setText(listaDatosPosDetalle.get(position).getIdCreyentePosDetalle());
        holder.nombreliderposdetalle.setText(listaDatosPosDetalle.get(position).getNombresLiderPosDetalle());
        holder.nombresposdetalle.setText(listaDatosPosDetalle.get(position).getNombresPosDetalle());
        holder.apellidosposdetalle.setText(listaDatosPosDetalle.get(position).getApellidosPosDetalle());
        holder.edadposdetalle.setText(listaDatosPosDetalle.get(position).getEdadPosDetalle());
        holder.checkboxasistencia.setChecked(listaDatosPosDetalle.get(position).isSelected());
        holder.checkboxasistencia.setTag(listaDatosPosDetalle.get(position));
        holder.checkboxasistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked =  holder.checkboxasistencia.isChecked();
                CheckBox cb = (CheckBox) view;
                CreyentePosDetalle contact = (CreyentePosDetalle) cb.getTag();
                contact.setSelected(cb.isChecked());
                listaDatosPosDetalle.get(position).setSelected(cb.isChecked());
            }
        });
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idCreyentePosDetalle,
                nombreliderposdetalle,
                nombresposdetalle,
                apellidosposdetalle,
                edadposdetalle;
        CheckBox checkboxasistencia;

        public ViewHolderDatos(@NonNull View itemView , final OnItemClickListener listener) {
            super(itemView);
            idCreyentePosDetalle = itemView.findViewById(R.id.tvMPDId);
            nombreliderposdetalle = itemView.findViewById(R.id.tvMPDNombreLider);
            nombresposdetalle = itemView.findViewById(R.id.tvMPDNombres);
            apellidosposdetalle = itemView.findViewById(R.id.tvMPDApellidos);
            edadposdetalle = itemView.findViewById(R.id.tvMPDEdad);
            checkboxasistencia = itemView.findViewById(R.id.checkboxAsistencia);
        }
    }
    @Override
    public int getItemCount() {
        return listaDatosPosDetalle.size();
    }
}
