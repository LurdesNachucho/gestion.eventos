package com.gestioneventos.model;

import java.util.*;

public class EventoDAO {

    private List<Evento> eventos = new ArrayList<>();
    private int id = 1;

    public void agregar(Evento e) {
        eventos.add(new Evento(id++, e.getDescripcion(), e.getFecha(),
                e.getFrecuencia(), e.getEmail(), e.isAlarma()));
    }

    public List<Evento> listar() {
        return eventos;
    }

    public void eliminar(int id) {
        eventos.removeIf(e -> e.getId() == id);
    }

    public Evento buscar(int id) {
        return eventos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}