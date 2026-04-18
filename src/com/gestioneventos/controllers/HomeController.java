package com.gestioneventos.controllers;

import com.gestioneventos.core.Controller;
import com.gestioneventos.views.*;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller
{
    //-----------------------------------------------------------------------
    //		Attributes
    //-----------------------------------------------------------------------
    private HomeView homeView;
    private EventListController eventListController = new EventListController();
    private RemoveEventController removeEventController = new RemoveEventController(eventListController);
    private NewEventController newEventController = new NewEventController(eventListController,removeEventController);
    private GuestListController guestListController = new GuestListController();
    private NewGuestController newGuestController = new NewGuestController(guestListController);


    //-----------------------------------------------------------------------
    //		Methods
    //-----------------------------------------------------------------------
    @Override
    public void run()
    {
        // Initializes others controllers
        eventListController.run();
        newEventController.run();
        removeEventController.run();
        newGuestController.run();
        guestListController.run();


        // Initializes HomeView
        homeView = new HomeView(this, mainFrame);
        addView("HomeView", homeView);

        // Displays the program window
        mainFrame.setVisible(true);
    }


    //-----------------------------------------------------------------------
    //		Getters
    //-----------------------------------------------------------------------
    public EventListView getEventListView()
    {
        return eventListController.getView();
    }

    public NewEventView getNewEventView()
    {
        return newEventController.getView();
    }

    public RemoveEventView getRemoveEventView()
    {
        return removeEventController.getView();
    }

    public RegisterGuestView getRegisterGuestView()
    {
        return newGuestController.getView();
    }

    public GuestListView getGuestListView()
    {
        return guestListController.getView();
    }
}
