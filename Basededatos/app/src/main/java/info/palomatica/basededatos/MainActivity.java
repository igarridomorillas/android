package info.palomatica.basededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private LinearLayout llTextos;
    private EditText etTexto;
    private CadenasDB cadenasDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llTextos = findViewById(R.id.llTextos);
        etTexto = findViewById(R.id.etTexto);

        // Base de datos

        cadenasDB = CadenasDB.getInstance(this);

        cargarTextos();

    }

    private void cargarTextos()
    {

        for(String cadena: cadenasDB.getCadenas())
        {
            llTextos.addView(creaBoton(cadena));
        }
    }

    private Button creaBoton(final String texto)
    {
        Button button = new Button(this);
        button.setText(texto);
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cadenasDB.eliminarCadena(texto);
                llTextos.removeView(v);
            }
        });
        return button;
    }

    public void onClickAnadir(View view)
    {
        String texto = etTexto.getText().toString();
        if(texto.length() > 0)
        {
            if (cadenasDB.insertarCadena(texto))
            {
                llTextos.addView(creaBoton(texto));
                etTexto.setText(null);
            }
            else
            {
                Toast.makeText(this, R.string.yaExiste, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
