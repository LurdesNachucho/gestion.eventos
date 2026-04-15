package com.gestioneventos.view;

import com.gestioneventos.controller.EventoController;

import javax.swing.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Gestión de Eventos");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        EventoController controller = new EventoController();

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("New event", new PanelNuevoEvento(controller));
        tabs.add("Events", new PanelListaEventos(controller));
        tabs.add("Remove Event", new PanelEliminarEvento(controller));
        tabs.add("Registrar invitado", new PanelInvitacion(controller));
        tabs.add("Buscar evento", new PanelBuscarEvento(controller));

        add(tabs);
        setVisible(true);
    }
}