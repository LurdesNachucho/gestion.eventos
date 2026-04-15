package com.gestioneventos.view;

import com.gestioneventos.controller.EventoController;

import javax.swing.*;

public class PanelEliminarEvento extends JPanel {

    public PanelEliminarEvento(EventoController controller) {

        JTextField id = new JTextField();

        JButton eliminar = new JButton("Remove");

        add(new JLabel("ID evento"));
        add(id);
        add(eliminar);

        eliminar.addActionListener(e -> {
            controller.eliminar(Integer.parseInt(id.getText()));
            JOptionPane.showMessageDialog(this, "Eliminado");
        });
    }
}