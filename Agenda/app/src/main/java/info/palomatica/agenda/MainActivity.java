package info.palomatica.agenda;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity
{


    private final int REQUEST_CODE_CREAR_CONTACTO = 0;
    private LinearLayout llContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llContactos = findViewById(R.id.llContactos);
    }

    public void onClickNuevoContacto(View view)
    {
        /*
        Intent intent = new Intent(this, CrearContactoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_CREAR_CONTACTO);
        */

        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout rlContacto = (RelativeLayout) layoutInflater.inflate(R.layout.item_contacto, null);

        TextView tvNombre = rlContacto.findViewById(R.id.tvNombre);
        tvNombre.setText("Pepe");
        TextView tvTelefono = rlContacto.findViewById(R.id.tvTelefono);
        tvTelefono.setText("3453453");

        llContactos.addView(rlContacto);




    }


}
