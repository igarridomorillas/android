package info.palomatica.capitalesdeeuropa.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBPreguntas extends SQLiteOpenHelper
{
    private SQLiteDatabase db;
    private static DBPreguntas dbPreguntas = null;

    public static DBPreguntas getInstance(Context context)
    {
        if(dbPreguntas == null)
        {
            dbPreguntas = new DBPreguntas(context);
        }

        return dbPreguntas;
    }

    private DBPreguntas(Context context)
    {
        super(context, "preguntas.db", null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table preguntas (" +
                "id integer primary key autoincrement," +
                "pregunta text," +
                "correcta text," +
                "incorrecta_1 text," +
                "incorrecta_2 text," +
                "incorrecta_3 text)");



        ContentValues contentValues = new ContentValues();
        contentValues.put("pregunta", "España");
        contentValues.put("correcta", "Madrid");
        contentValues.put("incorrecta_1", "Cuenca");
        contentValues.put("incorrecta_2", "Barcelona");
        contentValues.put("incorrecta_3", "Valencia");

        db.insert("preguntas", null, contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("pregunta", "Francia");
        contentValues2.put("correcta", "París");
        contentValues2.put("incorrecta_1", "Marsella");
        contentValues2.put("incorrecta_2", "Niza");
        contentValues2.put("incorrecta_3", "Albacete");

        db.insert("preguntas", null, contentValues2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public ArrayList<Pregunta> getPreguntas()
    {

        Cursor cursor = db.rawQuery("select id, pregunta, correcta, incorrecta_1, incorrecta_2, incorrecta_3 from preguntas order by id", null );
        ArrayList<Pregunta> alPreguntas = new ArrayList<>(cursor.getCount());

        if(cursor.moveToFirst())
        {
            do
            {
                Pregunta pregunta = new Pregunta(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                alPreguntas.add(pregunta);
            }
            while(cursor.moveToNext());
        }
        return  alPreguntas;
    }

}
