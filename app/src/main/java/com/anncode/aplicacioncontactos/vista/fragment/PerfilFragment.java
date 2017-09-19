package com.anncode.aplicacioncontactos.vista.fragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.aplicacioncontactos.adapter.ContactoAdaptador;
import com.anncode.aplicacioncontactos.adapter.PerfilAdaptador;
import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.pojo.DataUser;
import com.anncode.aplicacioncontactos.presentador.IRecylerViewFragmentPresenter;
import com.anncode.aplicacioncontactos.presentador.PerfilRecyclerViewFragmentPresenter;
import com.anncode.aplicacioncontactos.presentador.RecyclerViewFragmentPresenter;
import com.anncode.recyclerviewfragments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView{

    private ImageView fotoPerfil;
    private TextView textoPerfil;
    private View v;

    private ArrayList<DataUser> dataUser;
    private RecyclerView rvPerfilCuenta;
    private IRecylerViewFragmentPresenter presenter;

    public PerfilFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        this.v=v;
        rvPerfilCuenta = (RecyclerView) v.findViewById(R.id.rvPerfilCuenta);

        //extraemos el drawable en un bitmap
        Drawable originalDrawable = getResources().getDrawable(R.drawable.shock_rave_bonus_icon);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        ImageView imageView = (ImageView) v.findViewById(R.id.imageViewPerfil);
        fotoPerfil=imageView;
        imageView.setImageDrawable(roundedDrawable);

        textoPerfil= (TextView) v.findViewById(R.id.tvNombrePerfil);

        presenter = new PerfilRecyclerViewFragmentPresenter(this, getContext());


        return v;
//        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerfilCuenta.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvPerfilCuenta.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> dataUser) {
        ContactoAdaptador adaptador = new ContactoAdaptador(dataUser, getActivity()  );
        return adaptador;
    }

    public PerfilAdaptador crearAdaptador2(ArrayList<DataUser> dataUser) {
        PerfilAdaptador adaptador = new PerfilAdaptador(dataUser, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvPerfilCuenta.setAdapter(adaptador);
    }

    @Override
    public void inicializarPerfil(ArrayList<DataUser> dataUsers) {
        DataUser data = dataUsers.get(0);
//        System.out.println("dataaaaaaaaaa "+data);
        textoPerfil.setText(data.getUserName());
        Picasso.with(v.getContext())
                .load(data.getUrlFoto())
                .placeholder(R.drawable.shock_rave_bonus_icon)
                .into(fotoPerfil);
    }

}
