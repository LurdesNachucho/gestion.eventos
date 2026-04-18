package com.gestioneventos.views;

import com.gestioneventos.controllers.RemoveEventController;
import com.gestioneventos.core.Model;
import com.gestioneventos.core.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveEventView extends JPanel implements View
{
    //-----------------------------------------------------------------------
    //      Attributes
    //-----------------------------------------------------------------------
    private RemoveEventController removeEventController;
    private JTable table;


    //-----------------------------------------------------------------------
    //      Constructor
    //-----------------------------------------------------------------------
    public RemoveEventView(RemoveEventController removeEventController, JTable table)
    {
        this.removeEventController = removeEventController;
        this.table = table;

        make_frame();
        make_table();
        make_btn_selectAll();
        make_btn_cancel();
        make_btn_remove();
    }


    //-----------------------------------------------------------------------
    //      Methods
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data)
    {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(null, notice);
        }
    }

    /**
     * Creates view's frame.
     */
    private void make_frame()
    {
        setLayout(null);
    }

    /**
     * Creates the events table.
     */
    private void make_table()
    {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 470, 170);
        add(scrollPane);
    }

    /**
     * Creates select all button.
     */
    private void make_btn_selectAll()
    {
        JButton btn_selectAll = new JButton("Seleccionar Todos");
        btn_selectAll.setBounds(320, 200, 150, 23);
        add(btn_selectAll);

        btn_selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(true, i, 5); // columna Boolean
                }
            }
        });
    }

    /**
     * Creates cancel button.
     */
    private void make_btn_cancel()
    {
        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(150, 245, 89, 23);
        add(btn_cancel);

        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Uncheck all checkboxes
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(false, i, 5);
                }
            }
        });
    }

    /**
     * Creates remove button.
     */
    private void make_btn_remove()
    {
        JButton btn_remove = new JButton("Remover");
        btn_remove.setBounds(250, 245, 89, 23);
        add(btn_remove);

        btn_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeEventController.removeSelectedEvents(table);
            }
        });
    }
}