package com.example.enmalleapp.adaptadores;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enmalleapp.administracion.EncuentroCelula;
import com.example.enmalleapp.administracion.PreEncuentroCelula;
import com.example.enmalleapp.administracion.PosEncuentroCelula;
import com.example.enmalleapp.R;
import com.example.enmalleapp.modelos.CreyenteSupervision;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.claseGlobal;

public class AdaptadorRecyclerSupervision extends RecyclerView.Adapter <AdaptadorRecyclerSupervision.ViewHolderDatos> {
    ArrayList<CreyenteSupervision> listaDatosSupervision;
    private Context mContext = null;
    private OnItemClickListener mListener;
    private ViewHolderDatos viewHolder;
    ConnectionClass cc = new ConnectionClass();
    Dialog myDialog;
    Dialog myDialog2;
    Dialog myDialog3;


    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorRecyclerSupervision(ArrayList<CreyenteSupervision> listaDatosSupervision,Context mContext) {
        this.listaDatosSupervision = listaDatosSupervision;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerSupervision.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_supervision_recycler,null,false);
        return new ViewHolderDatos(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorRecyclerSupervision.ViewHolderDatos holder, int position) {
        final CreyenteSupervision  item = listaDatosSupervision.get(position);
        holder.etapa.setText(listaDatosSupervision.get(position).getEtapaCrecimiento());
        holder.redes.setText(listaDatosSupervision.get(position).getNumeroRedes());
        holder.celula.setText(listaDatosSupervision.get(position).getNumeroCelulas());
        holder.nominados.setText(listaDatosSupervision.get(position).getNumeroNominados());
        holder.candidatos.setText(listaDatosSupervision.get(position).getNumeroCandidatos());
        holder.asistentes.setText(listaDatosSupervision.get(position).getNumeroAsistentes());
        holder.pendientes.setText(listaDatosSupervision.get(position).getNumeroPendientes());
        holder.Sexo.setText(listaDatosSupervision.get(position).getSexo());

        holder.etapa2.setText(listaDatosSupervision.get(position).getEtapaCrecimiento2());
        holder.redes2.setText(listaDatosSupervision.get(position).getNumeroRedes2());
        holder.celula2.setText(listaDatosSupervision.get(position).getNumeroCelulas2());
        holder.nominados2.setText(listaDatosSupervision.get(position).getNumeroNominados2());
        holder.candidatos2.setText(listaDatosSupervision.get(position).getNumeroCandidatos2());
        holder.asistentes2.setText(listaDatosSupervision.get(position).getNumeroAsistentes2());
        holder.pendientes2.setText(listaDatosSupervision.get(position).getNumeroPendientes2());
        holder.Sexo2.setText(listaDatosSupervision.get(position).getSexo2());

        holder.etapa3.setText(listaDatosSupervision.get(position).getEtapaCrecimiento3());
        holder.redes3.setText(listaDatosSupervision.get(position).getNumeroRedes3());
        holder.celula3.setText(listaDatosSupervision.get(position).getNumeroCelulas3());
        holder.nominados3.setText(listaDatosSupervision.get(position).getNumeroNominados3());
        holder.candidatos3.setText(listaDatosSupervision.get(position).getNumeroCandidatos3());
        holder.asistentes3.setText(listaDatosSupervision.get(position).getNumeroAsistentes3());
        holder.pendientes3.setText(listaDatosSupervision.get(position).getNumeroPendientes3());
        holder.Sexo3.setText(listaDatosSupervision.get(position).getSexo3());

        //holder.setOnClickListeners();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView etapa, redes, celula, nominados, candidatos, asistentes, pendientes, txtOptiondigit,
                etapa2, redes2, celula2, nominados2, candidatos2, asistentes2, pendientes2, txtOptiondigit2,
                etapa3, redes3, celula3, nominados3, candidatos3, asistentes3, pendientes3, txtOptiondigit3;

        TextView Sexo, Sexo2, Sexo3;



        Context context;
        private LinearLayout model_supervision_recycler;
        private TextView textMensaje;
        private TextView textTipo;
        private Button buttonNo;
        private Button buttonYes;
        private ImageView imageIcon;
        private TextView dialog_tipo;
        private TextView dialog_tipo2;
        private TextView dialog_tipo3;

        public ViewHolderDatos(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            context = itemView.getContext();

            etapa = itemView.findViewById(R.id.cvEtapa);
            redes = itemView.findViewById(R.id.cvRedes);
            celula = itemView.findViewById(R.id.cvCelula);
            nominados = itemView.findViewById(R.id.cvNominados);
            candidatos = itemView.findViewById(R.id.cvCandidatos);
            asistentes = itemView.findViewById(R.id.cvAsistentes);
            pendientes = itemView.findViewById(R.id.cvPendientes);
            txtOptiondigit = (TextView) itemView.findViewById(R.id.txtOptionDigit);
            Sexo  = (TextView) itemView.findViewById(R.id.cvSexo);

            etapa2 = itemView.findViewById(R.id.cvEtapa2);
            redes2 = itemView.findViewById(R.id.cvRedes2);
            celula2 = itemView.findViewById(R.id.cvCelula2);
            nominados2 = itemView.findViewById(R.id.cvNominados2);
            candidatos2 = itemView.findViewById(R.id.cvCandidatos2);
            asistentes2 = itemView.findViewById(R.id.cvAsistentes2);
            pendientes2 = itemView.findViewById(R.id.cvPendientes2);
            txtOptiondigit2 = (TextView) itemView.findViewById(R.id.txtOptionDigit2);
            Sexo2  = (TextView) itemView.findViewById(R.id.cvSexo2);

            etapa3 = itemView.findViewById(R.id.cvEtapa3);
            redes3 = itemView.findViewById(R.id.cvRedes3);
            celula3 = itemView.findViewById(R.id.cvCelula3);
            nominados3 = itemView.findViewById(R.id.cvNominados3);
            candidatos3 = itemView.findViewById(R.id.cvCandidatos3);
            asistentes3 = itemView.findViewById(R.id.cvAsistentes3);
            pendientes3 = itemView.findViewById(R.id.cvPendientes3);
            txtOptiondigit3 = (TextView) itemView.findViewById(R.id.txtOptionDigit3);
            Sexo3  = (TextView) itemView.findViewById(R.id.cvSexo3);

            model_supervision_recycler = (LinearLayout) itemView.findViewById(R.id.contact_item_id);
            textMensaje = (TextView) itemView.findViewById(R.id.dialog_mensaje);
            textTipo = (TextView) itemView.findViewById(R.id.dialog_tipo);
            buttonYes = (Button) itemView.findViewById(R.id.buttonYes);
            buttonNo = (Button) itemView.findViewById(R.id.buttonNo);
            imageIcon = (ImageView) itemView.findViewById(R.id.imageIcon);

            // 1 PRIMERA OPTIONDIGIT
            txtOptiondigit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado1 = etapa.getText().toString();
                    if (estado1.equals("EN CURSO"))
                    {


                        final String validacion;
                        myDialog = new Dialog((mContext));
                        myDialog.setContentView(R.layout.dialog_contact);
                        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        buttonNo = (Button) myDialog.findViewById(R.id.buttonNo);
                        buttonYes = (Button) myDialog.findViewById(R.id.buttonYes);
                        dialog_tipo = (TextView) myDialog.findViewById(R.id.dialog_tipo);
                        dialog_tipo.setText("PRE-ENCUENTRO");
                        buttonNo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(context, "Se cancelo el Cierre Pre-Encuentro...", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                            }
                        });
                        buttonYes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String eta = etapa.getText().toString();
                                String sx = Sexo.getText().toString();
                                String sexo;
                                if (sx.equals("VARONES")) {
                                    sexo = "M";
                                } else {
                                    sexo = "F";
                                }


                                if ("CERRADO".equals(eta)) { //le estoy diciendo si eta es igua a CERRADO en JAVA se maneja asi
                                    Toast.makeText(context, "PRE-ECUENTRO FUE YA CERRADO", Toast.LENGTH_LONG).show();
                                    myDialog.dismiss();
                                } else {
                                    Toast.makeText(context, "Generando el cierre de PRE-ECUENTRO...", Toast.LENGTH_SHORT).show();
                                    PreparedStatement pst = cc.stConsulta("exec sp_cierre_pre_encuentro_pos ?, ?");

                                    try {
                                        pst.setString(1, "PRE");
                                        pst.setString(2, sexo);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        ResultSet rs = pst.executeQuery();
                                        myDialog.dismiss();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        //Toast.makeText(context, "No existe un Pre-encuentro pendiente de cierre...", Toast.LENGTH_SHORT).show();
                                        myDialog.dismiss();
                                    }
                                }
                            }
                        });

                        PopupMenu popupMenu = new PopupMenu(context, txtOptiondigit);
                        popupMenu.inflate(R.menu.menur);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                final Intent intent;
                                switch (item.getItemId()) {
                                    case R.id.MenuAsistencia:
                                        intent = new Intent(context, PreEncuentroCelula.class);
                                        context.startActivity(intent);
                                        break;
                                    case R.id.MenuCierre:
                                        myDialog.show();
                                        break;
                                    default:
                                        break;
                                }
                                return false;
                            }
                        });
                        popupMenu.show();
                    }else{
                        Toast.makeText(context, "PRE-ENCUENTRO FUE YA CERRADO", Toast.LENGTH_LONG).show();
                    }

                }
            });


            //2 SEGUNDA OPTIONDIGIT
            txtOptiondigit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado1 = etapa2.getText().toString();
                    if (estado1.equals("EN CURSO"))
                    {


                    myDialog2=new Dialog((mContext));
                    myDialog2.setContentView(R.layout.dialog_contact);
                    myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    buttonNo = (Button) myDialog2.findViewById(R.id.buttonNo);
                    buttonYes = (Button) myDialog2.findViewById(R.id.buttonYes);
                    dialog_tipo2 = (TextView) myDialog2.findViewById(R.id.dialog_tipo);
                    dialog_tipo2.setText("ENCUENTRO");
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "Se cancelo el Cierre Encuentro...", Toast.LENGTH_SHORT).show();
                            myDialog2.dismiss();
                        }
                    });
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String sx2 = Sexo2.getText().toString();
                            String sexo2;
                            if (sx2.equals("VARONES")){
                                sexo2 = "M";
                            }else{
                                sexo2 = "F";
                            }
                            Toast.makeText(context, "Generando el cierre del ENCUENTRO...", Toast.LENGTH_SHORT).show();
                            PreparedStatement pst = cc.stConsulta("exec sp_cierre_pre_encuentro_pos ?, ?");
                            try {
                                pst.setString(1, "ENC");
                                pst.setString(2, sexo2);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                ResultSet rs = pst.executeQuery();
                                myDialog2.dismiss();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                //Toast.makeText(context, "No existe un Encuentro pendiente de cierre...", Toast.LENGTH_SHORT).show();
                                myDialog2.dismiss();
                            }
                        }
                    });
                    PopupMenu popupMenu = new PopupMenu(context, txtOptiondigit2);
                    popupMenu.inflate(R.menu.menur);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, EncuentroCelula.class);
                                    context.startActivity(intent);
                                    break;
                                case R.id.MenuCierre:
                                    myDialog2.show();
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                    }else{
                        Toast.makeText(context, "ENCUENTRO FUE YA CERRADO", Toast.LENGTH_LONG).show();
                    }
                }
            });




            //3 TERCERA OPTIONDIGIT
            txtOptiondigit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado1 = etapa3.getText().toString();
                    if (estado1.equals("EN CURSO"))
                    {


                        myDialog3=new Dialog((mContext));
                    myDialog3.setContentView(R.layout.dialog_contact);
                    myDialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    buttonNo = (Button) myDialog3.findViewById(R.id.buttonNo);
                    buttonYes = (Button) myDialog3.findViewById(R.id.buttonYes);
                    dialog_tipo3 = (TextView) myDialog3.findViewById(R.id.dialog_tipo);
                    dialog_tipo3.setText("POS-ENCUENTRO");
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "Se cancelo la Inaguracion del Pos-Encuentro...", Toast.LENGTH_SHORT).show();
                            myDialog3.dismiss();
                        }
                    });
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String sx3 = Sexo3.getText().toString();
                            String sexo3;
                            if (sx3.equals("VARONES")){
                                sexo3 = "M";
                            }else{
                                sexo3 = "F";
                            }
                            Toast.makeText(context, "Generando la Inaguracion del POS-ECUENTRO...", Toast.LENGTH_SHORT).show();
                            PreparedStatement pst = cc.stConsulta("exec sp_cierre_pre_encuentro_pos ?, ?");
                            try {
                                pst.setString(1, "POS");
                                pst.setString(2, sexo3);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                ResultSet rs = pst.executeQuery();
                                myDialog3.dismiss();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                //Toast.makeText(context, "No existe un Pos-encuentro pendiente de cierre...", Toast.LENGTH_SHORT).show();
                                myDialog3.dismiss();
                            }
                        }
                    });
                    PopupMenu popupMenu = new PopupMenu(context, txtOptiondigit3);
                    popupMenu.inflate(R.menu.menurr);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroCelula.class);
                                    context.startActivity(intent);
                                    break;
                                case R.id.MenuInaguracion:
                                    myDialog3.show();
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                    }else{
                        Toast.makeText(context, "POS-ENCUENTRO FUE YA INAGURADO", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return listaDatosSupervision.size();
    }


}

