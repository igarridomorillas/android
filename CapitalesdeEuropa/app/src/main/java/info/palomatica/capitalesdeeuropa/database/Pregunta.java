package info.palomatica.capitalesdeeuropa.database;

public class Pregunta
{
    private int id;
    private String pregunta;
    private String correcta;
    private String incorrecta1;
    private String incorrecta2;
    private String incorrecta3;

    public Pregunta(int id, String pregunta, String correcta, String incorrecta1, String incorrecta2, String incorrecta3)
    {
        this.id = id;
        this.pregunta = pregunta;
        this.correcta = correcta;
        this.incorrecta1 = incorrecta1;
        this.incorrecta2 = incorrecta2;
        this.incorrecta3 = incorrecta3;
    }

    public int getId()
    {
        return id;
    }

    public String getPregunta()
    {
        return pregunta;
    }

    public String getCorrecta()
    {
        return correcta;
    }

    public String getIncorrecta1()
    {
        return incorrecta1;
    }

    public String getIncorrecta2()
    {
        return incorrecta2;
    }

    public String getIncorrecta3()
    {
        return incorrecta3;
    }
}
