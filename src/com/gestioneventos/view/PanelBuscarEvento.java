package com.gestioneventos.view;

import com.gestioneventos.controller.EventoController;
import com.gestioneventos.model.Evento;

import javax.swing.*;

public class PanelBuscarEvento extends JPanel {

    public PanelBuscarEvento(EventoController controller) {

        JTextField id = new JTextField();
        JButton buscar = new JButton("Buscar");

        add(new JLabel("ID"));
        add(id);
        add(buscar);

        buscar.addActionListener(e -> {
            Evento ev = controller.buscar(Integer.parseInt(id.getText()));

            if (ev != null) {
                JOptionPane.showMessageDialog(this, ev.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(this, "No encontrado");
            }
        });
    }
}