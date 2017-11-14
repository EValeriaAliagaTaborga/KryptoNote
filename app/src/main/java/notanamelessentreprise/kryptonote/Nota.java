package notanamelessentreprise.kryptonote;

import android.content.ContentValues;

/**
 * Created by DTIC-123 on 23/03/2017.
 */

public class Nota {

    private String titulo;
    private String nota;
    private String contrasenia;
    private String tituloEncriptado;
    private String notaEncriptada;
    private int id;


    public Nota(String [] nota, int id) {
        this.titulo = nota[0];
        this.nota = nota[1];
        this.tituloEncriptado = nota[2];
        this.notaEncriptada = nota[3];
        this.contrasenia = nota[4];
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTituloEncriptado() {
        return tituloEncriptado;
    }

    public void setTituloEncriptado(String tituloEncriptado) {
        this.tituloEncriptado = tituloEncriptado;
    }

    public String getNotaEncriptada() {
        return notaEncriptada;
    }

    public void setNotaEncriptada(String notaEncriptada) {
        this.notaEncriptada = notaEncriptada;
    }

    public int getId() {
        return id;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(NotaContract.NotaEntry._ID, id);
        values.put(NotaContract.NotaEntry.TITLE, titulo);
        values.put(NotaContract.NotaEntry.NOTE, nota);
        values.put(NotaContract.NotaEntry.PASSWORD, contrasenia);
        values.put(NotaContract.NotaEntry.ENCRYPNOTE, notaEncriptada);
        values.put(NotaContract.NotaEntry.ENCRYPTITLE, tituloEncriptado);

        return values;
    }

    public ContentValues toContentValuesSinId() {
        ContentValues values = new ContentValues();
        values.put(NotaContract.NotaEntry.TITLE, titulo);
        values.put(NotaContract.NotaEntry.NOTE, nota);
        values.put(NotaContract.NotaEntry.PASSWORD, contrasenia);
        values.put(NotaContract.NotaEntry.ENCRYPNOTE, notaEncriptada);
        values.put(NotaContract.NotaEntry.ENCRYPTITLE, tituloEncriptado);

        return values;
    }

}
