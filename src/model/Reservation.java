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
public class Reservation {

    private String reservationId;
    private Passenger passenger;
    private Flight flight;
    private String status;

    public Reservation() {
    }

    public Reservation(String reservationId, Passenger passenger, Flight flight, String status) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return flight.getListSeat().size()+" Reservation{" + "reservationId=" + reservationId + ", passenger=" + passenger.toString() + ", flight=" + flight.toString() + ", status=" + status + '}';
    }

   
    public String toFileString() {
        return reservationId+", "+passenger.getName().toUpperCase()+", "+passenger.getPhoneNumber()+", "+passenger.getCitizenIdentificationCartNumber()+", "+
                passenger.getSeatNumber().toUpperCase()+", "+flight.getFlightNumber().toUpperCase()+", "+status.toUpperCase();
    }

    
    

}
