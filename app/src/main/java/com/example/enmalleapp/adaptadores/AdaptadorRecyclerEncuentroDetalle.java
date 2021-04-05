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
import com.example.enmalleapp.modelos.CreyenteEncuentroDetalle;
import java.util.ArrayList;

public class AdaptadorRecyclerEncuentroDetalle extends RecyclerView.Adapter <AdaptadorRecyclerEncuentroDetalle.ViewHolderDatos>{
    ArrayList<CreyenteEncuentroDetalle> listaDatosEncuentroDetalle;
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

    public AdaptadorRecyclerEncuentroDetalle(ArrayList<CreyenteEncuentroDetalle> listaDatosEncuentroDetalle) {
        this.listaDatosEncuentroDetalle = listaDatosEncuentroDetalle;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerEncuentroDetalle.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pre_detalle_recycler,null,false);
        return new ViewHolderDatos(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorRecyclerEncuentroDetalle.ViewHolderDatos holder, final int position) {
        holder.idCreyenteEncuentroDetalle.setText(listaDatosEncuentroDetalle.get(position).getIdCreyenteEncuentroDetalle());
        holder.nombreliderencuentrodetalle.setText(listaDatosEncuentroDetalle.get(position).getNombresLiderEncuentroDetalle());
        holder.nombresencuentrodetalle.setText(listaDatosEncuentroDetalle.get(position).getNombresEncuentroDetalle());
        holder.apellidosencuentrodetalle.setText(listaDatosEncuentroDetalle.get(position).getApellidosEncuentroDetalle());
        holder.edadencuentrodetalle.setText(listaDatosEncuentroDetalle.get(position).getEdadEncuentroDetalle());
        holder.checkboxasistencia.setChecked(listaDatosEncuentroDetalle.get(position).isSelected());
        holder.checkboxasistencia.setTag(listaDatosEncuentroDetalle.get(position));
        holder.checkboxasistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked =  holder.checkboxasistencia.isChecked();
                CheckBox cb = (CheckBox) view;
                CreyenteEncuentroDetalle contact = (CreyenteEncuentroDetalle) cb.getTag();
                contact.setSelected(cb.isChecked());
                listaDatosEncuentroDetalle.get(position).setSelected(cb.isChecked());
            }
        });
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idCreyenteEncuentroDetalle,
                nombreliderencuentrodetalle,
                nombresencuentrodetalle,
                apellidosencuentrodetalle,
                edadencuentrodetalle;
        CheckBox checkboxasistencia;

        public ViewHolderDatos(@NonNull View itemView , final OnItemClickListener listener) {
            super(itemView);
            idCreyenteEncuentroDetalle = itemView.findViewById(R.id.tvMPDId);
            nombreliderencuentrodetalle = itemView.findViewById(R.id.tvMPDNombreLider);
            nombresencuentrodetalle = itemView.findViewById(R.id.tvMPDNombres);
            apellidosencuentrodetalle = itemView.findViewById(R.id.tvMPDApellidos);
            edadencuentrodetalle = itemView.findViewById(R.id.tvMPDEdad);
            checkboxasistencia = itemView.findViewById(R.id.checkboxAsistencia);
        }
    }
    @Override
    public int getItemCount() {
        return listaDatosEncuentroDetalle.size();
    }
}
