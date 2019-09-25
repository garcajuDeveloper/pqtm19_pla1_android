package com.android.pqtm19.juan.frases_fetes.models;

public class Phrase {
    private int id;
    private String text;
    private String Autor;
    private int type;

    public Phrase(int id,String text, String autor, int type) {
        this.id = id;
        this.text = text;
        this.Autor = autor;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAutor() {
        return Autor;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", Autor='" + Autor + '\'' +
                ", type=" + type +
                '}';
    }
}
