package info.palomatica.agenda;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias
{

    private static final String FICHERO_PREFERENCIAS = "prefencias.xml";
    private static Context _context;
    private static SharedPreferences _sharedPreferences;

    public static final int ALFABETICA = 0;
    public static final int CATEGORIA = 1;

    private Preferencias()
    {

    }

    public static void inicializar(Context context)
    {
        if(_context == null)
        {
            _context = context;
            _sharedPreferences = _context.getSharedPreferences(FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);
        }

    }


    public static int getTipoOrdenacion()
    {
        return _sharedPreferences.getInt("tipoOrdenacion", ALFABETICA);
    }

    public static void setTipoOrdenacion(int tipoOrdenacion)
    {
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putInt("tipoOrdenacion", tipoOrdenacion);
        editor.commit();
    }
}
