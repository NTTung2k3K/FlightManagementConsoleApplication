/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author tung
 */
public class Passenger {
    private String name;
    private String seatNumber;
    private String phoneNumber;
    private String citizenIdentificationCartNumber;

    public Passenger(String name, String seatNumber, String phoneNumber, String citizenIdentificationCartNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
        this.phoneNumber = phoneNumber;
        this.citizenIdentificationCartNumber = citizenIdentificationCartNumber;
    }

    public Passenger() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenIdentificationCartNumber() {
        return citizenIdentificationCartNumber;
    }

    public void setCitizenIdentificationCartNumber(String citizenIdentificationCartNumber) {
        this.citizenIdentificationCartNumber = citizenIdentificationCartNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" + "name=" + name + ", seatNumber=" + seatNumber + ", phoneNumber=" + phoneNumber + ", citizenIdentificationCartNumber=" + citizenIdentificationCartNumber + '}';
    }
    public String toStringFile(){
        return name.toUpperCase()+","+phoneNumber+","+citizenIdentificationCartNumber+","+seatNumber.toUpperCase();
    }
    
    
    
}
