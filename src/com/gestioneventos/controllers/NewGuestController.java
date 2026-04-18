package com.gestioneventos.controllers;

import com.gestioneventos.core.Controller;
import com.gestioneventos.models.Guest;
import com.gestioneventos.models.GuestIO;
import com.gestioneventos.views.RegisterGuestView;


public class NewGuestController extends Controller
{
    // Attributes
    private RegisterGuestView registerGuestView;
    private GuestListController guestListController;


    // Constructor
    public NewGuestController(GuestListController guestListController)
    {
        this.guestListController = guestListController;
    }


    // Methods
    @Override
    public void run()
    {
        registerGuestView = new RegisterGuestView(this);
    }

    /**
     * Registers a guest and saves it to disk.
     *
     * @param name Guest name
     * @param phone Guest phone number
     * @param gender Guest gender
     * @param day Birth day
     * @param month Birth month
     * @param year Birth year
     * @param address Guest address
     * @param acceptedTerms Whether terms were accepted
     */
    public void registerGuest(String name, String phone, String gender,
                              String day, String month, String year,
                              String address, boolean acceptedTerms)
    {
        if (!acceptedTerms) {
            registerGuestView.update(null, "Debe aceptar los Términos y Condiciones.");
            return;
        }

        Guest guest = new Guest();
        guest.setName(name);
        guest.setPhone(phone);
        guest.setGender(gender);
        guest.setBirthDay(day);
        guest.setBirthMonth(month);
        guest.setBirthYear(year);
        guest.setAddress(address);

        Object[] metadata = new Object[7];
        metadata[0] = name;
        metadata[1] = phone;
        metadata[2] = gender;
        metadata[3] = day;
        metadata[4] = month;
        metadata[5] = year;
        metadata[6] = address;

        try {
            GuestIO guestIO = new GuestIO();
            guestIO.attach(registerGuestView);
            guestIO.saveGuest(guest);
        } catch (Exception e) {
            registerGuestView.update(null, "Error al guardar el invitado.");
        }

        guestListController.addNewRow(metadata);
    }


    // Getters
    /**
     * Gets the {@link RegisterGuestView view associated with this controller}.
     *
     * @return View associated with this controller
     */
    public RegisterGuestView getView()
    {
        return registerGuestView;
    }
}