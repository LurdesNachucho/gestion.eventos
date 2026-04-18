package com.gestioneventos.models;


/**
 * Represents a guest.
 */
public class Guest
{
    // Attributes
    private String name;
    private String phone;
    private String gender;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String address;


    // Methods
    @Override
    public String toString()
    {
        return name + ";" + phone + ";" + gender + ";" +
                birthDay + ";" + birthMonth + ";" + birthYear + ";" + address;
    }


    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthDay() { return birthDay; }
    public void setBirthDay(String birthDay) { this.birthDay = birthDay; }

    public String getBirthMonth() { return birthMonth; }
    public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }

    public String getBirthYear() { return birthYear; }
    public void setBirthYear(String birthYear) { this.birthYear = birthYear; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}