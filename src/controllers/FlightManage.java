/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import model.CrewMember;
import model.Flight;
import model.Passenger;
import model.Reservation;
import view.Menu;

/**
 *
 * @author tung
 */
public class FlightManage {

    ArrayList<Flight> listFlight;
    Tool tool;
    Validation validation;
    ArrayList<String> asking;
    Menu menu;
    ArrayList<Reservation> listReservation;
    ArrayList<CrewMember> listCrewMember;

    public FlightManage() {
        validation = new Validation();
        listFlight = new ArrayList<>();
        asking = new ArrayList<>();
        listReservation = new ArrayList<>();
        tool = new Tool();
        menu = new Menu();
        listCrewMember = new ArrayList<>();
        asking.add("YES");
        asking.add("NO");
//           for test 
//       Flight is not ready
        Flight f2 = new Flight("F0838", "Bangkok", "HaNoi", LocalDateTime.of(2023, 10, 17, 9, 20), LocalDateTime.of(2023, 10, 17, 11, 00), 100, 100, "NOT READY");
        listFlight.add(f2);
        f2 = new Flight("F0839", "Taiwan", "HaNoi", LocalDateTime.of(2023, 10, 17, 8, 30), LocalDateTime.of(2023, 10, 17, 13, 00), 50, 50, "NOT READY");
        listFlight.add(f2);

        
//        Flight is ready
        Flight f = new Flight("F0820", "Bangkok", "HoChiMinh", LocalDateTime.of(2023, 10, 17, 8, 35), LocalDateTime.of(2023, 10, 17, 12, 00), 30, 30, "READY");

        CrewMember c = new CrewMember("CM0001", f, "Pilot", "Adam", 2, 29, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM0002", f, "Flight attendants", "Glory", 2, 23, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM0003", f, "Ground staff", "Sparda", 1, 20, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        listFlight.add(f);

//        test
        f = new Flight("F0850", "Bangkok", "Hanoi", LocalDateTime.of(2023, 10, 17, 06, 35), LocalDateTime.of(2023, 10, 17, 10, 00), 90, 90, "READY");

        c = new CrewMember("CM9991", f, "Pilot", "Binz", 2, 29, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM9992", f, "Flight attendants", "Clear", 2, 23, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM9993", f, "Ground staff", "BRB", 1, 20, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        listFlight.add(f);

        f = new Flight("F0852", "Singapore", "DaNang", LocalDateTime.of(2023, 10, 17, 21, 35), LocalDateTime.of(2023, 10, 17, 23, 00), 100, 100, "READY");

        c = new CrewMember("CM2221", f, "Pilot", "Kidz", 2, 29, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM2222", f, "Flight attendants", "Hasmed", 2, 23, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM2223", f, "Ground staff", "Join", 1, 20, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        listFlight.add(f);

        f = new Flight("F0828", "HaiPhong", "Hanoi", LocalDateTime.of(2023, 10, 17, 20, 00), LocalDateTime.of(2023, 10, 17, 22, 00), 120, 120, "READY");

        c = new CrewMember("CM3331", f, "Pilot", "Lor", 2, 29, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM3332", f, "Flight attendants", "TenHag", 2, 23, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        c = new CrewMember("CM3333", f, "Ground staff", "Snoopy", 1, 20, "ASSIGNED");
        f.getListCrewMember().add(c);
        listCrewMember.add(c);

        listFlight.add(f);

        f = new Flight("F9828", "QuyNhon", "Hanoi", LocalDateTime.of(2023, 10, 17, 8, 30), LocalDateTime.of(2023, 10, 17, 10, 00), 168, 168, "READY");
        c = new CrewMember("CM4441", f, "Pilot", "Cloud", 2, 29, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM4442", f, "Flight attendants", "Lion", 2, 23, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM4443", f, "Ground staff", "Dia", 1, 20, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);

//        end test
//        2
        f = new Flight("F0888", "HongKong", "Hanoi", LocalDateTime.of(2023, 10, 17, 9, 00), LocalDateTime.of(2023, 10, 17, 15, 00), 1, 1, "READY");

        c = new CrewMember("CM0004", f, "Pilot", "BeanJ", 2, 25, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0005", f, "Flight attendants", "Levi", 1, 22, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0006", f, "Ground staff", "Artermis", 0, 22, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);

//        3
        f = new Flight("F0773", "Mexico", "Hcm", LocalDateTime.of(2023, 10, 18, 06, 00), LocalDateTime.of(2023, 10, 18, 07, 00), 5, 5, "READY");

        c = new CrewMember("CM0007", f, "Pilot", "Kati", 2, 33, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0008", f, "Flight attendants", "Zeros", 1, 23, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0009", f, "Ground staff", "Bie", 0, 19, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);
//       4
        f = new Flight("F0775", "Taiwan", "Hcm", LocalDateTime.of(2023, 10, 19, 06, 00), LocalDateTime.of(2023, 10, 19, 07, 00), 160, 160, "READY");

        c = new CrewMember("CM0010", f, "Pilot", "Croc", 3, 34, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0011", f, "Flight attendants", "TK", 2, 23, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0012", f, "Ground staff", "Route", 1, 19, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);
//        5
        f = new Flight("F0776", "Hanoi", "Jakarta", LocalDateTime.of(2023, 10, 17, 9, 00), LocalDateTime.of(2023, 10, 17, 12, 00), 120, 120, "READY");

        c = new CrewMember("CM0013", f, "Pilot", "Stack", 3, 30, "ASSIGNED");
        
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0014", f, "Flight attendants", "Ceos", 2, 21, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0015", f, "Ground staff", "Route", 0, 19, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);
//        6     
        f = new Flight("F0015", "Singapore", "HCM", LocalDateTime.of(2023, 11, 01, 06, 00), LocalDateTime.of(2023, 11, 01, 07, 00), 20, 20, "READY");

        c = new CrewMember("CM0016", f, "Pilot", "Robo", 3, 36, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0017", f, "Flight attendants", "Hankay", 2, 26, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0018", f, "Ground staff", "Yuna", 4, 30, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);
//        7       
        f = new Flight("F0001", "Danang", "Hanoi", LocalDateTime.of(2023, 11, 02, 06, 00), LocalDateTime.of(2023, 11, 02, 07, 00), 30, 30, "READY");

        c = new CrewMember("CM0019", f, "Pilot", "Robo", 10, 40, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0020", f, "Flight attendants", "Hankay", 3, 26, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        c = new CrewMember("CM0021", f, "Ground staff", "Yuna", 4, 25, "ASSIGNED");
        listCrewMember.add(c);
        f.getListCrewMember().add(c);

        listFlight.add(f);

//        test flight is not ready
        listFlight.add(new Flight("F0003", "Hanoi", "HCM", LocalDateTime.of(2023, 10, 30, 06, 00), LocalDateTime.of(2023, 10, 30, 07, 00), 20, 30, "NOT READY"));

        
    }
    String departureCity;

    public void addFlight() {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("+                             Add Flight                                +");
        System.out.println("+-----------------------------------------------------------------------+");
        boolean flag = true;
        int choice;
        Flight flight = new Flight();
        while (flag) {
            String flightNumber = tool.inputString("Fligh Number (Fxyzt) (xyzt: number):");
            if (validation.hasSpace(flightNumber) == false
                    && validation.isFormFlightNumber(flightNumber) == true
                    && validation.isValidLengthFlightNumber(flightNumber) == true
                    && validation.isExistFlightNumber(flightNumber, listFlight) == false) {
                flight.setFlightNumber(flightNumber);
                flag = false;
            } else {
                do {
                    choice = menu.getChoiceAsk(asking);
                    if (choice == 1) {
                        flightNumber = tool.inputString("Fligh Number (Fxyzt) (xyzt: number):");
                        if (validation.hasSpace(flightNumber) == false
                                && validation.isFormFlightNumber(flightNumber) == true
                                && validation.isValidLengthFlightNumber(flightNumber) == true
                                && validation.isExistFlightNumber(flightNumber, listFlight) == false) {
                            flight.setFlightNumber(flightNumber);
                            flag = false;
                        } else {
                            flag = true;
                        }
                    } else {
                        return;
                    }
                } while (flag);
            }

            flag = true;
            while (flag) {
                departureCity = tool.inputString("Departure city:");
                if (validation.isValidLength(departureCity, 1, 50) == true && validation.isContainNumber(departureCity) == false) {
                    flight.setDepartureCity(departureCity.toUpperCase());
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAsk(asking);
                        if (choice == 1) {
                            departureCity = tool.inputString("Departure city:");

                            if (validation.isValidLength(departureCity, 1, 50) == true && validation.isContainNumber(departureCity) == false) {
                                flight.setDepartureCity(departureCity.toUpperCase());
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }
            }

            flag = true;

            while (flag) {
                String destinationCity = tool.inputString("Destination city:");
                if (validation.isValidLength(flightNumber, 1, 50) == true && validation.isContainNumber(destinationCity) == false
                        && validation.isSameDepartureCity(departureCity, destinationCity) == false) {
                    flight.setDestinationCity(destinationCity.toUpperCase());

                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAsk(asking);
                        if (choice == 1) {
                            destinationCity = tool.inputString("Destination city:");
                            if (validation.isValidLength(destinationCity, 1, 50) == true && validation.isContainNumber(destinationCity) == false
                                    && validation.isSameDepartureCity(departureCity, destinationCity) == false) {
                                flight.setDestinationCity(destinationCity.toUpperCase());
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }
            }

            flag = true;

            LocalDateTime departureFull = null;

            while (flag) {
                LocalDateTime require = LocalDateTime.now().plusHours(1).plusMinutes(1);
                System.out.println("The date and time must be after "
                        + require.getDayOfMonth() + "/"
                        + require.getMonthValue() + "/"
                        + require.getYear() + " | "
                        + require.getHour() + ":"
                        + require.getMinute()
                );
                LocalDateTime departureTime;
//              input Date
                LocalDateTime departureDate = tool.inputDate("Departure Date (dd/mm/yyyy):");
                if (departureDate != null) {
                    departureDate = departureDate.withHour(LocalDateTime.now().getHour());
                    departureDate = departureDate.withMinute(LocalDateTime.now().getMinute());

                }
//              Valid inputDate
                if (departureDate != null && validation.isFutureDate(departureDate) == true) {
//              Input Time
                    departureTime = tool.inputTime("Departure Time (hh:mm):");
//                    NOT
                    if (departureTime != null) {
                        departureTime = departureTime.withDayOfMonth(departureDate.getDayOfMonth());
                        departureTime = departureTime.withMonth(departureDate.getMonthValue());
                        departureTime = departureTime.withYear(departureDate.getYear());
                    }

                    LocalDateTime timeNow = LocalDateTime.now().plusHours(1);

//              Valid inputTime
                    if (departureTime != null && validation.isFutureTime(departureTime, timeNow)) {
                        departureFull = LocalDateTime.of(departureDate.getYear(), departureDate.getMonth(), departureDate.getDayOfMonth(), departureTime.getHour(), departureTime.getMinute());
                        flight.setDepartureTime(departureFull);
                        flag = false;
//              Time Wrong
                    } else {
                        do {
                            choice = menu.getChoiceAsk(asking);
                            if (choice == 1) {
                                require = LocalDateTime.now().plusHours(1).plusMinutes(1);
                                System.out.println("The date and time must be after "
                                        + require.getDayOfMonth() + "/"
                                        + require.getMonthValue() + "/"
                                        + require.getYear() + " | "
                                        + require.getHour() + ":"
                                        + require.getMinute()
                                );
//              Input Time if wrong                  
                                departureTime = tool.inputTime("Departure Time (hh:mm):");
//                                NOT
                                if (departureTime != null) {
                                    departureTime = departureTime.withDayOfMonth(departureDate.getDayOfMonth());
                                    departureTime = departureTime.withMonth(departureDate.getMonthValue());
                                    departureTime = departureTime.withYear(departureDate.getYear());
                                }
                                timeNow = LocalDateTime.now().plusHours(1);

//              Valid input Time if wrong
                                if (departureTime != null && validation.isFutureTime(departureTime, timeNow)) {
                                    departureFull = LocalDateTime.of(departureDate.getYear(), departureDate.getMonth(), departureDate.getDayOfMonth(), departureTime.getHour(), departureTime.getMinute());
                                    flight.setDepartureTime(departureFull);
                                    flag = false;
                                } else {
//              Continue loop if wrong 
                                    flag = true;
                                }
                            } else {
//              Choice == 2
                                return;
                            }
                        } while (flag);
                    }
                } else {
                    do {
                        choice = menu.getChoiceAsk(asking);
                        if (choice == 1) {
                            require = LocalDateTime.now().plusHours(1).plusMinutes(1);
                            System.out.println("The date and time must be after "
                                    + require.getDayOfMonth() + "/"
                                    + require.getMonthValue() + "/"
                                    + require.getYear() + " | "
                                    + require.getHour() + ":"
                                    + require.getMinute()
                            );
//              Input Date             
                            departureDate = tool.inputDate("Departure Date (dd/mm/yyyy):");
                            if (departureDate != null) {
                                departureDate = departureDate.withHour(LocalDateTime.now().getHour());
                                departureDate = departureDate.withMinute(LocalDateTime.now().getMinute());
                            }
//              Valid inputDate
                            if (departureDate != null && validation.isFutureDate(departureDate) == true) {
//              Input time
                                departureTime = tool.inputTime("Departure Time (hh:mm):");
//                                NOT
                                if (departureTime != null) {
                                    departureTime = departureTime.withDayOfMonth(departureDate.getDayOfMonth());
                                    departureTime = departureTime.withMonth(departureDate.getMonthValue());
                                    departureTime = departureTime.withYear(departureDate.getYear());
                                }
//              Valid inputTime                 
                                LocalDateTime timeNow = LocalDateTime.now().plusHours(1);

                                if (departureTime != null && validation.isFutureTime(departureTime, timeNow)) {
                                    departureFull = LocalDateTime.of(departureDate.getYear(), departureDate.getMonth(), departureDate.getDayOfMonth(), departureTime.getHour(), departureTime.getMinute());
                                    flight.setDepartureTime(departureFull);
                                    flag = false;
                                } else {
//              Time wrong
                                    do {
                                        choice = menu.getChoiceAsk(asking);
                                        if (choice == 1) {
                                            require = LocalDateTime.now().plusHours(1).plusMinutes(1);
                                            System.out.println("The date and time must be after "
                                                    + require.getDayOfMonth() + "/"
                                                    + require.getMonthValue() + "/"
                                                    + require.getYear() + " | "
                                                    + require.getHour() + ":"
                                                    + require.getMinute()
                                            );

//              InputTime                              
                                            departureTime = tool.inputTime("Departure Time (hh:mm):");
//                                            NOT
                                            if (departureTime != null) {
                                                departureTime = departureTime.withDayOfMonth(departureDate.getDayOfMonth());
                                                departureTime = departureTime.withMonth(departureDate.getMonthValue());
                                                departureTime = departureTime.withYear(departureDate.getYear());
                                            }
//              Valid inputTime              
                                            timeNow = LocalDateTime.now().plusHours(1);

                                            if (departureTime != null && validation.isFutureTime(departureTime, timeNow)) {
                                                departureFull = LocalDateTime.of(departureDate.getYear(), departureDate.getMonth(), departureDate.getDayOfMonth(), departureTime.getHour(), departureTime.getMinute());
                                                flight.setDepartureTime(departureFull);
                                                flag = false;
                                            } else {
//              Continue loop if wrong  time                                
                                                flag = true;
                                            }
                                        } else {
//              Choice == 2
                                            return;
                                        }
                                    } while (flag);
                                }
                            } else {
//              Continue loop if wrong date                  
                                flag = true;
                            }
                        } else {
//              Choice == 2              
                            return;
                        }
                    } while (flag);
                }
            }

            flag = true;
//          Arrival Time
            while (flag) {

                System.out.println("The Arrival date and Arrival time must be after "
                        + departureFull.getDayOfMonth() + "/"
                        + departureFull.getMonthValue() + "/"
                        + departureFull.getYear() + " | "
                        + departureFull.getHour() + ":"
                        + departureFull.getMinute()
                );
                LocalDateTime arrivalDate;
                LocalDateTime arrivalTime;
                LocalDateTime arrivalFull;
//          Input Date      
                arrivalDate = tool.inputDate("Arrival Date (dd/mm/yyyy):");
//          Valid input Date      
//                System.out.println("1:" + arrivalDate != null);
//                System.out.println("2:" + validation.isArrivalDate(departureFull, arrivalDate));
//                System.out.println("3:" + validation.isArrivalNormalDateBound(departureFull, arrivalDate));
//                System.out.println("4:" + validation.isArrivalDateBound(departureFull, arrivalDate));
//                System.out.println("Fi"
//                        + ((arrivalDate != null && validation.isArrivalDate(departureFull, arrivalDate) == true)));
//                System.out.println("F2" + (validation.isArrivalNormalDateBound(departureFull, arrivalDate)
//                        || validation.isArrivalDateBound(departureFull, arrivalDate) == true)
//                );
//                System.out.println(departureFull.getMinute() + ":" + departureFull.getHour());

                if ((arrivalDate != null && validation.isArrivalDate(departureFull, arrivalDate) == true)
                        && (validation.isArrivalNormalDateBound(departureFull, arrivalDate) == true
                        || validation.isArrivalDateBound(departureFull, arrivalDate) == true)) {
//          Input Time          
                    arrivalTime = tool.inputTime("Arrival Time (hh:mm):");
                    if (arrivalTime != null) {
                        arrivalTime = arrivalTime.withDayOfMonth(arrivalDate.getDayOfMonth());
                        arrivalTime = arrivalTime.withMonth(arrivalDate.getMonthValue());
                        arrivalTime = arrivalTime.withYear(arrivalDate.getYear());
                    }

//          Valid inputTime
                    if (arrivalTime != null && validation.isArrivalTime(departureFull, arrivalTime)) {
                        arrivalFull = LocalDateTime.of(arrivalDate.getYear(), arrivalDate.getMonth(), arrivalDate.getDayOfMonth(), arrivalTime.getHour(), arrivalTime.getMinute());
                        flight.setArrivalTime(arrivalFull);
                        flag = false;

                    } else {
//          If Time Wrong              
                        do {
                            choice = menu.getChoiceAsk(asking);
                            if (choice == 1) {
                                System.out.println("The Arrival date and Arrival time must be after "
                                        + departureFull.getDayOfMonth() + "/"
                                        + departureFull.getMonthValue() + "/"
                                        + departureFull.getYear() + " | "
                                        + departureFull.getHour() + ":"
                                        + departureFull.getMinute()
                                );
//          Input time                      
                                arrivalTime = tool.inputTime("Arrival Time (hh:mm):");

                                if (arrivalTime != null) {
                                    arrivalTime = arrivalTime.withDayOfMonth(arrivalDate.getDayOfMonth());
                                    arrivalTime = arrivalTime.withMonth(arrivalDate.getMonthValue());
                                    arrivalTime = arrivalTime.withYear(arrivalDate.getYear());
                                }

//          Valid inputTime
                                if (arrivalTime != null && validation.isArrivalTime(departureFull, arrivalTime) == true) {
                                    arrivalFull = LocalDateTime.of(arrivalDate.getYear(), arrivalDate.getMonth(), arrivalDate.getDayOfMonth(), arrivalTime.getHour(), arrivalTime.getMinute());
                                    flight.setArrivalTime(arrivalFull);
                                    flag = false;
                                } else {
//          Continue loop if wrong                          
                                    flag = true;
                                }
                            } else {
//          Choice == 2                      
                                return;
                            }
                        } while (flag);
                    }
                } else {
//                *****************************************
//          Date wrong          
                    do {
                        choice = menu.getChoiceAsk(asking);
                        if (choice == 1) {
                            System.out.println("The Arrival date and Arrival time must be after "
                                    + departureFull.getDayOfMonth() + "/"
                                    + departureFull.getMonthValue() + "/"
                                    + departureFull.getYear() + " | "
                                    + departureFull.getHour() + ":"
                                    + departureFull.getMinute()
                            );
//          Input Date                  
                            arrivalDate = tool.inputDate("Arrival Date (dd/mm/yyyy):");
//          Valid inputDate
                            if ((arrivalDate != null && validation.isArrivalDate(departureFull, arrivalDate) == true)
                                    && (validation.isArrivalNormalDateBound(departureFull, arrivalDate) == true
                                    || validation.isArrivalDateBound(departureFull, arrivalDate) == true)) {
//          Input Time                      
                                arrivalTime = tool.inputTime("Arrival Time (hh:mm):");

                                if (arrivalTime != null) {
                                    arrivalTime = arrivalTime.withDayOfMonth(arrivalDate.getDayOfMonth());
                                    arrivalTime = arrivalTime.withMonth(arrivalDate.getMonthValue());
                                    arrivalTime = arrivalTime.withYear(arrivalDate.getYear());
                                }

//          Valid inputTime
                                if (arrivalTime != null && validation.isArrivalTime(departureFull, arrivalTime)) {
                                    arrivalFull = LocalDateTime.of(arrivalDate.getYear(), arrivalDate.getMonth(), arrivalDate.getDayOfMonth(), arrivalTime.getHour(), arrivalTime.getMinute());
                                    flight.setArrivalTime(arrivalFull);
                                    flag = false;
                                } else {
//          If time wrong                          
                                    do {
                                        choice = menu.getChoiceAsk(asking);
                                        if (choice == 1) {
                                            System.out.println("The Arrival date and Arrival time must be after "
                                                    + departureFull.getDayOfMonth() + "/"
                                                    + departureFull.getMonthValue() + "/"
                                                    + departureFull.getYear() + " | "
                                                    + departureFull.getHour() + ":"
                                                    + departureFull.getMinute()
                                            );
//          Input time                                  
                                            arrivalTime = tool.inputTime("Arrival Time (hh:mm):");

                                            if (arrivalTime != null) {
                                                arrivalTime = arrivalTime.withDayOfMonth(arrivalDate.getDayOfMonth());
                                                arrivalTime = arrivalTime.withMonth(arrivalDate.getMonthValue());
                                                arrivalTime = arrivalTime.withYear(arrivalDate.getYear());
                                            }

//          Valid inputTime
                                            if (arrivalTime != null && validation.isArrivalTime(departureFull, arrivalTime) == true) {
                                                arrivalFull = LocalDateTime.of(arrivalDate.getYear(), arrivalDate.getMonth(), arrivalDate.getDayOfMonth(), arrivalTime.getHour(), arrivalTime.getMinute());
                                                flight.setArrivalTime(arrivalFull);
                                                flag = false;
                                            } else {
//          Continue loop if Time wrong                                      
                                                flag = true;
                                            }
                                        } else {
//          Choice == 2                                  
                                            return;
                                        }
                                    } while (flag);
                                }
                            } else {
//          Continue loop if Date wrong                                      
                                flag = true;
                            }
                        } else {
//          Choice == 2                  
                            return;
                        }
                    } while (flag);
                }
            }

            flag = true;

            while (flag) {
                Integer seat = tool.inputInteger("Number of seats available (1-168):");
                if (seat != null && validation.isAvailableSeat(seat)) {
                    flight.setAvailableSeats(seat);
                    flight.setMaxSeats(seat);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAsk(asking);
                        if (choice == 1) {
                            seat = tool.inputInteger("Number of seats available (1-168):");
                            if (seat != null && validation.isAvailableSeat(seat)) {
                                flight.setAvailableSeats(seat);
                                flight.setMaxSeats(seat);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }
            }
            System.out.println("Add Flight Succesfully");
            flight.setStatus("NOT READY");
            listFlight.add(flight);
        }
    }
    int i = 0;
    String reservationId;

    public void makeReservation() {

        if (listFlight != null) {
            for (Flight flight1 : listFlight) {
                if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                    for (CrewMember crewMember : flight1.getListCrewMember()) {
                        crewMember.setStatus("FREE");
                        Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                        crewMember.setFlight(disable);
                    }
                    flight1.setStatus("DONE");
                    flight1.setListCrewMember(new ArrayList<>());
                }
            }
        }

        if (listReservation != null) {
            for (Reservation reservation : listReservation) {
                if (reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())) {
                    reservation.setStatus("DONE");
                }
            }
        }
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("+                            Search Flight                              +");
        System.out.println("+-----------------------------------------------------------------------+");
        String departureCity = tool.inputCity("Departure City:");
        String destinationCity = "";

        do {
            destinationCity = tool.inputCity("Destination City:");
            if (!departureCity.equalsIgnoreCase(destinationCity)) {
                break;
            } else {
                System.out.println("The Arrival City is not the same as the Departure City");
                continue;
            }
        } while (true);
        LocalDateTime date = tool.inputDateNotNull("Date (dd/mm/yyyy): ");
//        System.out.println(date.toLocalDate().toString());
//        System.out.println(LocalDateTime.now().toLocalDate());
//        System.out.println(!date.isAfter(LocalDateTime.now()));
//        System.out.println(date.toLocalDate().isEqual(LocalDateTime.now().toLocalDate()));
        if ((!date.isAfter(LocalDateTime.now()) && (date.toLocalDate().isEqual(LocalDateTime.now().toLocalDate()) == false))) {
            System.out.println("Your date must be after "+LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear() +" to Book a flight");
            return;
        }

//        LocalDateTime dateFull = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        ArrayList<Flight> listSearch = validation.searchFlight(departureCity.toUpperCase(), destinationCity.toUpperCase(), date, listFlight);
        if (listSearch != null) {
            int valid = 0;
            for (Flight flight : listSearch) {
                if (flight.getStatus().equalsIgnoreCase("DONE")) {
                    valid++;
                }
            }
            if (listSearch != null && valid == (listSearch.size())) {
                System.out.println("All flight has DONE");
            } else {

                if (listSearch != null) {
                    int choice = menu.getChoiceAskMakeReservation(asking, listSearch);
                    Collections.sort(listSearch, new Comparator<Flight>() {
                        @Override
                        public int compare(Flight o1, Flight o2) {
                            return o2.getDepartureTime().toLocalDate().compareTo(o2.getDepartureTime().toLocalDate());
                        }
                    });
                    if (choice == 1) {
                        System.out.println("Please provide persional information");
                        String name = tool.inputString("Name:");
                        boolean flag = true;
                        Passenger passenger = new Passenger();
                        passenger.setName(name);
                        String phoneNumber = tool.inputPhoneNumber("Phone Number:");
                        if (phoneNumber != null && validation.isExistPhoneNumber(phoneNumber, listReservation) == false) {
                            passenger.setPhoneNumber(phoneNumber);
                        } else {
                            do {
                                choice = menu.getChoiceAsk(asking);
                                if (choice == 1) {
                                    phoneNumber = tool.inputPhoneNumber("Phone Number:");
                                    if (phoneNumber != null && validation.isExistPhoneNumber(phoneNumber, listReservation) == false) {
                                        passenger.setPhoneNumber(phoneNumber);
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }

                            } while (flag);
                        }
                        flag = true;

                        String identityNumber = tool.inputIdNumber("Citizen identification card number:");

                        if (identityNumber != null && validation.isExistCID(identityNumber, listReservation) == false) {
                            passenger.setCitizenIdentificationCartNumber(identityNumber);
                        } else {
                            do {
                                choice = menu.getChoiceAsk(asking);
                                if (choice == 1) {
                                    identityNumber = tool.inputIdNumber("Citizen identification card number:");

                                    if (identityNumber != null && validation.isExistCID(identityNumber, listReservation) == false) {
                                        passenger.setCitizenIdentificationCartNumber(identityNumber);
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);
                        }
                        passenger.setSeatNumber("N/A");
                        System.out.println("SELECT the Flight");

                        flag = true;
                        do {
                            Flight flight = menu.getRefChoice(listSearch);
                            if (flight != null) {
                                reservationId = UUID.randomUUID().toString().substring(0, 7);

                                Reservation reservation = new Reservation(reservationId, passenger, flight, "NO CHECK-IN");
//                        System.out.println("NE " + flight.getArrivalTime().isBefore(LocalDateTime.now()));
//                        System.out.println("A " + flight.getArrivalTime().toString());;
//                        System.out.println("B " + LocalDateTime.now().toString());
                                if (flight.getArrivalTime().isBefore(LocalDateTime.now())) {
                                    System.out.println("The flight has Arrive, Please another flight");
                                    flag = true;
//                            return;
                                } else if (flight.getAvailableSeats() > 0 && (flight.getArrivalTime().isBefore(LocalDateTime.now()) == false)) {

                                    flight.setAvailableSeats(flight.getAvailableSeats() - 1);
                                    listReservation.add(reservation);
                                    flight.getListReservations().add(reservation);
                                    System.out.println("Reservation successful");
                                    System.out.println("+----------------------------------------+");
                                    System.out.println("+ REMEMBER your ReservationId: " + reservationId + "   +");
                                    System.out.println("+----------------------------------------+");

                                    LocalDateTime timeLimit = reservation.getFlight().getDepartureTime().minusHours(3).minusSeconds(1);
                                    System.out.println("Your check-in must in range " + timeLimit.toLocalDate() + " | " + timeLimit.toLocalTime() + " to " + reservation.getFlight().getDepartureTime().toLocalDate().toString() + " | " + reservation.getFlight().getDepartureTime().toLocalTime().toString());

                                    flag = false;
                                } else {
                                    System.out.println("The flight is full, Please choose another flight");
                                    flag = true;
//                            return;
                                }

                            } else {
                                return;
                            }
                        } while (flag);

                    } else {
                        return;
                    }

                }
            }

        }
    }

    public void checkIn() {
//        CAN FIX may bay 1 slot LOI chon A1 ko duoc FIX cai 2 booking con 0 slot ko duoc chon
        String reservationId = tool.inputString("ReservationId:");
        Reservation reservation = null;
        if (reservationId != null) {
            reservation = validation.isExistReservationId(reservationId, listReservation);
        }

//        System.out.println("1 "+reservationId != null);
//        System.out.println("2 "+(validation.isRangeCheckIn(reservation) == false && reservation != null));
//        System.out.println("3 "+validation.isReadyFlight(reservationId, reservation.getFlight())
//                );
        if (reservationId != null && reservation != null) {
            if (validation.isRangeCheckIn(reservation) == false && reservation != null) {
                return;
            }
        }

        if (reservationId != null && reservation != null) {
            if (validation.isReadyFlight(reservationId, reservation.getFlight()) == false) {
                return;
            }
        }

//                HERE
        if (reservation != null) {
            if (validation.isSelectSeat(reservation, listReservation)) {
                return;
            } else {
                String seatNumber = validation.displaySeatsAvailable(reservation.getFlight(), listReservation);
                reservation.getFlight().getListSeat().add(seatNumber);
                reservation.getPassenger().setSeatNumber(seatNumber);
                reservation.setStatus("READY");
                String boardingPasses = validation.generateBoardingPasses(reservation);
            }
        } else {
            System.out.println("ReservationId is not Exist");
            return;
        }
    }

    public void manageCrewAssignment() {
        System.out.println("Choose Flight to manage Crew mameber");
        Flight flight = null;
        if (listFlight != null) {
            for (Flight flight1 : listFlight) {
                if (flight1.getArrivalTime().isBefore(LocalDateTime.now())) {
                    for (CrewMember crewMember : flight1.getListCrewMember()) {
                        crewMember.setStatus("FREE");
                        Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                        crewMember.setFlight(disable);
                    }
                    flight1.setStatus("DONE");
                    flight1.setListCrewMember(new ArrayList<>());
                }
            }
            flight = menu.getRefChoice(listFlight);
        }

        if (flight != null) {

            System.out.println("Choose Crew to assign to flight");

            CrewMember crewMember = menu.getRefChoiceCrewMember(listCrewMember, flight);
            if (crewMember == null) {
                return;
            }
            if (listCrewMember != null && crewMember != null) {
                int quantityPilot = 0;
                int quantiyFlightAttendants = 0;
                int quantityGroundStaff = 0;

                for (CrewMember crew : flight.getListCrewMember()) {

                    if (crew.getRole().equalsIgnoreCase("Pilot")) {
                        quantityPilot++;
                    } else if (crew.getRole().equalsIgnoreCase("Flight attendants")) {
                        quantiyFlightAttendants++;
                    } else if (crew.getRole().equalsIgnoreCase("Ground staff")) {
                        quantityGroundStaff++;
                    }
                }

                if (crewMember.getRole().trim().equalsIgnoreCase("Pilot") && quantityPilot >= 2) {
                    System.out.println("Assign Failed, The Flight is maximum Pilot (2) ");
                    return;
                } else if (crewMember.getRole().trim().equalsIgnoreCase("Flight attendants") && quantiyFlightAttendants >= 5) {
                    System.out.println("Assign Failed, The Flight is maximum Flight attendants (5)");
                    return;
                } else if (crewMember.getRole().trim().equalsIgnoreCase("Ground staff") && quantityGroundStaff >= 5) {
                    System.out.println("Assign Failed, The Flight is maximum Ground staff (5)");
                    return;
                } else {
                    if (flight != null) {
                        if (crewMember != null) {
                            flight.getListCrewMember().add(crewMember);
                            crewMember.setStatus("ASSIGNED");
                            crewMember.setFlight(flight);
                            System.out.println("Assign succesfully");
                        }
                    }

//                    System.out.println("P" + quantityPilot);
//                    System.out.println("G" + quantityGroundStaff);
//                    System.out.println("F" + quantiyFlightAttendants);
                    if (quantityPilot >= 1 && quantityGroundStaff >= 1 && quantiyFlightAttendants >= 1) {
                        flight.setStatus("READY");
//                        System.out.println("DA SET");
                    }
                }
            }
        }

    }

    public void addCrew() {
        int choice = 0;
        boolean flag = true;
        String crewMemberId = "";
        while (flag) {
            crewMemberId = tool.inputString("Crew Member Id (CMxxxx) (x: number):");

            if (validation.isFormCrewMemberId(crewMemberId)
                    && validation.isExistCrewMemberId(crewMemberId, listCrewMember) == false) {

                flag = false;

            } else {
                do {
                    choice = menu.getChoiceAsk(asking);
                    if (choice == 1) {
                        crewMemberId = tool.inputString("Crew Member Id (CMxxxx) (x: number):");
                        if (validation.isFormCrewMemberId(crewMemberId)
                                && validation.isExistCrewMemberId(crewMemberId, listCrewMember) == false) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    } else {
                        return;
                    }
                } while (flag);
            }
        }

        String name = tool.inputString("Crew name:");
        int age = tool.inputAge("Age: ", 18, 61);
        String role = menu.getChoiceRoleCrew();
        if (role == null) {
            return;
        }
        int yearOfExperient = tool.inputEOY("Year of experient:", 0, 43, age);
        CrewMember crewMember = new CrewMember(crewMemberId.toUpperCase(), new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY"),
                role, name, yearOfExperient, age, "FREE");
        listCrewMember.add(crewMember);
        System.out.println("Add crew member succesfully");
    }

    String pathNameCrewMember;
    String pathNameReservationPassenger;
    String pathNameFlight;

//    FLight
    public void saveToFileFlight() {

        try {
//                            *****
            if (listFlight != null) {
                for (Flight flight1 : listFlight) {
                    if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                        for (CrewMember crewMember : flight1.getListCrewMember()) {
                            crewMember.setStatus("FREE");
                            Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                            crewMember.setFlight(disable);
                        }
                        flight1.setStatus("DONE");
                        flight1.setListCrewMember(new ArrayList<>());
                    }
                }
            }

            if (listReservation != null) {
                for (Reservation reservation : listReservation) {
                    if (reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())) {
                        reservation.setStatus("DONE");
                    }
                }
            }

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            String datetime = time.format(dtf);
            pathNameFlight = "./Flights_" + datetime + ".dat";
            File f = new File(pathNameFlight);
            f.createNewFile();
            if (!f.exists()) {
                System.err.println("File Flight is not Exist");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                Collections.sort(listFlight, new Comparator<Flight>() {
                    @Override
                    public int compare(Flight o1, Flight o2) {
                        return o2.getDepartureTime().compareTo(o1.getDepartureTime());
                    }
                });
                for (Flight flight : listFlight) {
                    bw.write(flight.toStringFile() + "\n");
                }
                bw.close();
                System.out.println("Save successfully !");
                System.out.println("Your file is " + pathNameFlight);

            }
        } catch (FileNotFoundException f) {
            System.out.println("File Flight is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Save File !");
        }

    }

    public void loadFromFileFlight() {
        try {
            listFlight.clear();
            File f = new File(pathNameFlight);
            if (!f.exists()) {
                System.out.println("File Flight is not Exist");
            } else {
                System.out.println("Load File " + pathNameFlight);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
//                    LOI LOAD KO DC
//        return flightNumber + ", " + departureCity + ", " + destinationCity + ", " + departureTime + ", " + arrivalTime + ", "+availableSeats + ", " + maxSeats;

                    String[] parts = line.split(", ");
                    String flightNumber = parts[0].trim();
                    String departureCity = parts[1].trim();
                    String destinationCity = parts[2].trim();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                    LocalDateTime departureTime = LocalDateTime.parse(parts[3], dtf);
                    LocalDateTime ArrivalTime = LocalDateTime.parse(parts[4], dtf);
                    int availableSeat = Integer.parseInt(parts[5].trim());
                    int maxSeat = Integer.parseInt(parts[6].trim());
                    String status = parts[7].trim();
                    Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, ArrivalTime, availableSeat, maxSeat, status);
                    listFlight.add(flight);
                }
                br.close();
//                name+", "+role+", "+age+", "+yearOfExperient+", "+flight.getFlightNumber()+", "+status;
                if (!listFlight.isEmpty()) {

                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                                     List Flight                                                                             +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    i = 0;
                    for (Flight flight : listFlight) {
                        System.out.println(String.format("+%8d|%15s|%22s|%22s|%20s|%18s|%18s|%13s|%12s +", ++i, flight.getFlightNumber(), flight.getDepartureCity().toUpperCase(), flight.getDestinationCity().toUpperCase(),
                                flight.getDepartureTime().toString(), flight.getArrivalTime().toString(), flight.getAvailableSeats(), flight.getMaxSeats(), flight.getStatus().toUpperCase()));
                    }
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");

                } else {
                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                                     List Flight                                                                             +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    System.out.println("+                                                                                                                                                             +");
                    System.out.println("+                                                                          EMPTY LIST                                                                         +");
                    System.out.println("+                                                                                                                                                             +");
                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("");
                }

            }

        } catch (FileNotFoundException f) {
            System.out.println("File Flight is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Load File !, File Flight is not found");
        }
    }

//    CREW
    public void saveToFileCrewMember() {
        try {
            if (listFlight != null) {
                for (Flight flight1 : listFlight) {
                    if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                        for (CrewMember crewMember : flight1.getListCrewMember()) {
                            crewMember.setStatus("FREE");
                            Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                            crewMember.setFlight(disable);
                        }
                        flight1.setStatus("DONE");
                        flight1.setListCrewMember(new ArrayList<>());
                    }
                }
            }

            if (listReservation != null) {
                for (Reservation reservation : listReservation) {
                    if (reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())) {
                        reservation.setStatus("DONE");
                    }
                }
            }
            if (listCrewMember != null) {
                Collections.sort(listCrewMember, new Comparator<CrewMember>() {
                    @Override
                    public int compare(CrewMember o1, CrewMember o2) {
                        return o1.getFlight().getFlightNumber().compareTo(o2.getFlight().getFlightNumber());
                    }
                });
            }
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            String datetime = time.format(dtf);
            pathNameCrewMember = "./CrewMember_" + datetime + ".dat";
            File f = new File(pathNameCrewMember);
            f.createNewFile();
            if (!f.exists()) {
                System.out.println("File Crew is not Exist");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));

                for (CrewMember crewMember : listCrewMember) {
                    bw.write(crewMember.toFileString() + "\n");
                }

                bw.close();
                System.out.println("Save successfully !");
                System.out.println("Your file is " + pathNameCrewMember);

            }
        } catch (FileNotFoundException f) {
            System.out.println("File CrewMember is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Save File !");
        }

    }

    public void loadFromFileCrewMember() {
        try {
            listCrewMember.clear();
            File f = new File(pathNameCrewMember);
            if (!f.exists()) {
                System.out.println("File Crew is not Exist");
            } else {
                System.out.println("Load File " + pathNameCrewMember);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
//                    LOI LOAD KO DC
                    String[] parts = line.split(", ");
//                    System.out.println("1");

                    String crewMemberId = parts[0].trim();
//                    
                    String name = parts[1].trim();
//                    System.out.println("2");

                    String role = parts[2].trim();
//                    System.out.println("3");

                    int age = Integer.parseInt(parts[3].trim());
//                    System.out.println("4");

                    int YOE = Integer.parseInt(parts[4].trim());
//                    System.out.println("5");

                    String flightNumber = parts[5].trim();
//                    System.out.println("6");

                    String status = parts[6].trim();
//                    System.out.println("7");
                    Flight fl = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                    if (listFlight != null) {
                        fl = null;
                        for (Flight flight : listFlight) {

                            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                fl = flight;
                                break;
                            } else if (flight.getFlightNumber().equalsIgnoreCase("N/A")) {
                                fl = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");

                                break;
                            }
                        }
                    }

//                    System.out.println("8");
                    CrewMember cr = new CrewMember(crewMemberId, fl, role, name, YOE, age, status);

                    if (listFlight != null) {
                        for (Flight flight : listFlight) {
                            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                                flight.getListCrewMember().add(cr);
                                break;
                            }
                        }
                    }

                    listCrewMember.add(cr);
//                    System.out.println("9");
                }
                br.close();
//                name+", "+role+", "+age+", "+yearOfExperient+", "+flight.getFlightNumber()+", "+status;
                if (!listCrewMember.isEmpty()) {

                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                           List Crew Member                                                             +");
                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                    System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                    int i = 0;
//                System.out.println("SIZE" + listCrewMember.size());
                    for (CrewMember crewMember : listCrewMember) {
                        Flight flight = crewMember.getFlight();
                        String flightNumber = (flight != null) ? flight.getFlightNumber() : "N/A";
                        System.out.println(String.format("|%12d|%18s|%15s|%20s|%15d|%16d|%16s|%16s +", ++i, crewMember.getCrewMemberId(),
                                crewMember.getName(),
                                crewMember.getRole(),
                                crewMember.getAge(),
                                crewMember.getYearOfExperient(),
                                crewMember.getStatus(),
                                flightNumber));
                        ;
                    }
                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");

                    System.out.println("");
                } else {
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                           List Crew Member                                                             +");
                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                    System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                    System.out.println("+                                                                                                                                        +");
                    System.out.println("+                                                               EMPTY LIST                                                               +");
                    System.out.println("+                                                                                                                                        +");
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("");

                }

            }

        } catch (FileNotFoundException f) {
            System.out.println("File Crew Member is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Load File !, File Crew Member is not found");
        }
    }

//    Passsenger
    public void saveToFilePassenger() {
        try {
            if (listFlight != null) {
                for (Flight flight1 : listFlight) {
                    if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                        for (CrewMember crewMember : flight1.getListCrewMember()) {
                            crewMember.setStatus("FREE");
                            Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                            crewMember.setFlight(disable);
                        }
                        flight1.setStatus("DONE");
                        flight1.setListCrewMember(new ArrayList<>());
                    }
                }
            }

            if (listReservation != null) {
                for (Reservation reservation : listReservation) {
                    if (reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())) {
                        reservation.setStatus("DONE");
                    }
                }
            }
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            String datetime = time.format(dtf);
            pathNameReservationPassenger = "./Passenger_" + datetime + ".dat";
            File f = new File(pathNameReservationPassenger);
            f.createNewFile();
            if (!f.exists()) {
                System.out.println("File Passenger is not Exist");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//                Collections.sort(listReservation, new Comparator<Reservation>() {
//                    @Override
//                    public int compare(Reservation o1, Reservation o2) {
//                        return o2.getFlight().getDepartureTime().compareTo(o1.getFlight().getDepartureTime());
//                    }
//                });
//return reservationId+", "+passenger.getName()+", "+passenger.getPhoneNumber()+", "+passenger.getCitizenIdentificationCartNumber()+", "+
//                passenger.getSeatNumber()+", "+flight.getFlightNumber()+", "+status;
//                System.out.println("1N");
                for (Reservation reservation : listReservation) {
                    bw.write(reservation.toFileString() + "\n");
                }
//                System.out.println("2N");

                bw.close();
                System.out.println("Save successfully !");
                System.out.println("Your file is " + pathNameReservationPassenger);

            }
        } catch (FileNotFoundException f) {
            System.out.println("File Passenger is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Save File !");
        }

    }

    public void loadFromFilePassenger() {
        try {
            listReservation.clear();
            File f = new File(pathNameReservationPassenger);
            if (!f.exists()) {
                System.out.println("File Passenger is not Exist");
            } else {
                System.out.println("Load File " + pathNameReservationPassenger);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
//                    LOI LOAD KO DC
//return reservationId+", "+passenger.getName()+", "+passenger.getPhoneNumber()+", "+passenger.getCitizenIdentificationCartNumber()+", "+
//                passenger.getSeatNumber()+", "+flight.getFlightNumber()+", "+status;
                    String[] parts = line.split(", ");
//                    System.out.println("3N");

                    String reId = parts[0].trim();
//                    System.out.println("4N");

                    String passengerName = parts[1].trim();
//                    System.out.println("5N");

                    String phoneNumber = parts[2].trim();
//                    System.out.println("6N");

                    String CitizenId = parts[3].trim();
//                    System.out.println("7N");

                    String seatNumber = parts[4].trim();
//                    System.out.println("8N");

                    String flightNum = parts[5].trim();
//                    System.out.println("9N");

                    String status = parts[6].trim();
//                    System.out.println("10N");

                    Flight fl = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                    if (listReservation != null) {
                        fl = null;
                        for (Flight flight : listFlight) {

                            if (flight.getFlightNumber().equalsIgnoreCase(flightNum)) {
                                fl = flight;

                                break;
                            } else if (flight.getFlightNumber().equalsIgnoreCase("N/A")) {
                                fl = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                                break;
                            }
                        }
                    }

//                    System.out.println("11N");
                    Passenger p = new Passenger(passengerName, seatNumber, phoneNumber, CitizenId);
//                    System.out.println("12N");
                    fl.getListSeat().add(seatNumber);
                    Reservation re = new Reservation(reId, p, fl, status);
//                    System.out.println("13N");
                    listReservation.add(re);

                }
                br.close();
//                name+", "+role+", "+age+", "+yearOfExperient+", "+flight.getFlightNumber()+", "+status;
                if (!listReservation.isEmpty()) {
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                         List Reservation                                                         |");
                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+");
                    System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +");
                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+");
                    int i = 0;
//                System.out.println("SIZE"+listReservation.size());
                    for (Reservation reservation : listReservation) {
                        System.out.println(String.format("|%12d|%16s|%16s|%16s|%17s|%17s|%17s|%12s|",
                                ++i,
                                reservation.getReservationId(),
                                reservation.getPassenger().getName(),
                                reservation.getPassenger().getPhoneNumber(),
                                reservation.getPassenger().getCitizenIdentificationCartNumber(),
                                reservation.getPassenger().getSeatNumber(),
                                reservation.getFlight().getFlightNumber(),
                                reservation.getStatus()));
                    }
                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+");
                    System.out.println("");

                } else {

                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                         List Reservation                                                         |");
                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+");
                    System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +");
                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+");
                    System.out.println("+                                                                                                                                  +");
                    System.out.println("+                                                            EMPTY LIST                                                            +");
                    System.out.println("+                                                                                                                                  +");
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("");

                }
            }

        } catch (FileNotFoundException f) {
            System.out.println("File Passenger is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Load File !, File Passenger is not found");
        }
    }

    public String administratorAccess(String roleNow) {

        if (listFlight != null) {
            for (Flight flight1 : listFlight) {
                if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                    for (CrewMember crewMember : flight1.getListCrewMember()) {
                        crewMember.setStatus("FREE");
                        Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                        crewMember.setFlight(disable);
                    }
                    flight1.setStatus("DONE");
                    flight1.setListCrewMember(new ArrayList<>());
                }
            }
        }

        if (listReservation != null) {
            for (Reservation reservation : listReservation) {
                if (reservation.getFlight().getDepartureTime().isBefore(LocalDateTime.now())) {
                    reservation.setStatus("DONE");
                }
            }
        }

        if (listFlight != null) {
            for (Flight flight1 : listFlight) {
                if (flight1.getDepartureTime().isBefore(LocalDateTime.now())) {
                    for (CrewMember crewMember : flight1.getListCrewMember()) {
                        crewMember.setStatus("FREE");
                        Flight disable = new Flight("N/A", "N/A", "N/A", LocalDateTime.MIN, LocalDateTime.MIN, -1, -1, "NOT READY");
                        crewMember.setFlight(disable);
                    }
                    flight1.setStatus("DONE");
                    flight1.setListCrewMember(new ArrayList<>());
                }
            }
        }
        int choice = menu.getChoiceAdmin(roleNow);
        if (choice == 1) {
            if (!roleNow.equalsIgnoreCase("Administrator")) {
                String code = tool.inputString("Code Admin:");
                if (code.equals("admin")) {
                    System.out.println("");

                    System.out.println("+------------------------------------+");
                    System.out.println("+ You are accessing by Administrator +");
                    System.out.println("+------------------------------------+");
                    System.out.println("");

                    roleNow = "Administrator";
                    return "Administrator";
                } else {
                    System.out.println("Wrong Code !");
                    return "";
                }

            } else {
                System.out.println("");

                System.out.println("+------------------------------------+");
                System.out.println("+ You are accessing by Administrator +");
                System.out.println("+------------------------------------+");
                System.out.println("");

                roleNow = "Administrator";
                return "Administrator";
            }
        } else if (choice == 2) {
            System.out.println("");

            System.out.println("+------------------------------------+");
            System.out.println("+     You are accessing by User      +");
            System.out.println("+------------------------------------+");
            System.out.println("");

            roleNow = "User";
            return "User";
        } else if (choice == 3) {
            if (roleNow.equalsIgnoreCase("Administrator")) {
                int subChoice = 0;

                System.out.println("");

                System.out.println("+------------------------------------+");
                System.out.println("+ You are accessing by Administrator +");
                System.out.println("+------------------------------------+");
                System.out.println("");
                do {
                    subChoice = menu.getChoiceAdminMenu(listFlight, listReservation, listCrewMember);
                    switch (subChoice) {
                        case 1:
                            if (!listFlight.isEmpty()) {
                                System.out.println("");
                                Collections.sort(listFlight, new Comparator<Flight>() {
                                    @Override
                                    public int compare(Flight o1, Flight o2) {
                                        return o2.getDepartureTime().compareTo(o1.getDepartureTime());
                                    }
                                });
                                System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                                     List Flight                                                                             +");
                                System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                                System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                i = 0;
                                for (Flight flight : listFlight) {
                                    System.out.println(String.format("+%8d|%15s|%22s|%22s|%20s|%18s|%18s|%13d|%12s +", ++i, flight.getFlightNumber(), flight.getDepartureCity().toUpperCase(), flight.getDestinationCity().toUpperCase(),
                                            flight.getDepartureTime().toString(), flight.getArrivalTime().toString(), flight.getAvailableSeats(), flight.getMaxSeats(), flight.getStatus().toUpperCase()));
                                }
                                System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");

                                System.out.println("");

                            } else {
                                System.out.println("");

                                System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                                     List Flight                                                                             +");
                                System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                                System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                System.out.println("+                                                                                                                                                             +");
                                System.out.println("+                                                                          EMPTY LIST                                                                         +");
                                System.out.println("+                                                                                                                                                             +");
                                System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("");

                            }
                            break;
                        case 2:
                            if (!listReservation.isEmpty()) {
                                System.out.println("");

                                Collections.sort(listReservation, new Comparator<Reservation>() {
                                    @Override
                                    public int compare(Reservation o1, Reservation o2) {
                                        String flightNumber1 = o1.getFlight().getFlightNumber();
                                        String flightNumber2 = o2.getFlight().getFlightNumber();
                                        int result = flightNumber1.compareTo(flightNumber2);
                                        return result;
                                    }
                                });
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                                List Reservation                                                                   |");
                                System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +  Flight Status +");
                                System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                int i = 0;
//                System.out.println("SIZE"+listReservation.size());
                                for (Reservation reservation : listReservation) {
                                    System.out.println(String.format("|%12d|%16s|%16s|%16s|%17s|%17s|%17s|%12s|%16s|",
                                            ++i,
                                            reservation.getReservationId(),
                                            reservation.getPassenger().getName().toUpperCase(),
                                            reservation.getPassenger().getPhoneNumber(),
                                            reservation.getPassenger().getCitizenIdentificationCartNumber(),
                                            reservation.getPassenger().getSeatNumber().toUpperCase(),
                                            reservation.getFlight().getFlightNumber().toUpperCase(),
                                            reservation.getStatus(), reservation.getFlight().getStatus()));

                                }
                                System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                System.out.println("");

                            } else {
                                System.out.println("");

                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                                List Reservation                                                                   |");
                                System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +  Flight Status +");
                                System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                System.out.println("+                                                                                                                                                   +");
                                System.out.println("+                                                                    EMPTY LIST                                                                     +");
                                System.out.println("+                                                                                                                                                   +");
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("");

                            }
                            break;
                        case 3:
                            if (!listCrewMember.isEmpty()) {
                                System.out.println("");
                                Collections.sort(listCrewMember, new Comparator<CrewMember>() {
                                    @Override
                                    public int compare(CrewMember o1, CrewMember o2) {
                                        return o1.getFlight().getFlightNumber().compareTo(o2.getFlight().getFlightNumber());
                                    }
                                });

                                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                           List Crew Member                                                             +");
                                System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                                System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                int i = 0;
//                System.out.println("SIZE" + listCrewMember.size());
                                for (CrewMember crewMember : listCrewMember) {
                                    Flight flight = crewMember.getFlight();
                                    String flightNumber = (flight != null) ? flight.getFlightNumber() : "N/A";
                                    System.out.println(String.format("|%12d|%18s|%15s|%20s|%15d|%16d|%16s|%16s +", ++i, crewMember.getCrewMemberId(),
                                            crewMember.getName(),
                                            crewMember.getRole(),
                                            crewMember.getAge(),
                                            crewMember.getYearOfExperient(),
                                            crewMember.getStatus(),
                                            flightNumber));
                                    ;
                                }
                                System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                            } else {
                                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("+                                                           List Crew Member                                                             +");
                                System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                                System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                System.out.println("+                                                                                                                                        +");
                                System.out.println("+                                                               EMPTY LIST                                                               +");
                                System.out.println("+                                                                                                                                        +");
                                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("");

                            }
                            break;
                    }
                } while (subChoice >= 1 && subChoice <= 3);
                roleNow = "Administrator";
                return "Administrator";
            } else {
                String code = tool.inputString("Code Admin:");
                if (code.equals("admin")) {
                    System.out.println("");

                    System.out.println("+------------------------------------+");
                    System.out.println("+ You are accessing by Administrator +");
                    System.out.println("+------------------------------------+");
                    System.out.println("");

                    int subChoice = 0;
                    do {
                        subChoice = menu.getChoiceAdminMenu(listFlight, listReservation, listCrewMember);
                        switch (subChoice) {
                            case 1:
                                if (!listFlight.isEmpty()) {
                                    System.out.println("");
                                    Collections.sort(listFlight, new Comparator<Flight>() {
                                        @Override
                                        public int compare(Flight o1, Flight o2) {
                                            return o2.getDepartureTime().compareTo(o1.getDepartureTime());
                                        }
                                    });
                                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                                     List Flight                                                                             +");
                                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                    System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                    i = 0;
                                    for (Flight flight : listFlight) {
                                        System.out.println(String.format("+%8d|%15s|%22s|%22s|%20s|%18s|%18s|%13d|%12s +", ++i, flight.getFlightNumber(), flight.getDepartureCity().toUpperCase(), flight.getDestinationCity().toUpperCase(),
                                                flight.getDepartureTime().toString(), flight.getArrivalTime().toString(), flight.getAvailableSeats(), flight.getMaxSeats(), flight.getStatus().toUpperCase()));
                                    }
                                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");

                                    System.out.println("");

                                } else {
                                    System.out.println("");

                                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                                     List Flight                                                                             +");
                                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                    System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                                    System.out.println("+                                                                                                                                                             +");
                                    System.out.println("+                                                                          EMPTY LIST                                                                         +");
                                    System.out.println("+                                                                                                                                                             +");
                                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("");

                                }
                                break;
                            case 2:
                                if (!listReservation.isEmpty()) {
                                    System.out.println("");
                                    Collections.sort(listReservation, new Comparator<Reservation>() {
                                        @Override
                                        public int compare(Reservation o1, Reservation o2) {
                                            String flightNumber1 = o1.getFlight().getFlightNumber();
                                            String flightNumber2 = o2.getFlight().getFlightNumber();
                                            int result = flightNumber1.compareTo(flightNumber2);
                                            return result;
                                        }
                                    });
                                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                                List Reservation                                                                   |");
                                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                    System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +  Flight Status +");
                                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                    int i = 0;
//                System.out.println("SIZE"+listReservation.size());
                                    for (Reservation reservation : listReservation) {
                                        System.out.println(String.format("|%12d|%16s|%16s|%16s|%17s|%17s|%17s|%12s|%16s|",
                                                ++i,
                                                reservation.getReservationId(),
                                                reservation.getPassenger().getName().toUpperCase(),
                                                reservation.getPassenger().getPhoneNumber(),
                                                reservation.getPassenger().getCitizenIdentificationCartNumber(),
                                                reservation.getPassenger().getSeatNumber().toUpperCase(),
                                                reservation.getFlight().getFlightNumber().toUpperCase(),
                                                reservation.getStatus(), reservation.getFlight().getStatus().toUpperCase()));

                                    }
                                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                    System.out.println("");

                                } else {
                                    System.out.println("");

                                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                                List Reservation                                                                   |");
                                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                    System.out.println("|   Number   | Reservation Id |      Name      |  Phone Number  |    Id Number    |   Seat Number   |  Flight Number  |   Status   +  Flight Status +");
                                    System.out.println("+------------+----------------+----------------+----------------+-----------------+-----------------+-----------------+------------+----------------+");
                                    System.out.println("+                                                                                                                                                   +");
                                    System.out.println("+                                                                    EMPTY LIST                                                                     +");
                                    System.out.println("+                                                                                                                                                   +");
                                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("");

                                }
                                break;
                            case 3:
                                if (!listCrewMember.isEmpty()) {
                                    System.out.println("");
                                    Collections.sort(listCrewMember, new Comparator<CrewMember>() {
                                        @Override
                                        public int compare(CrewMember o1, CrewMember o2) {
                                            return o1.getFlight().getFlightNumber().compareTo(o2.getFlight().getFlightNumber());
                                        }
                                    });

                                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                           List Crew Member                                                             +");
                                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                    System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                    int i = 0;
//                System.out.println("SIZE" + listCrewMember.size());
                                    for (CrewMember crewMember : listCrewMember) {
                                        Flight flight = crewMember.getFlight();
                                        String flightNumber = (flight != null) ? flight.getFlightNumber() : "N/A";
                                        System.out.println(String.format("|%12d|%18s|%15s|%20s|%15d|%16d|%16s|%16s +", ++i, crewMember.getCrewMemberId(),
                                                crewMember.getName(),
                                                crewMember.getRole(),
                                                crewMember.getAge(),
                                                crewMember.getYearOfExperient(),
                                                crewMember.getStatus().toUpperCase(),
                                                flightNumber.toUpperCase()));
                                        ;
                                    }
                                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                } else {
                                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("+                                                           List Crew Member                                                             +");
                                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                    System.out.println("|   Number   |  Crew Member Id  |      Name     |        Role        |      Age      |  Year Of Exp   |     Status     |  Flight Number  |");
                                    System.out.println("+------------+------------------+---------------+--------------------+---------------+----------------+----------------+-----------------+");
                                    System.out.println("+                                                                                                                                        +");
                                    System.out.println("+                                                               EMPTY LIST                                                               +");
                                    System.out.println("+                                                                                                                                        +");
                                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
                                    System.out.println("");

                                }
                                break;
                        }
                    } while (subChoice >= 1 && subChoice <= 3);

                    roleNow = "Administrator";
                    return "Administrator";
                } else {
                    System.out.println("Wrong Code !");
                    return "";
                }
            }

        }
        return null;
    }

}
