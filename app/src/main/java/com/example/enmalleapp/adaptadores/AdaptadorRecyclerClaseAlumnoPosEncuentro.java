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
import com.example.enmalleapp.modelos.CreyentePreDetalle;
import java.util.ArrayList;

public class AdaptadorRecyclerClaseAlumnoPosEncuentro extends RecyclerView.Adapter <AdaptadorRecyclerClaseAlumnoPosEncuentro.ViewHolderDatos> {

    ArrayList<CreyentePreDetalle> listaDatosPreDetalle;
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

    public AdaptadorRecyclerClaseAlumnoPosEncuentro(ArrayList<CreyentePreDetalle> listaDatosPreDetalle) {
        this.listaDatosPreDetalle = listaDatosPreDetalle;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerClaseAlumnoPosEncuentro.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pre_detalle_recycler,null,false);
        return new ViewHolderDatos(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorRecyclerClaseAlumnoPosEncuentro.ViewHolderDatos holder, final int position) {
        holder.idcreyentepredetalle.setText(listaDatosPreDetalle.get(position).getIdCreyentePreDetalle());
        holder.nombreliderpredetalle.setText(listaDatosPreDetalle.get(position).getNombresLiderPreDetalle());
        holder.nombrespredetalle.setText(listaDatosPreDetalle.get(position).getNombresPreDetalle());
        holder.apellidospredetalle.setText(listaDatosPreDetalle.get(position).getApellidosPreDetalle());
        holder.edadpredetalle.setText(listaDatosPreDetalle.get(position).getEdadPreDetalle());
        holder.checkboxasistencia.setChecked(listaDatosPreDetalle.get(position).isSelected());
        holder.checkboxasistencia.setTag(listaDatosPreDetalle.get(position));
        holder.checkboxasistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked =  holder.checkboxasistencia.isChecked();
                CheckBox cb = (CheckBox) view;
                CreyentePreDetalle contact = (CreyentePreDetalle) cb.getTag();
                contact.setSelected(cb.isChecked());
                listaDatosPreDetalle.get(position).setSelected(cb.isChecked());
            }
        });
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idcreyentepredetalle,
                nombreliderpredetalle,
                nombrespredetalle,
                apellidospredetalle,
                edadpredetalle;
        CheckBox checkboxasistencia;

        public ViewHolderDatos(@NonNull View itemView , final OnItemClickListener listener) {
            super(itemView);
            idcreyentepredetalle = itemView.findViewById(R.id.tvMPDId);
            nombreliderpredetalle = itemView.findViewById(R.id.tvMPDNombreLider);
            nombrespredetalle = itemView.findViewById(R.id.tvMPDNombres);
            apellidospredetalle = itemView.findViewById(R.id.tvMPDApellidos);
            edadpredetalle = itemView.findViewById(R.id.tvMPDEdad);
            checkboxasistencia = itemView.findViewById(R.id.checkboxAsistencia);
        }
    }
    @Override
    public int getItemCount() {
        return listaDatosPreDetalle.size();
    }
}
