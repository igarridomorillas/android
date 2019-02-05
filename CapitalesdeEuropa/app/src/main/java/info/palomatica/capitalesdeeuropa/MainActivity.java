package info.palomatica.capitalesdeeuropa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import info.palomatica.capitalesdeeuropa.database.DBPreguntas;
import info.palomatica.capitalesdeeuropa.database.Pregunta;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBPreguntas dbPreguntas = DBPreguntas.getInstance(this);
        ArrayList<Pregunta> alPreguntas = dbPreguntas.getPreguntas();
        for(Pregunta pregunta: alPreguntas)
        {
            Log.d("WWW", pregunta.getCorrecta());
        }

    }
}
