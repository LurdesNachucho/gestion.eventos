package com.gestioneventos.controller;

import com.gestioneventos.model.*;
import java.util.List;

public class EventoController {

    private EventoDAO dao = new EventoDAO();

    public void registrarEvento(String desc, String fecha, String freq, String email, boolean alarma) {
        dao.agregar(new Evento(0, desc, fecha, freq, email, alarma));
    }

    public List<Evento> listar() {
        return dao.listar();
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public Evento buscar(int id) {
        return dao.buscar(id);
    }
    public void registrarInvitado(String nombre, String celular, String genero, String fecha, String direccion) {
        System.out.println("Invitado:");
        System.out.println(nombre + " - " + celular + " - " + genero + " - " + fecha + " - " + direccion);
    }
}