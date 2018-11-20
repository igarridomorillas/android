package info.palomatica.generarbotones;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private EditText etNumero;
    private TextView tvTiempo;

    public final static String KEY_NUMERO = "key_numero";
    public final static int RC_BOTONES = 1;

    private long tiempoInicio;
    private long tiempoFin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        tvTiempo = findViewById(R.id.tvTiempo);

    }

    public void onClickAceptar(View view)
    {
        String texto = etNumero.getText().toString();
        if(texto.length() > 0)
        {

            Intent intent = new Intent(this, BotonesActivity.class);
            int numBotones = Integer.parseInt(texto);
            intent.putExtra(KEY_NUMERO, numBotones);

            tiempoInicio = System.currentTimeMillis();

            startActivityForResult(intent, RC_BOTONES);
        }
        else
        {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == RC_BOTONES && resultCode == RESULT_OK)
        {
            tiempoFin = System.currentTimeMillis();
            float segundos = (tiempoFin - tiempoInicio) / 1000f;

            tvTiempo.setText(getString(R.string.hasTardadoSegundos, segundos));
        }
    }
}
