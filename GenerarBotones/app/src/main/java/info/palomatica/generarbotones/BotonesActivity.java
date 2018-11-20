package info.palomatica.generarbotones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class BotonesActivity extends AppCompatActivity
{

    private LinearLayout llBotones;
    private int numBotones;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        llBotones = findViewById(R.id.llBotones);

        Intent intent = getIntent();

        numBotones = intent.getIntExtra(MainActivity.KEY_NUMERO, 0);
        for (int i = 0; i < numBotones; i++)
        {
            Button bt = new Button(this);
            bt.setText(getString(R.string.boton) + " " + i);
            bt.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    v.setVisibility(View.INVISIBLE);
                    numBotones--;
                    if(numBotones == 0)
                    {
                        setResult(RESULT_OK);
                        finish();
                    }
                }
            });
            llBotones.addView(bt);

        }

    }
}
