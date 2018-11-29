package info.palomatica.examen1ev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{

    private LinearLayout llIzquierda;
    private LinearLayout llDerecha;

    private int colorIzquierda;
    private int colorDerecha;

    private final String KEY_NUM_RECTANGULOS_IZQ = "num_rec_izq";
    private final String KEY_NUM_RECTANGULOS_DER = "num_rec_der";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llIzquierda = (LinearLayout) findViewById(R.id.llIzquierda);
        llDerecha = (LinearLayout) findViewById(R.id.llDerecha);

        colorIzquierda = R.color.color1;
        colorDerecha = R.color.color2;

        if(savedInstanceState != null)
        {
            int numIzquierda = savedInstanceState.getInt(KEY_NUM_RECTANGULOS_IZQ);
            int numDerecha = savedInstanceState.getInt(KEY_NUM_RECTANGULOS_DER);

            for(int i = 0; i < numIzquierda; i++)
            {
                Button btRectangulo = new Button(this);
                anadirRectangulo(llIzquierda, btRectangulo, colorIzquierda);
                colorIzquierda = alternarColor(colorIzquierda);
            }

            for(int i = 0; i < numDerecha; i++)
            {
                Button btRectangulo = new Button(this);
                anadirRectangulo(llDerecha, btRectangulo, colorDerecha);
                colorIzquierda = alternarColor(colorIzquierda);
            }

        }

    }

    public void onClickAnadir(View view)
    {
        Button btRectangulo = new Button(this);
        if(view.getId() == R.id.btAnadirIzq)
        {
            colorIzquierda = alternarColor(colorIzquierda);
            anadirRectangulo(llIzquierda, btRectangulo, colorIzquierda);
        }
        else
        {
            colorDerecha = alternarColor(colorDerecha);
            anadirRectangulo(llDerecha, btRectangulo, colorDerecha);
        }
    }

    private void anadirRectangulo(LinearLayout linearLayout, Button button, int colorResource)
    {
        button.setBackgroundResource(colorResource);
        linearLayout.addView(button);
    }

    private int alternarColor(int color)
    {
        if(color == R.color.color1)
        {
            color = R.color.color2;
        }
        else
        {
            color = R.color.color1;
        }

        return color;
    }

    public void onClickEliminar(View view)
    {
        // llIzquierda.removeView(llIzquierda.getChildAt(llIzquierda.getChildCount() - 1));

        if(view.getId() == R.id.btEliminarIzq && llIzquierda.getChildCount() > 0)
        {
            llIzquierda.removeViewAt(llIzquierda.getChildCount() - 1);
            colorIzquierda = alternarColor(colorIzquierda);
        }
        else if(llDerecha.getChildCount() > 0)
        {
            llDerecha.removeViewAt(llDerecha.getChildCount() - 1);
            colorDerecha = alternarColor(colorDerecha);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUM_RECTANGULOS_IZQ, llIzquierda.getChildCount());
        outState.putInt(KEY_NUM_RECTANGULOS_DER, llDerecha.getChildCount());
    }
}
