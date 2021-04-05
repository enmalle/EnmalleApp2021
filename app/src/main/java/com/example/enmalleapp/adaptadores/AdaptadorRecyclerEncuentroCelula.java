package com.example.enmalleapp.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enmalleapp.administracion.EncuentroDetalleActivity;
import com.example.enmalleapp.modelos.CreyenteEncuentroCelula;
import com.example.enmalleapp.R;
import java.util.ArrayList;

public class AdaptadorRecyclerEncuentroCelula extends RecyclerView.Adapter<AdaptadorRecyclerEncuentroCelula.ViewHolderDatos> {
    ArrayList<CreyenteEncuentroCelula> listaDatosEncuentroCelula;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerEncuentroCelula(ArrayList<CreyenteEncuentroCelula> listaDatosEncuentroCelula) {
        this.listaDatosEncuentroCelula = listaDatosEncuentroCelula;
    }


    @NonNull
    @Override
    public AdaptadorRecyclerEncuentroCelula.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_encuentro_celula_recycler,null,false);
        return new ViewHolderDatos(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerEncuentroCelula.ViewHolderDatos holder, int position) {
        final CreyenteEncuentroCelula item = listaDatosEncuentroCelula.get(position);
        holder.lider.setText(listaDatosEncuentroCelula.get(position).getLider());
        holder.candidatos.setText(listaDatosEncuentroCelula.get(position).getCandidatos());
        holder.nominados.setText(listaDatosEncuentroCelula.get(position).getNominados());
        holder.asistentes.setText(listaDatosEncuentroCelula.get(position).getAsistentes());
        holder.idLider.setText(listaDatosEncuentroCelula.get(position).getIdLider());
        holder.setOnClickListeners();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView lider, candidatos, nominados, asistentes, idLider;
        Button btnregistrarasistencia, btncompletar;

        Context context;

        public ViewHolderDatos(@NonNull View itemView, OnItemClickListener mListener) {
            super(itemView);
            context = itemView.getContext();

            lider = itemView.findViewById(R.id.tvMPECLider);
            candidatos = itemView.findViewById(R.id.tvMPECCandidatos);
            nominados  = itemView.findViewById(R.id.tvMPECNominados);
            asistentes = itemView.findViewById(R.id.tvMPECAsistentes);
            idLider = itemView.findViewById(R.id.tvMPECIdLider);
            btnregistrarasistencia = itemView.findViewById(R.id.btMPECRegistrarAsistencia);
            //btncompletar = itemView.findViewById(R.id.btMPECCompletar);
        }

        void setOnClickListeners() {
            //btncompletar.setOnClickListener(this);
            btnregistrarasistencia.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btMPECRegistrarAsistencia:
                    Intent intent=new Intent(context, EncuentroDetalleActivity.class);
                    //envio datos al activity mediante putExtra
                    intent.putExtra("idLiderDesdeAdapter", idLider.getText());
                    context.startActivity(intent);
                    break;
                default:
                    Toast.makeText(context, "Default", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return listaDatosEncuentroCelula.size();
    }
}
