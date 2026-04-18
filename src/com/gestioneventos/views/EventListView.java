package com.gestioneventos.views;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.gestioneventos.controllers.EventListController;
import com.gestioneventos.core.Model;
import com.gestioneventos.core.View;


/**
 * View responsible for the list of events.
 */
@SuppressWarnings("serial")
public class EventListView extends JPanel implements View
{
    //-----------------------------------------------------------------------
    //		Attributes
    //-----------------------------------------------------------------------
    @SuppressWarnings("unused")
    private EventListController eventListController;
    private JTable table;


    //-----------------------------------------------------------------------
    //		Constructor
    //-----------------------------------------------------------------------
    /**
     * It will show the list of saved events.
     *
     * @param eventListController Controller responsible for this views
     * @param table Table with saved events
     */
    public EventListView(EventListController eventListController, JTable table)
    {
        this.eventListController = eventListController;
        this.table = table;

        make_frame();
    }


    //-----------------------------------------------------------------------
    //		Methods
    //-----------------------------------------------------------------------
    @Override
    public void update(Model model, Object data)
    {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(this, notice);
        }
    }

    /**
     * Creates views's frame.
     */
    private void make_frame()
    {
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
