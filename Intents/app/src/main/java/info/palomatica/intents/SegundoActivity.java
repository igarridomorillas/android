package info.palomatica.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity
{

    private TextView tvTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tvTexto = findViewById(R.id.tvTexto);

        Intent intent = getIntent();
        String texto = intent.getStringExtra(MainActivity.KEY_TEXTO);
        tvTexto.setText(texto);

    }
}
