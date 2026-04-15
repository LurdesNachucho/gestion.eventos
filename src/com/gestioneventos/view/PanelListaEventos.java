package com.gestioneventos.view;

import com.gestioneventos.controller.EventoController;
import com.gestioneventos.model.Evento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelListaEventos extends JPanel {

    private DefaultTableModel model;

    public PanelListaEventos(EventoController controller) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] cols = {"ID","Date","Description","Frequency","E-mail","Alarm"};
        model = new DefaultTableModel(cols, 0);

        JTable tabla = new JTable(model);

        JButton refresh = new JButton("Actualizar");

        refresh.addActionListener(e -> {
            model.setRowCount(0);
            for (Evento ev : controller.listar()) {
                model.addRow(new Object[]{
                        ev.getId(),
                        ev.getFecha(),
                        ev.getDescripcion(),
                        ev.getFrecuencia(),
                        ev.getEmail(),
                        ev.isAlarma()
                });
            }
        });

        add(new JScrollPane(tabla));
        add(refresh);
    }
}