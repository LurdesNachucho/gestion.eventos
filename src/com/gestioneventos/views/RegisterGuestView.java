package com.gestioneventos.views;

import com.gestioneventos.controllers.NewGuestController;
import com.gestioneventos.core.Model;
import com.gestioneventos.core.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * View responsible for registering a guest.
 */
public class RegisterGuestView extends JPanel implements View
{
    // Attributes
    private NewGuestController newGuestController;
    private JTextField tf_name;
    private JTextField tf_phone;
    private JTextField tf_address;
    private JRadioButton rbtn_male;
    private JRadioButton rbtn_female;
    private JComboBox<Integer> cmb_day;
    private JComboBox<String> cmb_month;
    private JComboBox<Integer> cmb_year;
    private JCheckBox cbx_terms;


    // Constructor
    /**
     * @param newGuestController Controller of this view
     */
    public RegisterGuestView(NewGuestController newGuestController)
    {
        this.newGuestController = newGuestController;

        make_frame();
        make_field_name();
        make_field_phone();
        make_field_gender();
        make_field_birthdate();
        make_field_address();
        make_field_terms();
        make_btn_save();
        make_btn_clean();
    }


    // Methods
    @Override
    public void update(Model model, Object data)
    {
        if (data != null) {
            String notice = (String) data;
            JOptionPane.showMessageDialog(null, notice);
        }
    }

    /**
     * Resets all fields.
     */
    private void cleanFields()
    {
        tf_name.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        rbtn_male.setSelected(true);
        cmb_day.setSelectedIndex(0);
        cmb_month.setSelectedIndex(0);
        cmb_year.setSelectedItem(1995);
        cbx_terms.setSelected(false);
    }

    /**
     * Creates view's frame.
     */
    private void make_frame()
    {
        setLayout(null);
    }

    /**
     * Creates name field.
     */
    private void make_field_name()
    {
        // Makes label
        JLabel lbl_name = new JLabel("Ingrese Nombre:");
        lbl_name.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_name.setBounds(29, 29, 150, 14);
        add(lbl_name);

        // Makes text field
        tf_name = new JTextField();
        tf_name.setBounds(200, 26, 196, 20);
        tf_name.setColumns(10);
        add(tf_name);
    }

    /**
     * Creates phone field.
     */
    private void make_field_phone()
    {
        // Makes label
        JLabel lbl_phone = new JLabel("Ingrese número celular:");
        lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_phone.setBounds(29, 64, 165, 14);
        add(lbl_phone);

        // Makes text field
        tf_phone = new JTextField();
        tf_phone.setBounds(200, 61, 196, 20);
        tf_phone.setColumns(10);
        add(tf_phone);
    }

    /**
     * Creates gender field.
     */
    private void make_field_gender()
    {
        final ButtonGroup btng_gender = new ButtonGroup();

        // Makes label
        JLabel lbl_gender = new JLabel("Género:");
        lbl_gender.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_gender.setBounds(29, 99, 78, 14);
        add(lbl_gender);

        // Male option
        rbtn_male = new JRadioButton("Masculino");
        btng_gender.add(rbtn_male);
        rbtn_male.setSelected(true);
        rbtn_male.setBounds(200, 95, 90, 23);
        add(rbtn_male);

        // Female option
        rbtn_female = new JRadioButton("Femenino");
        btng_gender.add(rbtn_female);
        rbtn_female.setBounds(300, 95, 90, 23);
        add(rbtn_female);
    }

    /**
     * Creates birthdate field.
     */
    private void make_field_birthdate()
    {
        // Makes label
        JLabel lbl_birthdate = new JLabel("Fecha de Nacimiento:");
        lbl_birthdate.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_birthdate.setBounds(29, 139, 160, 14);
        add(lbl_birthdate);

        // Day combo
        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) days[i] = i + 1;
        cmb_day = new JComboBox<>(days);
        cmb_day.setBounds(200, 135, 55, 23);
        add(cmb_day);

        // Month combo
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun",
                "Jul","Aug","Sep","Oct","Nov","Dec"};
        cmb_month = new JComboBox<>(months);
        cmb_month.setBounds(262, 135, 65, 23);
        add(cmb_month);

        // Year combo
        Integer[] years = new Integer[100];
        for (int i = 0; i < 100; i++) years[i] = 1924 + i;
        cmb_year = new JComboBox<>(years);
        cmb_year.setSelectedItem(1995);
        cmb_year.setBounds(334, 135, 65, 23);
        add(cmb_year);
    }

    /**
     * Creates address field.
     */
    private void make_field_address()
    {
        // Makes label
        JLabel lbl_address = new JLabel("Dirección:");
        lbl_address.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_address.setBounds(29, 179, 78, 14);
        add(lbl_address);

        // Makes text field
        tf_address = new JTextField();
        tf_address.setBounds(200, 176, 196, 20);
        tf_address.setColumns(10);
        add(tf_address);
    }

    /**
     * Creates terms and conditions checkbox.
     */
    private void make_field_terms()
    {
        cbx_terms = new JCheckBox("Acepta Términos y Condiciones");
        cbx_terms.setBounds(29, 215, 250, 23);
        add(cbx_terms);
    }

    /**
     * Creates save button.
     */
    private void make_btn_save()
    {
        // Makes button
        JButton btn_save = new JButton("Save");
        btn_save.setBounds(127, 250, 89, 23);
        add(btn_save);

        // Add action listener
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGuestController.registerGuest(
                        tf_name.getText(),
                        tf_phone.getText(),
                        rbtn_male.isSelected() ? "Masculino" : "Femenino",
                        cmb_day.getSelectedItem().toString(),
                        cmb_month.getSelectedItem().toString(),
                        cmb_year.getSelectedItem().toString(),
                        tf_address.getText(),
                        cbx_terms.isSelected()
                );
                cleanFields();
            }
        });
    }

    /**
     * Creates clean button.
     */
    private void make_btn_clean()
    {
        // Makes button
        JButton btn_clean = new JButton("Clean");
        btn_clean.setBounds(253, 250, 89, 23);
        add(btn_clean);

        // Add action listener
        btn_clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanFields();
            }
        });
    }
}