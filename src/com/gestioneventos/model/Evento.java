package com.gestioneventos.model;

public class Evento {
    private int id;
    private String descripcion;
    private String fecha;
    private String frecuencia;
    private String email;
    private boolean alarma;

    public Evento(int id, String descripcion, String fecha, String frecuencia, String email, boolean alarma) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.frecuencia = frecuencia;
        this.email = email;
        this.alarma = alarma;
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public String getFrecuencia() { return frecuencia; }
    public String getEmail() { return email; }
    public boolean isAlarma() { return alarma; }
}