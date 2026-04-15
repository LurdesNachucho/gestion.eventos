package com.gestioneventos.view;

import com.gestioneventos.controller.EventoController;

import javax.swing.*;

public class PanelNuevoEvento extends JPanel {

    public PanelNuevoEvento(EventoController controller) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextField desc = new JTextField();
        JTextField email = new JTextField();
        JTextField fecha = new JTextField();

        JRadioButton daily = new JRadioButton("Daily");
        JRadioButton weekly = new JRadioButton("Weekly");
        JRadioButton monthly = new JRadioButton("Monthly");

        ButtonGroup group = new ButtonGroup();
        group.add(daily);
        group.add(weekly);
        group.add(monthly);

        JCheckBox alarma = new JCheckBox("Alarm");

        JButton guardar = new JButton("Save");

        add(new JLabel("Event description")); add(desc);
        add(new JLabel("Forward e-mail")); add(email);
        add(new JLabel("Date")); add(fecha);
        add(new JLabel("Frequency"));
        add(daily); add(weekly); add(monthly);
        add(alarma);
        add(guardar);

        guardar.addActionListener(e -> {
            String freq = daily.isSelected() ? "DAILY" :
                    weekly.isSelected() ? "WEEKLY" : "MONTHLY";

            controller.registrarEvento(
                    desc.getText(),
                    fecha.getText(),
                    freq,
                    email.getText(),
                    alarma.isSelected()
            );

            JOptionPane.showMessageDialog(this, "Guardado");
        });
    }
}