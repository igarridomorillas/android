package info.palomatica.agenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{


    private final int REQUEST_CODE_CREAR_CONTACTO = 0;
    private LinearLayout llContactos;

    private ContactosDB contactosDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llContactos = findViewById(R.id.llContactos);

        contactosDB = ContactosDB.getInstance(this);

        dibujarContactos();

    }

    private void dibujarContactos()
    {
        llContactos.removeAllViews();

        LayoutInflater layoutInflater = getLayoutInflater();

        RelativeLayout rlContacto;

        for(final Contacto contacto: contactosDB.getContactos())
        {
            rlContacto = (RelativeLayout) layoutInflater.inflate(R.layout.item_contacto, null);
            TextView tvNombre = rlContacto.findViewById(R.id.tvNombre);
            TextView tvTelefono = rlContacto.findViewById(R.id.tvTelefono);
            ImageView ivIcono = rlContacto.findViewById(R.id.ivIcono);

            tvNombre.setText(contacto.getNombre());
            tvTelefono.setText(contacto.getTelefono());

            switch (contacto.getCategoria())
            {
                case Contacto.CAT_AMIGOS:
                   ivIcono.setBackgroundResource(R.drawable.cat_amigos);
                   break;
                case Contacto.CAT_FAMILIARES:
                    ivIcono.setBackgroundResource(R.drawable.cat_familia);
                    break;
                case Contacto.CAT_TRABAJO:
                    ivIcono.setBackgroundResource(R.drawable.cat_trabajo);
                    break;
            }

            rlContacto.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(final View v)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle(R.string.dialogoBorrarContacto)
                        .setMessage(R.string.dialogoConfirmar)
                        .setPositiveButton(R.string.dialogoSi, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                contactosDB.eliminarContacto(contacto.getId());
                                llContactos.removeView(v);
                                dialog.dismiss();
                            }
                        });
                    builder.setNegativeButton(R.string.dialogoNo, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    return true;
                }
            });

            rlContacto.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String[] opciones = { getString(R.string.dialogoLlamar), getString(R.string.dialogoEnviarSMS)};



                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.dialogoOpciones);

                    builder.setItems(opciones, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            if(which == 0) // Llamar
                            {
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:" + contacto.getTelefono()));

                                startActivity(intent);
                            }
                            else if(which == 1) // SMS
                            {

                            }

                            dialog.dismiss();
                        }
                    });


                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });


            llContactos.addView(rlContacto);
        }
    }


    public void onClickNuevoContacto(View view)
    {


        Intent intent = new Intent(this, CrearContactoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_CREAR_CONTACTO);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {

        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE_CREAR_CONTACTO)
        {
            dibujarContactos();
        }

    }
}
