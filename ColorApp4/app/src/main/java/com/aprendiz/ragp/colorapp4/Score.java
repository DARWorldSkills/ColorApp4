package com.aprendiz.ragp.colorapp4;

public class Score {
    private int puntaje;
    private int incorrectas;

    public Score() {
    }

    public Score(int puntaje, int incorrectas) {
        this.puntaje = puntaje;
        this.incorrectas = incorrectas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getIncorrectas() {
        return incorrectas;
    }

    public void setIncorrectas(int incorrectas) {
        this.incorrectas = incorrectas;
    }
}
