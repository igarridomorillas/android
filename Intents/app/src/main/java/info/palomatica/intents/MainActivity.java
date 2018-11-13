package info.palomatica.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    public static final String KEY_TEXTO = "key_texto";
    private EditText etTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = findViewById(R.id.etTexto);
    }

    public void onClickEnviar(View view)
    {
        Intent intent = new Intent(this, SegundoActivity.class);
        String texto = etTexto.getText().toString();
        intent.putExtra(KEY_TEXTO, texto);
        startActivity(intent);
    }
}
