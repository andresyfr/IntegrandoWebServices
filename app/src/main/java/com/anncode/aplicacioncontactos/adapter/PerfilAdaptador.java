package com.anncode.aplicacioncontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.aplicacioncontactos.DetalleContacto;
import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.pojo.DataUser;
import com.anncode.recyclerviewfragments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Andres Caicedo on 22/07/17.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<DataUser> dataUser;
    Activity activity;

    public PerfilAdaptador(ArrayList<DataUser> dataUser, Activity activity) {
        this.dataUser = dataUser;
        this.activity = activity;
        TextView tvNombrePerfil = (TextView) activity.findViewById(R.id.tvNombrePerfil);
        ImageView imageViewPerfil = (ImageView) activity.findViewById(R.id.imageViewPerfil);
        Picasso.with(activity)
                .load(dataUser.get(0).getUrlFoto().toString())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(imageViewPerfil);
        tvNombrePerfil.setText(dataUser.get(0).getUserName().toString());
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder perfilViewHolder, int position) {
        final DataUser datUser = dataUser.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        Picasso.with(activity)
                .load(datUser.getUrlFoto().toString())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(perfilViewHolder.imgFoto);
        //contactoViewHolder.tvNombre.setText(contacto.getNombre());
        //contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        perfilViewHolder.tvNombreUser.setText(datUser.getUserName().toString());
        
        perfilViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url", datUser.getUrlFoto());
                intent.putExtra("like", datUser.getNombreCompleto());
                //intent.putExtra("email", contacto.getEmail());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transicion_foto)).toBundle());
                }else {
                    activity.startActivity(intent);
                }



            }
        });

        /*contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeCotnacto(contacto);
                contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto) + " Likes");


            }
        });*/


    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        //private TextView tvNombre;
        //private TextView tvTelefono;
        //private ImageButton btnLike;
        private TextView tvNombreUser;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imageViewPerfil);
            /*tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
            */
            tvNombreUser     = (TextView) itemView.findViewById(R.id.tvNombrePerfil);

        }
    }
}
