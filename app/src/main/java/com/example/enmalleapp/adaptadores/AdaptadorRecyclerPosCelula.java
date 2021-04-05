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

import com.example.enmalleapp.administracion.PosDetalleActivity;
import com.example.enmalleapp.administracion.PosEncuentroCelula;
import com.example.enmalleapp.modelos.CreyentePosCelula;
import com.example.enmalleapp.R;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecyclerPosCelula extends RecyclerView.Adapter<AdaptadorRecyclerPosCelula.ViewHolderDatos> {
    ArrayList<CreyentePosCelula> listaDatosPosCelula;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerPosCelula(ArrayList<CreyentePosCelula> listaDatosPosCelula) {
        this.listaDatosPosCelula = listaDatosPosCelula;
    }


    @NonNull
    @Override
    public AdaptadorRecyclerPosCelula.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pos_encuentro_celula_recycler,null,false);
        return new ViewHolderDatos(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerPosCelula.ViewHolderDatos holder, int position) {
        final CreyentePosCelula item = listaDatosPosCelula.get(position);
        holder.lider.setText(listaDatosPosCelula.get(position).getLider());
        holder.candidatos.setText(listaDatosPosCelula.get(position).getCandidatos());
        holder.nominados.setText(listaDatosPosCelula.get(position).getNominados());
        holder.asistentes.setText(listaDatosPosCelula.get(position).getAsistentes());
        holder.idLider.setText(listaDatosPosCelula.get(position).getIdLider());
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
                    Intent intent=new Intent(context, PosDetalleActivity.class);
                    //envio datos al activity mediante putExtra
                    intent.putExtra("idLiderDesdeAdapter", idLider.getText());
                    context.startActivity(intent);
                    break;
                /*case R.id.btMPECCompletar:
                    Toast.makeText(context, "Completar", Toast.LENGTH_LONG).show();
                    break;
                 */
                default:
                    Toast.makeText(context, "Default", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return listaDatosPosCelula.size();
    }
}
