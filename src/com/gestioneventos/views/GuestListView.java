package com.gestioneventos.views;

import com.gestioneventos.controllers.GuestListController;
import com.gestioneventos.core.Model;
import com.gestioneventos.core.View;

import javax.swing.*;
import java.awt.*;


/**
 * View responsible for the list of guests.
 */
public class GuestListView extends JPanel implements View
{
    // Attributes
    @SuppressWarnings("unused")
    private GuestListController guestListController;
    private JTable table;


    // Constructor
    /**
     * It will show the list of saved guests.
     *
     * @param guestListController Controller responsible for this view
     * @param table Table with saved guests
     */
    public GuestListView(GuestListController guestListController, JTable table)
    {
        this.guestListController = guestListController;
        this.table = table;

        make_frame();
    }


    // Methods
    @Override
    public void update(Model model, Object data)
    {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(this, notice);
        }
    }

    /**
     * Creates view's frame.
     */
    private void make_frame()
    {
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}