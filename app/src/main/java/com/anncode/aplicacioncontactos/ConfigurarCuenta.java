package com.anncode.aplicacioncontactos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.restApi.ConstantesRestApi;
import com.anncode.recyclerviewfragments.R;

public class ConfigurarCuenta extends AppCompatActivity {

    private Acciones accionesMenus;
    private EditText cuenta;
    private Button botonGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        accionesMenus = Acciones.getInstance();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
//        setSupportActionBar(miActionBar);
        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cuenta          = (EditText) findViewById(R.id.editTextConfiguarCuenta);
        botonGuardar    = (Button) findViewById(R.id.buttonConfigurarCuenta);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionesMenus.setNombreCuentaConfigurado(cuenta.getText().toString());
                ConstantesRestApi.setName_user(cuenta.getText().toString());
                Toast.makeText(v.getContext()," Se configuro " + cuenta.getText().toString() + " como cuenta predeterminada!", Toast.LENGTH_LONG).show();
//                accionesMenus.getPerfilFragment().onDestroy();

                System.out.println("asdfasdfasdfasdfgasdgfasdb "+accionesMenus.getPerfilFragment().getTag());

                /*FragmentTabHost tabHost3 = (FragmentTabHost) findViewById(android.R.id.tabhost);
                String current_tab = tabHost3.getCurrentTabTag();
                if (current_tab.equals("1")) {
                    Fragment ni = (Fragment) getSupportFragmentManager().findFragmentByTag("1");
                    ni.onResume();
                }*/

//               Fragment frg = null;
//                frg = getSupportFragmentManager().findFragmentByTag();
//
//                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.detach(frg);
//                ft.attach(frg);
//                ft.commit();

                finish();
//                Intent intent = new Intent(activity, DetalleMascota.class);
//                intent.putExtra(activity.getResources().getString(R.string.pImagen), mascota.getFotoMascota());
//                intent.putExtra(activity.getResources().getString(R.string.pNombre), mascota.getNombreMascota());
//                intent.putExtra(activity.getResources().getString(R.string.pCalificacion), mascota.getCalificacion());
//                intent.putExtra("Mascota", mascota);
//                activity.startActivity(intent);

                //activity.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favoritos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return accionesMenus.accionesMune(item, super.onOptionsItemSelected(item), this);
    }
}
