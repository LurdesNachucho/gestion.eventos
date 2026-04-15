package com.gestioneventos.view;
import com.gestioneventos.controller.EventoController;

import javax.swing.*;

public class PanelInvitacion extends JPanel {

    public PanelInvitacion(EventoController controller) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Nombre"));
        add(new JTextField());

        add(new JLabel("Celular"));
        add(new JTextField());

        add(new JButton("Guardar"));
    }
}