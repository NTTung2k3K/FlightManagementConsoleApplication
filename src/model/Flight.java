/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tung
 */
public class Flight {

    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;
    private int maxSeats;
    private ArrayList<CrewMember> listCrewMember = new ArrayList<>();
    private ArrayList<Reservation> listReservations = new ArrayList<>();
    private ArrayList<String> listSeat = new ArrayList<>();
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public ArrayList<String> getListSeat() {
        return listSeat;
    }

    public void setListSeat(ArrayList<String> listSeat) {
        this.listSeat = listSeat;
    }
    

    public ArrayList<Reservation> getListReservations() {
        return listReservations;
    }

    public void setListReservations(ArrayList<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public ArrayList<CrewMember> getListCrewMember() {
        return listCrewMember;
    }

    public void setListCrewMember(ArrayList<CrewMember> listCrewMember) {
        this.listCrewMember = listCrewMember;
    }

    public Flight(String flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats, int maxSeats, String status) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.maxSeats = maxSeats;
        this.status = status;
    }

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departureCity=" + departureCity + ", destinationCity=" + destinationCity + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", availableSeats=" + availableSeats + '}';
    }

    public String toStringFile() {
        return flightNumber.toUpperCase() + ", " + departureCity.toUpperCase() + ", " + destinationCity.toUpperCase() + ", " + departureTime + ", " + arrivalTime + ", "+availableSeats + ", " + maxSeats+", "+status.toUpperCase();
    }

   

}
