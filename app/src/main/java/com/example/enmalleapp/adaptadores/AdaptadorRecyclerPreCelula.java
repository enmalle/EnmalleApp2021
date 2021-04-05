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

import com.example.enmalleapp.administracion.PreDetalleActivity;
import com.example.enmalleapp.administracion.PreEncuentroCelula;
import com.example.enmalleapp.modelos.CreyentePreCelula;
import com.example.enmalleapp.R;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecyclerPreCelula extends RecyclerView.Adapter<AdaptadorRecyclerPreCelula.ViewHolderDatos> {
    ArrayList<CreyentePreCelula> listaDatosPreCelula;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerPreCelula(ArrayList<CreyentePreCelula> listaDatosPreCelula) {
        this.listaDatosPreCelula = listaDatosPreCelula;
    }


    @NonNull
    @Override
    public AdaptadorRecyclerPreCelula.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pre_encuentro_celula_recycler,null,false);
        return new ViewHolderDatos(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerPreCelula.ViewHolderDatos holder, int position) {
    final CreyentePreCelula item = listaDatosPreCelula.get(position);
        holder.lider.setText(listaDatosPreCelula.get(position).getLider());
        holder.candidatos.setText(listaDatosPreCelula.get(position).getCandidatos());
        holder.nominados.setText(listaDatosPreCelula.get(position).getNominados());
        holder.asistentes.setText(listaDatosPreCelula.get(position).getAsistentes());
        holder.idLider.setText(listaDatosPreCelula.get(position).getIdLider());
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
                    Intent intent=new Intent(context, PreDetalleActivity.class);
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
        return listaDatosPreCelula.size();
    }
}
