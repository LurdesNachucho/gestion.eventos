package com.gestioneventos.controllers;

import com.gestioneventos.core.Controller;
import com.gestioneventos.models.GuestIO;
import com.gestioneventos.views.GuestListView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;


public class GuestListController extends Controller
{
    // Attributes
    private GuestListView guestListView;
    private JTable table;


    // Methods
    @Override
    public void run()
    {
        table = new JTable(getDataColumns(), getNameColumns());
        guestListView = new GuestListView(this, table);
    }

    public void addNewRow(Object[] values)
    {
        ((DefaultTableModel) table.getModel()).addRow(values);
    }


    // Getters
    public GuestListView getView()
    {
        return guestListView;
    }

    public Vector<String> getNameColumns()
    {
        Vector<String> nameColumns = new Vector<>();

        nameColumns.add("Nombre");
        nameColumns.add("Celular");
        nameColumns.add("Género");
        nameColumns.add("Día");
        nameColumns.add("Mes");
        nameColumns.add("Año");
        nameColumns.add("Dirección");

        return nameColumns;
    }

    public Vector<Vector<Object>> getDataColumns()
    {
        Vector<Vector<Object>> dataColumns = null;

        try {
            GuestIO guestIO = new GuestIO();
            guestIO.attach(guestListView);
            dataColumns = guestIO.getGuests();
        } catch (Exception ex) { }

        return dataColumns;
    }
}