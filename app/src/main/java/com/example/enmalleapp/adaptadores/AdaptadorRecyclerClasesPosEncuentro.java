package com.example.enmalleapp.adaptadores;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import com.example.enmalleapp.R;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.modelos.ClasesPosEncuentro;
import com.example.enmalleapp.posclases.PosEncuentroClaseAlumnos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.enmalleapp.claseGlobal;

public class AdaptadorRecyclerClasesPosEncuentro extends RecyclerView.Adapter<AdaptadorRecyclerClasesPosEncuentro.ViewHolderDatos> {
    ArrayList<ClasesPosEncuentro> listaDatosClasesPosEncuentro;
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

    public AdaptadorRecyclerClasesPosEncuentro(ArrayList<ClasesPosEncuentro> listaDatosClasesPosEncuentro,Context mContext) {
        this.listaDatosClasesPosEncuentro = listaDatosClasesPosEncuentro;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerClasesPosEncuentro.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.model_pos_encuentro_clases,null,false);

        return new ViewHolderDatos(view, mListener);
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView
                Redes1, Celulas1, tema1, Hombres1, Mujeres1, Alumnos1, AsistentesAnterior1, EstadoClase1, txtOptionDigitPos1,
                Redes2, Celulas2, tema2, Hombres2, Mujeres2, Alumnos2, AsistentesAnterior2, EstadoClase2, txtOptionDigitPos2,
                Redes3, Celulas3, tema3, Hombres3, Mujeres3, Alumnos3, AsistentesAnterior3, EstadoClase3, txtOptionDigitPos3,
                Redes4, Celulas4, tema4, Hombres4, Mujeres4, Alumnos4, AsistentesAnterior4, EstadoClase4, txtOptionDigitPos4,
                Redes5, Celulas5, tema5, Hombres5, Mujeres5, Alumnos5, AsistentesAnterior5, EstadoClase5, txtOptionDigitPos5,
                Redes6, Celulas6, tema6, Hombres6, Mujeres6, Alumnos6, AsistentesAnterior6, EstadoClase6, txtOptionDigitPos6,
                Redes7, Celulas7, tema7, Hombres7, Mujeres7, Alumnos7, AsistentesAnterior7, EstadoClase7, txtOptionDigitPos7,
                Redes8, Celulas8, tema8, Hombres8, Mujeres8, Alumnos8, AsistentesAnterior8, EstadoClase8, txtOptionDigitPos8,
                Redes9, Celulas9, tema9, Hombres9, Mujeres9, Alumnos9, AsistentesAnterior9, EstadoClase9, txtOptionDigitPos9;

        Context context;
        private LinearLayout model_pos_encuentro_clases;
        private TextView textMensaje;
        private TextView textTipo;
        private Button buttonNo;
        private Button buttonYes;
        private ImageView imageIcon;
        private TextView dialog_tipo;
        private TextView dialog_tipo2;
        private TextView dialog_tipo3;



        public ViewHolderDatos(@NonNull View itemView, OnItemClickListener Listener) {
            super(itemView);
            context = itemView.getContext();

            Redes1 = itemView.findViewById(R.id.cvRedes1);
            Celulas1 = itemView.findViewById(R.id.cvCelula1);
            tema1 = itemView.findViewById(R.id.cvETemaClase1);
            Hombres1 = itemView.findViewById(R.id.cvVarones1);
            Mujeres1 = itemView.findViewById(R.id.cvMujeres1);
            Alumnos1 = itemView.findViewById(R.id.cvTotalAsistentes1);
            AsistentesAnterior1 = itemView.findViewById(R.id.cvTotalAsistentes1);
            EstadoClase1 = itemView.findViewById(R.id.cvEstadoClase1);
            txtOptionDigitPos1 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos1);


            Redes2 = itemView.findViewById(R.id.cvRedes2);
            Celulas2 = itemView.findViewById(R.id.cvCelula2);
            tema2 = itemView.findViewById(R.id.cvETemaClase2);
            Hombres2 = itemView.findViewById(R.id.cvVarones2);
            Mujeres2 = itemView.findViewById(R.id.cvMujeres2);
            Alumnos2 = itemView.findViewById(R.id.cvTotalAsistentes2);
            AsistentesAnterior2 = itemView.findViewById(R.id.cvTotalAsistentes2);
            EstadoClase2 = itemView.findViewById(R.id.cvEstadoClase2);
            txtOptionDigitPos2 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos2);


            Redes3 = itemView.findViewById(R.id.cvRedes3);
            Celulas3 = itemView.findViewById(R.id.cvCelula3);
            tema3 = itemView.findViewById(R.id.cvETemaClase3);
            Hombres3 = itemView.findViewById(R.id.cvVarones3);
            Mujeres3 = itemView.findViewById(R.id.cvMujeres3);
            Alumnos3 = itemView.findViewById(R.id.cvTotalAsistentes3);
            AsistentesAnterior3 = itemView.findViewById(R.id.cvTotalAsistentes3);
            EstadoClase3 = itemView.findViewById(R.id.cvEstadoClase3);
            txtOptionDigitPos3 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos3);


            Redes4 = itemView.findViewById(R.id.cvRedes4);
            Celulas4 = itemView.findViewById(R.id.cvCelula4);
            tema4 = itemView.findViewById(R.id.cvETemaClase4);
            Hombres4 = itemView.findViewById(R.id.cvVarones4);
            Mujeres4 = itemView.findViewById(R.id.cvMujeres4);
            Alumnos4 = itemView.findViewById(R.id.cvTotalAsistentes4);
            AsistentesAnterior4 = itemView.findViewById(R.id.cvTotalAsistentes4);
            EstadoClase4 = itemView.findViewById(R.id.cvEstadoClase4);
            txtOptionDigitPos4 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos4);


            Redes5 = itemView.findViewById(R.id.cvRedes5);
            Celulas5 = itemView.findViewById(R.id.cvCelula5);
            tema5 = itemView.findViewById(R.id.cvETemaClase5);
            Hombres5 = itemView.findViewById(R.id.cvVarones5);
            Mujeres5 = itemView.findViewById(R.id.cvMujeres5);
            Alumnos5 = itemView.findViewById(R.id.cvTotalAsistentes5);
            AsistentesAnterior5 = itemView.findViewById(R.id.cvTotalAsistentes5);
            EstadoClase5 = itemView.findViewById(R.id.cvEstadoClase5);
            txtOptionDigitPos5 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos5);


            Redes6 = itemView.findViewById(R.id.cvRedes6);
            Celulas6 = itemView.findViewById(R.id.cvCelula6);
            tema6 = itemView.findViewById(R.id.cvETemaClase6);
            Hombres6 = itemView.findViewById(R.id.cvVarones6);
            Mujeres6 = itemView.findViewById(R.id.cvMujeres6);
            Alumnos6 = itemView.findViewById(R.id.cvTotalAsistentes6);
            AsistentesAnterior6 = itemView.findViewById(R.id.cvTotalAsistentes6);
            EstadoClase6 = itemView.findViewById(R.id.cvEstadoClase6);
            txtOptionDigitPos6 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos6);


            Redes7 = itemView.findViewById(R.id.cvRedes7);
            Celulas7 = itemView.findViewById(R.id.cvCelula7);
            tema7 = itemView.findViewById(R.id.cvETemaClase7);
            Hombres7 = itemView.findViewById(R.id.cvVarones7);
            Mujeres7 = itemView.findViewById(R.id.cvMujeres7);
            Alumnos7 = itemView.findViewById(R.id.cvTotalAsistentes7);
            AsistentesAnterior7 = itemView.findViewById(R.id.cvTotalAsistentes7);
            EstadoClase7 = itemView.findViewById(R.id.cvEstadoClase7);
            txtOptionDigitPos7 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos7);


            Redes8 = itemView.findViewById(R.id.cvRedes8);
            Celulas8 = itemView.findViewById(R.id.cvCelula8);
            tema8 = itemView.findViewById(R.id.cvETemaClase8);
            Hombres8 = itemView.findViewById(R.id.cvVarones8);
            Mujeres8 = itemView.findViewById(R.id.cvMujeres8);
            Alumnos8 = itemView.findViewById(R.id.cvTotalAsistentes8);
            AsistentesAnterior8 = itemView.findViewById(R.id.cvTotalAsistentes8);
            EstadoClase8 = itemView.findViewById(R.id.cvEstadoClase8);
            txtOptionDigitPos8 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos8);


            Redes9 = itemView.findViewById(R.id.cvRedes9);
            Celulas9 = itemView.findViewById(R.id.cvCelula9);
            tema9 = itemView.findViewById(R.id.cvETemaClase9);
            Hombres9 = itemView.findViewById(R.id.cvVarones9);
            Mujeres9 = itemView.findViewById(R.id.cvMujeres9);
            Alumnos9 = itemView.findViewById(R.id.cvTotalAsistentes9);
            AsistentesAnterior9 = itemView.findViewById(R.id.cvTotalAsistentes9);
            EstadoClase9 = itemView.findViewById(R.id.cvEstadoClase9);
            txtOptionDigitPos9 = (TextView) itemView.findViewById(R.id.txtOptionDigitPos9);


            model_pos_encuentro_clases = (LinearLayout) itemView.findViewById(R.id.contact_item_id);
            imageIcon = (ImageView) itemView.findViewById(R.id.imageIcon);

            // 1 PRIMERA OPTIONDIGIT
            txtOptionDigitPos1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado1 = EstadoClase1.getText().toString();
                         PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos1);
                        popupMenu.inflate(R.menu.menuo);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                final Intent intent;
                                switch (item.getItemId()) {
                                    case R.id.MenuAsistencia:
                                        intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                        //envio datos al activity mediante putExtra
                                        intent.putExtra("NumeroClase", "1");
                                        context.startActivity(intent);
                                        break;
                                    default:
                                        break;
                                }
                                return false;
                            }
                        });
                        popupMenu.show();
                }
            });

            // 2 PRIMERA OPTIONDIGIT
            txtOptionDigitPos2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado1 = EstadoClase2.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos2);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "2");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 3 PRIMERA OPTIONDIGIT
            txtOptionDigitPos3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado3 = EstadoClase3.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos3);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "3");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 4 PRIMERA OPTIONDIGIT
            txtOptionDigitPos4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado4 = EstadoClase4.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos4);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "4");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 5 PRIMERA OPTIONDIGIT
            txtOptionDigitPos5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado5 = EstadoClase5.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos5);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "5");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 6 PRIMERA OPTIONDIGIT
            txtOptionDigitPos6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado6 = EstadoClase6.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos6);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "6");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 7 PRIMERA OPTIONDIGIT
            txtOptionDigitPos7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado7 = EstadoClase7.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos7);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "7");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 8 PRIMERA OPTIONDIGIT
            txtOptionDigitPos8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado8 = EstadoClase8.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos8);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "8");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

            // 9 PRIMERA OPTIONDIGIT
            txtOptionDigitPos9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String estado9 = EstadoClase9.getText().toString();
                    PopupMenu popupMenu = new PopupMenu(context, txtOptionDigitPos9);
                    popupMenu.inflate(R.menu.menuo);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            final Intent intent;
                            switch (item.getItemId()) {
                                case R.id.MenuAsistencia:
                                    intent = new Intent(context, PosEncuentroClaseAlumnos.class);
                                    intent.putExtra("NumeroClase", "9");
                                    context.startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });


        }
    }


    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerClasesPosEncuentro.ViewHolderDatos holder, int position) {
        final ClasesPosEncuentro  item = listaDatosClasesPosEncuentro.get(position);

        holder.Redes1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes1());
        holder.Celulas1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas1());
        holder.tema1.setText(listaDatosClasesPosEncuentro.get(position).getTema1());
        holder.Hombres1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres1());
        holder.Mujeres1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres1());
        holder.Alumnos1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos1());
        holder.AsistentesAnterior1.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior1());
        holder.EstadoClase1.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase1());

        holder.Redes2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes2());
        holder.Celulas2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas2());
        holder.tema2.setText(listaDatosClasesPosEncuentro.get(position).getTema2());
        holder.Hombres2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres2());
        holder.Mujeres2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres2());
        holder.Alumnos2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos2());
        holder.AsistentesAnterior2.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior2());
        holder.EstadoClase2.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase2());

        holder.Redes3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes3());
        holder.Celulas3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas3());
        holder.tema3.setText(listaDatosClasesPosEncuentro.get(position).getTema3());
        holder.Hombres3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres3());
        holder.Mujeres3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres3());
        holder.Alumnos3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos3());
        holder.AsistentesAnterior3.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior3());
        holder.EstadoClase3.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase3());

        holder.Redes4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes4());
        holder.Celulas4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas4());
        holder.tema4.setText(listaDatosClasesPosEncuentro.get(position).getTema4());
        holder.Hombres4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres4());
        holder.Mujeres4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres4());
        holder.Alumnos4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos4());
        holder.AsistentesAnterior4.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior4());
        holder.EstadoClase4.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase4());

        holder.Redes5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes5());
        holder.Celulas5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas5());
        holder.tema5.setText(listaDatosClasesPosEncuentro.get(position).getTema5());
        holder.Hombres5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres5());
        holder.Mujeres5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres5());
        holder.Alumnos5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos5());
        holder.AsistentesAnterior5.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior5());
        holder.EstadoClase5.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase5());

        holder.Redes6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes6());
        holder.Celulas6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas6());
        holder.tema6.setText(listaDatosClasesPosEncuentro.get(position).getTema6());
        holder.Hombres6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres6());
        holder.Mujeres6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres6());
        holder.Alumnos6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos6());
        holder.AsistentesAnterior6.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior6());
        holder.EstadoClase6.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase6());

        holder.Redes7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes7());
        holder.Celulas7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas7());
        holder.tema7.setText(listaDatosClasesPosEncuentro.get(position).getTema7());
        holder.Hombres7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres7());
        holder.Mujeres7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres7());
        holder.Alumnos7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos7());
        holder.AsistentesAnterior7.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior7());
        holder.EstadoClase7.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase7());

        holder.Redes8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes8());
        holder.Celulas8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas8());
        holder.tema8.setText(listaDatosClasesPosEncuentro.get(position).getTema8());
        holder.Hombres8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres8());
        holder.Mujeres8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres8());
        holder.Alumnos8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos8());
        holder.AsistentesAnterior8.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior8());
        holder.EstadoClase8.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase8());

        holder.Redes9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroRedes9());
        holder.Celulas9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroCelulas9());
        holder.tema9.setText(listaDatosClasesPosEncuentro.get(position).getTema9());
        holder.Hombres9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroHombres9());
        holder.Mujeres9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroMujeres9());
        holder.Alumnos9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAlumnos9());
        holder.AsistentesAnterior9.setText(listaDatosClasesPosEncuentro.get(position).getNumeroAsistentesAnterior9());
        holder.EstadoClase9.setText(listaDatosClasesPosEncuentro.get(position).getEstadoClase9());



    }



        @Override
    public int getItemCount() {
        return listaDatosClasesPosEncuentro.size();
    }


}
