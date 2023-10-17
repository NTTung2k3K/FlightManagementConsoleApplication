/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.CrewMember;
import model.Flight;
import model.Reservation;

/**
 *
 * @author tung
 */
public class Validation {

    ArrayList<String> listSeatSelected;

    public Validation() {
        listSeatSelected = new ArrayList<>();
    }

    public boolean hasSpace(String infor) {
        if (infor.trim().contains(" ")) {
            System.out.println("Flight number has space");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFormFlightNumber(String flightNumber) {
        if (flightNumber.matches("^[Ff]\\d{4}$")) {
            return true;
        } else {
            System.out.println("Fligh Number must on the form (Fxxxx) (x: number)");
            return false;
        }
    }

    public boolean isFormCrewMemberId(String flightNumber) {
        if (flightNumber.matches("^[Cc][Mm]\\d{4}$")) {
            return true;
        } else {
            System.out.println("Crew Member Id must on the form (CMxxxx) (x: number)");
            return false;
        }
    }

    public boolean isExistCrewMemberId(String crewMemberId, ArrayList<CrewMember> listCrew) {
        for (CrewMember crewMember : listCrew) {
            if (crewMember.getCrewMemberId().equalsIgnoreCase(crewMemberId)) {
                System.out.println("Crew Member Id is Exist");
                return true;
            }
        }
        return false;
    }

    public boolean isReadyFlight(String reservationId, Flight flight) {
        int quantityPilot = 0;
        int quantiyFlightAttendants = 0;
        int quantityGroundStaff = 0;
        for (CrewMember crew : flight.getListCrewMember()) {
//            System.out.println(crew.toString());
            if (crew.getRole().equalsIgnoreCase("Pilot")) {
                quantityPilot++;
            } else if (crew.getRole().equalsIgnoreCase("Flight attendants")) {
                quantiyFlightAttendants++;
            } else if (crew.getRole().equalsIgnoreCase("Ground staff")) {
                quantityGroundStaff++;
            }
        }
        if (quantityPilot >= 1 && quantityGroundStaff >= 1 && quantiyFlightAttendants >= 1) {
            flight.setStatus("READY");
            return true;
        } else {
            System.out.println("The flight is not ready, Please wait for assign Crew Member ");
            return false;
        }
    }

    public boolean isValidLengthFlightNumber(String flightNumber) {
        if (flightNumber.length() == 5) {
            return true;
        } else {
            System.out.println("Flight Number is not valid length");
            return false;
        }
    }

    public boolean isExistFlightNumber(String flightNumber, ArrayList<Flight> listFlight) {
        for (Flight flight : listFlight) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                System.out.println("Flight Number is Exist");
                return true;
            }
        }
        return false;
    }

    public boolean isValidLength(String infor, int min, int max) {
        if (infor.length() >= min && infor.length() <= max) {
            return true;
        } else {
            System.out.println("Invalid length (Maximum: " + max + " characters)");
            return false;
        }
    }

    public boolean isContainNumber(String infor) {
        if (infor.matches("^[^\\d]+$")) {
            return false;
        } else {
            System.out.println("City name do not contain number");
            return true;
        }
    }

    public boolean isSameDepartureCity(String departureCity, String destinationCity) {
        if (departureCity.equalsIgnoreCase(destinationCity)) {
            System.out.println("Depature City is same Destination City");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFutureTime(LocalDateTime time, LocalDateTime date) {
//        System.out.println("date" + date.getDayOfMonth() + ":" + date.getMonthValue() + ":" + date.getYear());
//        System.out.println("time" + time.getDayOfMonth() + ":" + time.getMonthValue() + ":" + time.getYear());
//        System.out.println("TIME_______");
//        System.out.println("Time:" + time.getHour() + ":" + time.getMinute());
//        System.out.println("Date:" + date.getHour() + ":" + date.getMinute());

//        System.out.println("A "+time.toString());
//        System.out.println("B "+date.toString());
        if (time.isEqual(date) || time.isAfter(date)) {
            return true;
        } else {
            System.out.println("The time is not valid, Please check time again !");

            return false;
        }

    }

    public boolean isFutureDate(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now().plusHours(1);
        if (time.isAfter(now) || time.toLocalDate().isEqual(now.toLocalDate())) {
            return true;
        } else {
            System.out.println("The date is not valid, Please check Date again !");
            return false;
        }

    }

    public boolean isBoundDate(LocalDateTime arrivalDate) {
        int day = arrivalDate.getDayOfMonth();
        int month = arrivalDate.getMonthValue();
        int year = arrivalDate.getYear();
//        30/09/2023
        boolean isLeapYear = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
        if (year >= 1 && month >= 1 && month <= 12) {
            switch (month) {
                case 1: // January
                case 3: // March
                case 5: // May
                case 7: // July
                case 8: // August
                case 10: // October
                case 12: // December
                    return day == 31;
                case 4: // April
                case 6: // June
                case 9: // September
                case 11: // November
                    return day == 30;
                case 2: // February
                    if (isLeapYear) {
                        return day == 29;
                    } else {
                        return day == 28;
                    }
            }
        }
        return false;

    }

    public boolean isArrivalNormalDateBound(LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        System.out.println("Dep" + departureTime.getHour() + ":" + departureTime.getMinute());
//        System.out.println("Dep" + departureTime.getDayOfMonth() + "/" + departureTime.getMonthValue() + "/" + departureTime.getYear());
//        System.out.println("A" + arrivalTime.getHour() + ":" + arrivalTime.getMinute());
//        System.out.println("A" + arrivalTime.getDayOfMonth() + "/" + arrivalTime.getMonthValue() + "/" + arrivalTime.getYear());
//        System.out.println("KET QUA" + isBoundDate(departureTime));
//  09/10/2023 23:59
//  10/10/2023
        if (departureTime.getHour() != 23 || departureTime.getMinute() != 59) {
            return true;
        }
        if (departureTime.getHour() == 23 && departureTime.getMinute() == 59) {
//            int year = 0;
//            int month = 0;
//            int day = 0;
//            if (departureTime.getMonthValue() == 12) {
//                month = 1;
//                year = departureTime.getYear() + 1;
//                day = 1;
//            } else {
//                year = departureTime.getYear();
//                month = departureTime.getMonthValue();
//                day = departureTime.getDayOfMonth() + 1;
//            }
//
//            if (day >= 30) {
//                return false;
//            }

//            System.out.println("VO TOI DAY");
            LocalDateTime nextDay = departureTime.plusDays(1);
//            System.out.println("A" + arrivalTime.getHour() + ":" + arrivalTime.getMinute());
//            System.out.println("A" + arrivalTime.getDayOfMonth() + "/" + arrivalTime.getMonthValue() + "/" + arrivalTime.getYear());
//            System.out.println("C" + nextDay.getHour() + ":" + nextDay.getMinute());
//            System.out.println("C" + nextDay.getDayOfMonth() + "/" + nextDay.getMonthValue() + "/" + nextDay.getYear());
//            System.out.println("W1"+arrivalTime.toLocalDate().isEqual(nextDay.toLocalDate()));
//            System.out.println("W2"+arrivalTime.toLocalDate().isAfter(nextDay.toLocalDate()));
//            System.out.println("F"+(arrivalTime.toLocalDate().isEqual(nextDay.toLocalDate()) || nextDay.toLocalDate().isAfter(arrivalTime.toLocalDate())));
            if (arrivalTime.toLocalDate().isEqual(nextDay.toLocalDate()) == true
                    || arrivalTime.toLocalDate().isAfter(nextDay.toLocalDate()) == true) {
//                System.out.println("VO DAY ROI");
                return true;
            } else {
                System.out.println("TIP: Arrival date must be the next day or earlier");
                return false;
            }

        }
        System.out.println("TIP: Arrival date must be the next day or earlier");
        return false;

    }

    public boolean isArrivalDateBound(LocalDateTime departureTime, LocalDateTime arrivalTime) {
//        System.out.println("Dep" + departureTime.getHour() + ":" + departureTime.getMinute());
//        System.out.println("Dep" + departureTime.getDayOfMonth() + "/" + departureTime.getMonthValue() + "/" + departureTime.getYear());
//        System.out.println("A" + arrivalTime.getHour() + ":" + arrivalTime.getMinute());
//        System.out.println("A" + arrivalTime.getDayOfMonth() + "/" + arrivalTime.getMonthValue() + "/" + arrivalTime.getYear());
//        System.out.println("KET QUA" + isBoundDate(departureTime));
//   true true true
        if ((departureTime.getHour() != 23 || departureTime.getMinute() != 59) && !isBoundDate(departureTime)) {
            return true;
        } else {

            if (departureTime.getHour() == 23 && departureTime.getMinute() == 59 && isBoundDate(departureTime)) {
//                int year = 0;
//                int month = 0;
//                int day = 0;
//                if (departureTime.getMonthValue() == 12) {
//                    month = 1;
//                    year = departureTime.getYear() + 1;
//                    day = 1;
//                } else {
//                    year = departureTime.getYear();
//                    month = departureTime.getMonthValue() + 1;
//                    day = 1;
//                }

//            System.out.println("VO TOI DAY");
                LocalDateTime nextDay = departureTime.plusDays(1);
//            System.out.println("C" + checkDay.getHour() + ":" + checkDay.getMinute());
//            System.out.println("C" + checkDay.getDayOfMonth() + "/" + checkDay.getMonthValue() + "/" + checkDay.getYear());
//            System.out.println(arrivalTime.isEqual(checkDay));
//            System.out.println(arrivalTime.isAfter(checkDay));
// 01/11/2023
                if (arrivalTime.toLocalDate().isEqual(nextDay.toLocalDate()) || arrivalTime.toLocalDate().isAfter(nextDay.toLocalDate())) {
                    System.out.println("Arrival date must be greater than " + departureTime.getDayOfMonth() + "/" + departureTime.getMonthValue() + "/"
                            + departureTime.getYear() + " " + departureTime.getHour() + ":" + departureTime.getMinute()
                    );
                    return true;
                }
            }
        }
        System.out.println("Arrival date must be greater than " + departureTime.getDayOfMonth() + "/" + departureTime.getMonthValue() + "/"
                + departureTime.getYear() + " " + departureTime.getHour() + ":" + departureTime.getMinute()
        );
        return false;
    }

//    30/09/2023 23:59 departure time
    public boolean isArrivalDate(LocalDateTime departureTime, LocalDateTime arrivalTime) {
        LocalDateTime max = departureTime.plusHours(20);
//        13/10/2023 23:59
//        14/10/2023 20:00
//        System.out.println(arrivalTime);
//        System.out.println(max);

        if ((arrivalTime.toLocalDate().isEqual(departureTime.toLocalDate())
                || (arrivalTime.isAfter(departureTime) && arrivalTime.isBefore(max)))) {
            return true;
        } else {
            System.out.println("Arrival Date must be within 20 hours of Departure Date.");
            return false;
        }

    }

    public boolean isArrivalTime(LocalDateTime departureTime, LocalDateTime arrivalTime) {

//        System.out.println("Dep" +departureTime.getHour()+":"+departureTime.getMinute());
//                System.out.println("A" +arrivalTime.getHour()+":"+arrivalTime.getMinute());
//departureTime.getDayOfMonth() == arrivalTime.getDayOfMonth()
//                && departureTime.getMonthValue() == arrivalTime.getMonthValue()
//                && departureTime.getYear() == arrivalTime.getYear() &&    
        LocalDateTime max = departureTime.plusHours(20).plusMinutes(1);
//        10/12/2023 10h  <->  11/12/2023 16h 
//        System.out.println("A " + max.toString());
//        System.out.println("B " + arrivalTime.toString());
//        System.out.println("C " + (arrivalTime.isAfter(departureTime)));
//        System.out.println("D " + arrivalTime.isBefore(max));

        if (arrivalTime.isAfter(departureTime) && arrivalTime.isBefore(max)) {
            return true;

        } else {
            System.out.println("Arrival Time must be within 20 hours of Departure Date.");
            return false;
        }

    }

    public boolean isAvailableSeat(int seatQuantity) {
        if (seatQuantity >= 1 && seatQuantity <= 168) {
            return true;
        } else {
            System.out.println("The seat is Valid in range (1-168)");
            return false;
        }
    }

    public ArrayList searchFlight(String departureCity, String arrivalCity, LocalDateTime date, ArrayList<Flight> listFlight) {
        ArrayList<Flight> listResult = new ArrayList<>();
        LocalDateTime plusOne = date.plusDays(1);
        LocalDateTime plusTwo = date.plusDays(2);
        LocalDateTime plusThree = date.plusDays(3);
        LocalDateTime minusOne = date.minusDays(1);
        LocalDateTime minusTwo = date.minusDays(1);
        LocalDateTime minusThree = date.minusDays(1);
//        System.out.println("L"+"lao".contains("o"));
        for (Flight flight : listFlight) {
            if (flight.getDepartureCity().toUpperCase().contains(departureCity.toUpperCase())
                    || flight.getDepartureCity().equalsIgnoreCase(departureCity)
                    || flight.getDepartureCity().toUpperCase().startsWith(departureCity.toUpperCase())
                    || flight.getDepartureCity().toUpperCase().endsWith(departureCity.toUpperCase()) //                    || flight.getDestinationCity().toUpperCase().startsWith(departureCity.toUpperCase())
                    //                    || flight.getDestinationCity().toUpperCase().endsWith(departureCity.toUpperCase())
                    //                    || flight.getDestinationCity().toUpperCase().contains(arrivalCity.toUpperCase())
                    //                    || flight.getDestinationCity().equalsIgnoreCase(arrivalCity)
                    //                    || flight.getDestinationCity().toUpperCase().startsWith(arrivalCity.toUpperCase())
                    //                    || flight.getDestinationCity().toUpperCase().endsWith(arrivalCity.toUpperCase())
                    //                    || flight.getDepartureCity().toUpperCase().startsWith(arrivalCity.toUpperCase())
                    //                    || flight.getDepartureCity().toUpperCase().endsWith(arrivalCity.toUpperCase())
                    ) {
//                System.out.println("1"+flight.getDepartureTime().toLocalDate());
//                System.out.println("2"+plusOne.toLocalDate());
//                System.out.println("T?"+flight.getDepartureTime().toLocalDate().equals(plusOne.toLocalDate()));
                LocalDate flightDepartureDate = flight.getDepartureTime().toLocalDate();
                LocalDate inputDate = date.toLocalDate();

                LocalDate flightArrivalDate = flight.getArrivalTime().toLocalDate();

                long daysDifference = ChronoUnit.DAYS.between(inputDate, flightDepartureDate);
                long arrivalDaysDifferences = ChronoUnit.DAYS.between(inputDate, flightArrivalDate);
//                System.out.println("AD"+arrivalDaysDifferences);
//                System.out.println("FA"+flightArrivalDate);
//                System.out.println("IN"+inputDate);
                if ((arrivalDaysDifferences >= -3 && arrivalDaysDifferences <= 3) || (daysDifference >= -3 && daysDifference <= 3) && flight.getAvailableSeats() >= 0) {
                    listResult.add(flight);
                }

            }
        }

        if (listResult.isEmpty()) {
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("+                             List Flight                               +");
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("+                                                                       +");
            System.out.println("+                            No Flight Found                            +");
            System.out.println("+                                                                       +");
            System.out.println("+-----------------------------------------------------------------------+");
            return null;
        } else {

            Collections.sort(listResult, new Comparator<Flight>() {
                @Override
                public int compare(Flight o1, Flight o2) {
                    return o1.getDepartureTime().toLocalDate().compareTo(o2.getDepartureTime().toLocalDate());
                }
            });
            int i = 0;

            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                     List Flight                                                                             +");
            System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
            System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
            System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
            i = 0;
            for (Flight flight : listResult) {
                System.out.println(String.format("+%8d|%15s|%22s|%22s|%20s|%18s|%18s|%13s|%12s +", ++i, flight.getFlightNumber(), flight.getDepartureCity().toUpperCase(), flight.getDestinationCity().toUpperCase(),
                        flight.getDepartureTime().toString(), flight.getArrivalTime().toString(), flight.getAvailableSeats(), flight.getMaxSeats(), flight.getStatus().toUpperCase()));
            }
            System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");

        }

        return listResult;
    }

    public Reservation isExistReservationId(String reservationId, ArrayList<Reservation> listReservation) {
        for (Reservation reservation : listReservation) {
            if (reservation.getReservationId().equalsIgnoreCase(reservationId)) {
                return reservation;
            }
        }
        return null;
    }

    public String generateBoardingPasses(Reservation reservation) {
        System.out.println("+------------------+------------------------+");
        System.out.println("+                Boarding Pass              +");
        System.out.println("+------------------+------------------------+");
        System.out.print("+       Name       +" + String.format(" %22s +\n", reservation.getPassenger().getName().toUpperCase()));
        System.out.print("+   Phone Number   +" + String.format(" %22s +\n", reservation.getPassenger().getPhoneNumber()));
        System.out.print("+  ID Cart Number  +" + String.format(" %22s +\n", reservation.getPassenger().getCitizenIdentificationCartNumber()));
        System.out.print("+   Fligh Number   +" + String.format(" %22s +\n", reservation.getFlight().getFlightNumber().toUpperCase()));
        System.out.print("+  Departure City  +" + String.format(" %22s +\n", reservation.getFlight().getDepartureCity().toUpperCase()));
        System.out.print("+ Destination City +" + String.format(" %22s +\n", reservation.getFlight().getDestinationCity().toUpperCase()));
        System.out.print("+  Departure Time  +" + String.format(" %22s +\n", reservation.getFlight().getDepartureTime().toString()));
        System.out.print("+   Arrivale Time  +" + String.format(" %22s +\n", reservation.getFlight().getArrivalTime().toString()));
        System.out.print("+   Seat Number    +" + String.format(" %22s +\n", reservation.getPassenger().getSeatNumber().toUpperCase()));
        System.out.print("+   ReservationId  +" + String.format(" %22s +\n", reservation.getReservationId()));

        System.out.println("+------------------+------------------------+");

        String infor;
        infor = reservation.getPassenger().getName().toUpperCase() + "\n";
        infor += reservation.getPassenger().getPhoneNumber() + "\n";
        infor += reservation.getPassenger().getCitizenIdentificationCartNumber() + "\n";
        infor += reservation.getFlight().getFlightNumber().toUpperCase() + "\n";
        infor += reservation.getFlight().getDepartureCity().toUpperCase() + "\n";
        infor += reservation.getFlight().getDestinationCity().toUpperCase() + "\n";
        infor += reservation.getFlight().getDepartureTime() + "\n";
        infor += reservation.getFlight().getArrivalTime() + "\n";
        infor += reservation.getPassenger().getSeatNumber().toUpperCase();
        return infor;
    }

    public boolean isRangeCheckIn(Reservation reservation) {
        LocalDateTime timeLimit
                = reservation.getFlight().
                        getDepartureTime().
                        minusHours(3).
                        minusSeconds(1);
//        System.out.println("T "+timeLimit.toString());
//        System.out.println("S "+LocalDateTime.now());
//        System.out.println("H "+reservation.getFlight().getDepartureTime().toString());
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime departureTime = reservation.getFlight().getDepartureTime();
        if (currentTime.isAfter(timeLimit) && currentTime.isBefore(departureTime)) {
            return true;
        } else if (currentTime.isBefore(timeLimit)) {
            System.out.println("Your check-in must in range " + timeLimit.toLocalDate() + " | " + timeLimit.toLocalTime() + " to " + reservation.getFlight().getDepartureTime().toLocalDate().toString() + " | " + reservation.getFlight().getDepartureTime().toLocalTime().toString());
            return false;
        } else {
            System.out.println("You're late for your flight");
            return false;
        }

    }

    public boolean isExistPhoneNumber(String phone, ArrayList<Reservation> listReservations) {
        for (Reservation reservation : listReservations) {

            if ((!reservation.getStatus().equalsIgnoreCase("DONE")) && reservation.getPassenger().getPhoneNumber().equalsIgnoreCase(phone)) {
                System.out.println("EXIST Phone Number");
                return true;
            }
        }
        return false;
    }

    public boolean isExistCID(String CID, ArrayList<Reservation> listReservations) {
        for (Reservation reservation : listReservations) {
            if ((!reservation.getStatus().equalsIgnoreCase("DONE")) && reservation.getPassenger().getCitizenIdentificationCartNumber().equalsIgnoreCase(CID)) {
                System.out.println("EXIST Citizen identification");
                return true;
            }
        }
        return false;
    }

    public String displaySeatsAvailable(Flight flight, ArrayList<Reservation> listReservation) {
        char[] rows = new char[26];
        for (int i = 0; i < 26; i++) {
            rows[i] = (char) ('A' + i);
        }
        int totalAvailableSeats = flight.getMaxSeats();
        int maxSeatsPerRow = 8;
        int seat = 0;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 0; i < rows.length && seat < totalAvailableSeats; i++) {
            for (int j = 1; j <= maxSeatsPerRow && seat < totalAvailableSeats; j++) {
                boolean seatSold = false;

//                for (Reservation reservation : listReservation) {
//                    if (reservation.getFlight() == flight && reservation.getPassenger().getSeatNumber().equalsIgnoreCase("" + rows[i] + j)) {
//                        System.out.print("SOLD\t");
//                        seatSold = true;
//                        break;
//                    }
//                }
                for (String string : flight.getListSeat()) {
                    if (string.equalsIgnoreCase("" + rows[i] + j)) {
                        System.out.print("SOLD\t");
                        seatSold = true;
                        break;
                    }
                }

                if (!seatSold) {
                    System.out.print("" + rows[i] + j + "\t");
                }

                seat++;

            }
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Tool tool = new Tool();
        boolean flag = true;
        String seatSelected = tool.inputString("Please choose a seat:");
//        CAN BAT LOI INPUT afsdf cung nhan

//        if (isValidSeat(seatSelected, listReservation, flight)) {
//            if (isSold(seatSelected, flight, listReservation) == false) {
//                if (isSameSeat(seatSelected, listSeatSelected) == false) {
//                    System.out.println("Select seat succesfully");
//                    listSeatSelected.add(seatSelected);
//                }
//            }
        if (isValidSeat(seatSelected, listReservation, flight)
                && (isSold(seatSelected, flight, listReservation) == false)
                && (isSameSeat(seatSelected, flight) == false)) {
            System.out.println("Select seat succesfully");
            listSeatSelected.add(seatSelected);

        } else {
            do {
                System.out.println("Your seat is not available");
                seatSelected = tool.inputString("Please choose a seat:");
                if (isValidSeat(seatSelected, listReservation, flight)
                        && (isSold(seatSelected, flight, listReservation) == false)
                        && (isSameSeat(seatSelected, flight) == false)) {
                    System.out.println("Select seat succesfully");
                    listSeatSelected.add(seatSelected);
                    flag = false;
                } else {
                    flag = true;
                }
            } while (flag);
        }
//        System.out.println("SIZE "+listSeatSelected.size());

//        DO WHILE HERE
        return seatSelected;
    }

    public boolean isSameSeat(String seatSelect, Flight flight) {

        for (String string : flight.getListSeat()) {
            if (string.equalsIgnoreCase(seatSelect)) {
                System.out.println("Seat has been selected");

                return true;
            }
        }

//        for (Reservation reservation : listReservation) {
//            if (reservation.getFlight().equals(flight)&& reservation.getPassenger().getSeatNumber().equalsIgnoreCase(seatSelect) )) {
//                System.out.println("Seat has been selected");
//                return true;
//            }
//        }
        return false;
    }

    public boolean isValidSeat(String seatSelecte, ArrayList<Reservation> listReservation, Flight flight) {
        char[] rows = new char[26];
        for (int i = 0; i < 26; i++) {
            rows[i] = (char) ('A' + i);
        }
        int totalAvailableSeats = flight.getMaxSeats();
        int maxSeatsPerRow = 8;
        int seat = 0;

        for (int i = 0; i < rows.length && seat < totalAvailableSeats; i++) {
            for (int j = 1; j <= maxSeatsPerRow && seat < totalAvailableSeats; j++) {
                if (seatSelecte.equalsIgnoreCase("" + rows[i] + j)) {
                    return true;
                }
                seat++;

            }
        }
        return false;
    }

    public boolean isSold(String seatNumber, Flight flight, ArrayList<Reservation> listReservation) {
        for (Reservation reservation : listReservation) {
            if (reservation.getFlight() == flight && reservation.getPassenger().getSeatNumber().equalsIgnoreCase(seatNumber)) {
                System.out.println("Seat has been selected !");
                return true;
            }
        }
        return false;
    }

    public boolean isSelectSeat(Reservation reservation, ArrayList<Reservation> listReservation) {
        for (Reservation reservation1 : listReservation) {

            if (reservation.getStatus().equalsIgnoreCase("DONE")) {
                System.out.println("You has Check-in succesfully");
                return true;
            }
        }
        return false;
    }
}
