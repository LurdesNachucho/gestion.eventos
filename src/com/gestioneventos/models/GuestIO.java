package com.gestioneventos.models;




import com.gestioneventos.core.Model;
import com.gestioneventos.core.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * Responsible for reading / writing guests saved.
 */
public class GuestIO implements Model
{
    // Attributes
    private static final String DIRECTORY = ".";
    private static final String FILE = "guests.txt";
    private List<View> views = new ArrayList<>();
    private String notice;


    // Methods
    @Override
    public void attach(View view)
    {
        views.add(view);
    }

    @Override
    public void detach(View view)
    {
        views.remove(view);
    }

    @Override
    public void notifyViews()
    {
        for (View v : views) {
            v.update(this, notice);
        }
    }

    /**
     * Saves a {@link Guest} in disk in {@link #DIRECTORY}.{@link #FILE}.
     *
     * @param guest {@link Guest} to be saved
     * @throws Exception If it can't save the guest
     */
    public void saveGuest(Guest guest) throws Exception
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORY, FILE), true));
            writer.write(guest.toString(), 0, guest.toString().length());
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException fnfe) {
            notice = "File not found";
            notifyViews();
        } catch (Exception ex) {
            notice = "Error while writing the file";
            notifyViews();
        }
    }


    public Vector<Vector<Object>> getGuests() throws Exception
    {
        Vector<Vector<Object>> response = new Vector<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(DIRECTORY, FILE)));
            String line = reader.readLine();

            while (line != null) {
                Vector<Object> guestInfo = new Vector<>();
                String[] tokens = line.split(";");

                guestInfo.add(tokens[0]); // name
                guestInfo.add(tokens[1]); // phone
                guestInfo.add(tokens[2]); // gender
                guestInfo.add(tokens[3]); // day
                guestInfo.add(tokens[4]); // month
                guestInfo.add(tokens[5]); // year
                guestInfo.add(tokens[6]); // address

                response.add(guestInfo);
                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException fnfe) {
            notice = "File not found";
            notifyViews();
        } catch (Exception ex) {
            notice = "There was a problem reading the guest file";
            notifyViews();
        }

        return response;
    }
}
