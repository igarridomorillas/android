package info.palomatica.basededatos;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{

    private LinearLayout llTextos;
    private EditText etTexto;
    private SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llTextos = findViewById(R.id.llTextos);
        etTexto = findViewById(R.id.etTexto);

        // Base de datos
        TextosDBHelper textosDBHelper = new TextosDBHelper(this, "textos.db", null, 1);
        sqlDB = textosDBHelper.getWritableDatabase();





    }

    public void onClickAnadir(View view)
    {
        String texto = etTexto.getText().toString();
        if(texto.length() > 0)
        {

            Button btTexto = new Button(this);
            btTexto.setText(texto);
            llTextos.addView(btTexto);
            etTexto.setText(null);

            sqlDB.execSQL("fghfgh fhfd hdfch");


        }
    }
}
