package info.palomatica.ciclodevida;

import android.content.Context;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int cont = 0;

    private TextView tvNumero;

    private static final String KEY_CONT = "key_contador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("XXX", "onCreate");

        tvNumero = (TextView) findViewById(R.id.tvNumero);

        if(savedInstanceState != null)
        {
            cont = savedInstanceState.getInt(KEY_CONT);
            tvNumero.setText(cont + "");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("XXX", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("XXX", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("XXX", "onResume");
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONT, cont);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("XXX", "onPause - " + cont);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("XXX", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("XXX", "onDestroy");
    }

    public void onClickIncrementar(View view) {
        cont++;
        tvNumero.setText(cont + "");
    }

    public void onClickDecrementar(View view) {
        if(cont > 0)
        {
            cont--;
            tvNumero.setText(cont + "");
        }
        else
        {
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);

            Toast.makeText(this, R.string.yaCero, Toast.LENGTH_SHORT).show();
        }

    }


}
