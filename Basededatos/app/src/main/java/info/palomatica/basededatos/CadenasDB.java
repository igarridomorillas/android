package info.palomatica.basededatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CadenasDB extends SQLiteOpenHelper
{
    private SQLiteDatabase db;

    private static CadenasDB cadenasDB = null;

    public static CadenasDB getInstance(Context contex)
    {
        if(cadenasDB == null)
        {
            cadenasDB = new CadenasDB(contex);
        }
        return cadenasDB;
    }

    private CadenasDB(Context context)
    {
        super(context, "cadenas.db", null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE textos (_id INTEGER PRIMARY KEY AUTOINCREMENT, texto TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    /**
     *
     * @param cadena
     * @return true si se inserta, false si ya existía
     */
    public boolean insertarCadena(String cadena)
    {
        // Buscar la cadena texto en la tabla
        Cursor cursor = db.rawQuery("select _id from textos where texto = '" + cadena + "'", null);
        if(cursor.moveToFirst())
        {
            return false;
        }
        else // No existe
        {
            db.execSQL("insert into textos (texto) values ('" + cadena + "')");
            return true;
        }
    }

    public void eliminarCadena(String cadena)
    {
        db.execSQL("delete from textos where texto = '" + cadena + "'");
    }

    public ArrayList<String> getCadenas()
    {
        Cursor cursor = db.rawQuery("select _id, texto from textos order by _id", null);
        ArrayList<String> alCadenas = new ArrayList<String>(cursor.getCount());
        if(cursor.moveToFirst())
        {
            do
            {
                alCadenas.add(cursor.getString(1));
            }
            while(cursor.moveToNext());
        }
        return alCadenas;
    }

}
