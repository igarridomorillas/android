package info.palomatica.intentbidireccional;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private static final int REQUEST_CODE_ACTIVITY_SEGUNDO = 1;
    private EditText etTexto;
    private TextView tvTexto;
    public final static String KEY_TEXTO = "key_texto";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTexto = findViewById(R.id.tvTexto);
        etTexto = findViewById(R.id.etTexto);
    }

    public void onClickEnviar(View view)
    {
        Intent intent = new Intent(this, SegundoActivity.class);
        intent.putExtra(KEY_TEXTO, etTexto.getText().toString());
        startActivityForResult(intent, REQUEST_CODE_ACTIVITY_SEGUNDO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == REQUEST_CODE_ACTIVITY_SEGUNDO && resultCode == RESULT_OK)
        {
            tvTexto.setText(intent.getStringExtra(KEY_TEXTO));
        }
    }
}
