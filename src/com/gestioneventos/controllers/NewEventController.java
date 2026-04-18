package com.gestioneventos.controllers;

import javax.swing.JOptionPane;

import com.gestioneventos.core.Controller;
import com.gestioneventos.models.SchedulerEvent;
import com.gestioneventos.models.SchedulerIO;
import com.gestioneventos.views.EventListView;
import com.gestioneventos.views.NewEventView;

import java.text.SimpleDateFormat;


/**
 * Responsible for {@link NewEventView} behavior.
 */
public class NewEventController extends Controller
{
    //-----------------------------------------------------------------------
    //		Attributes
    //-----------------------------------------------------------------------
    private NewEventView newEventView;
    private EventListController eventListController;
    private RemoveEventController removeEventController;


    //-----------------------------------------------------------------------
    //		Constructor
    //-----------------------------------------------------------------------
    /**
     * Responsible for create a {@link SchedulerEvent new event}.
     *
     * @param eventListController {@link EventListController}, because it will
     * add new events created in {@link NewEventView}.
     */
    public NewEventController(EventListController eventListController,RemoveEventController removeEventController)
    {
        this.eventListController = eventListController;
        this.removeEventController = removeEventController;

    }


    //-----------------------------------------------------------------------
    //		Methods
    //-----------------------------------------------------------------------
    @Override
    public void run()
    {
        newEventView = new NewEventView(this);
    }

    /**
     * Creates a new {@link SchedulerEvent} and puts it on {@link EventListView}.
     *
     * @param event Event to be added
     */
    public void addEvent(SchedulerEvent event)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Object[] metadata = new Object[5];
        metadata[0] = sdf.format(event.getDate());
        metadata[1] = event.getEventDesc();
        metadata[2] = event.getFrequency();
        metadata[3] = event.getFwdEmail();
        metadata[4] = event.getAlarm() ? "ON" : "OFF";

        Object[] metadataRemove = new Object[6];
        metadataRemove[0] = sdf.format(event.getDate());
        metadataRemove[1] = event.getEventDesc();
        metadataRemove[2] = event.getFrequency();
        metadataRemove[3] = event.getFwdEmail();
        metadataRemove[4] = event.getAlarm() ? "ON" : "OFF";
        metadataRemove[5] = false;


        try {
            SchedulerIO schedulerIO = new SchedulerIO();
            schedulerIO.attach(newEventView);
            schedulerIO.saveEvent(event);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }


        eventListController.addNewRow(metadata);
        removeEventController.addNewRow(metadataRemove);
    }


    //-----------------------------------------------------------------------
    //		Getters
    //-----------------------------------------------------------------------
    /**
     * Gets the {@link NewEventView view associated with this controller}.
     *
     * @return View associated with this controller
     */
    public NewEventView getView()
    {
        return newEventView;
    }
}
