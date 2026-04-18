package com.gestioneventos.controllers;

import com.gestioneventos.core.Controller;
import com.gestioneventos.models.SchedulerIO;
import com.gestioneventos.views.RemoveEventView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * Responsible for {@link RemoveEventView} behavior.
 */
public class RemoveEventController extends Controller
{
    //Attributos
    private RemoveEventView removeEventView;
    private JTable table;
    private EventListController eventListController;

    public RemoveEventController(EventListController eventListController)
    {
        this.eventListController = eventListController;
    }


    //Metodos
    @Override
    public void run()
    {
        table = new JTable(new DefaultTableModel(getDataColumns(), getNameColumns()) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : Object.class;
            }
        });
        removeEventView = new RemoveEventView(this, table);
    }


    public void addNewRow(Object[] values)
    {
        ((DefaultTableModel) table.getModel()).addRow(values);
    }

    public void removeSelectedEvents(JTable table)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try {
            SchedulerIO schedulerIO = new SchedulerIO();
            schedulerIO.attach(removeEventView);
            schedulerIO.removeEvents(getRemainingRows(model));
        } catch (Exception ex) { }

        reloadTable(model);
        eventListController.reloadTable();
    }

    private List<Integer> getRemainingRows(DefaultTableModel model)
    {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (!Boolean.TRUE.equals(model.getValueAt(i, 5))) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private void reloadTable(DefaultTableModel model)
    {
        model.setDataVector(getDataColumns(), getNameColumns());
    }

    public void cancel()
    {
        SwingUtilities.getWindowAncestor(removeEventView).dispose();
    }


    // Getters
    public RemoveEventView getView()
    {
        return removeEventView;
    }

    public Vector<String> getNameColumns()
    {
        Vector<String> nameColumns = new Vector<String>();

        nameColumns.add("Date");
        nameColumns.add("Description");
        nameColumns.add("Frequency");
        nameColumns.add("E-mail");
        nameColumns.add("Alarm");
        nameColumns.add("Boolean");

        return nameColumns;
    }

    public Vector<Vector<Object>> getDataColumns()
    {
        Vector<Vector<Object>> dataColumns = null;

        try {
            SchedulerIO schedulerIO = new SchedulerIO();
            schedulerIO.attach(removeEventView);
            dataColumns = schedulerIO.getEvents();
        } catch (Exception ex) { }

        return dataColumns;
    }
}