package info.palomatica.colores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private String[] colores;
    private LinearLayout llPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colores = getResources().getStringArray(R.array.colores);

        llPrincipal = findViewById(R.id.llPrincipal);
        LinearLayout llHorizontal;
        TextView tvColor;
        Random random = new Random();
        int iColor;
        for(int i = 0; i < llPrincipal.getChildCount(); i++)
        {
            llHorizontal = (LinearLayout) llPrincipal.getChildAt(i);
            for(int j = 0; j < llHorizontal.getChildCount(); j++)
            {
                tvColor = (TextView) llHorizontal.getChildAt(j);
                iColor = random.nextInt(colores.length);
                tvColor.setBackgroundColor(Color.parseColor(colores[iColor]));
                tvColor.setTag(iColor);
            }
        }
    }

    public void onClickCambiar(View view)
    {
        int iColor = (Integer) view.getTag();
        if(iColor == colores.length - 1)
        {
            iColor = 0;
        }
        else
        {
            iColor++;
        }
        view.setTag(iColor);
        view.setBackgroundColor(Color.parseColor(colores[iColor]));
        if(sonTodosIguales())
        {
            Toast.makeText(this, R.string.sonIguales, Toast.LENGTH_SHORT).show();


        }
    }

    private boolean sonTodosIguales()
    {
        int iColor = (Integer) ((LinearLayout)llPrincipal.getChildAt(0)).getChildAt(0).getTag();
        LinearLayout llHorizontal;
        boolean todosIguales = true;
        for(int i = 0; i < llPrincipal.getChildCount() && todosIguales; i++)
        {
            llHorizontal = (LinearLayout) llPrincipal.getChildAt(i);
            for(int j = 0; j < llHorizontal.getChildCount() && todosIguales; j++)
            {
                if(((Integer)(llHorizontal.getChildAt(j)).getTag()) != iColor)
                {
                    todosIguales = false;
                }
            }
        }
        return todosIguales;
    }
}
