package info.palomatica.intentbidireccional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity
{

    private TextView tvTexto;
    private EditText etTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tvTexto = findViewById(R.id.tvTexto);
        etTexto = findViewById(R.id.etTexto);

        String texto = getIntent().getStringExtra(MainActivity.KEY_TEXTO);
        tvTexto.setText(texto);

    }

    public void onClickEnviar(View view)
    {
        String texto = etTexto.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_TEXTO, texto);

        setResult(RESULT_OK, intent);
        System.currentTimeMillis();
        finish();
    }
}
