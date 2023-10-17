/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.FlightManage;
import controllers.Tool;
import java.util.ArrayList;

/**
 *
 * @author tung
 */
public class Main {

    public static void main(String[] args) {
        FlightManage flightManage = new FlightManage();
        Menu menu = new Menu();

        ArrayList<String> listMenu = new ArrayList<>();
        listMenu.add("Flight schedule management");
        listMenu.add("Passenger reservation and booking");
        listMenu.add("Passenger check-in and seat allocation");
        listMenu.add("Crew management and assignments");
        listMenu.add("Administrator access for system management");
        listMenu.add("Data storage for flight details, reservations, and assignments");
        listMenu.add("Quit");

        ArrayList<String> ask = new ArrayList<>();
        ask.add("Continue");
        ask.add("Back To Menu");
        String role = "";
        int choice = 0;
        do {
            choice = menu.getChoice(listMenu);
            switch (choice) {
                case 1:
                    int choiceSub;

                    if (role.equalsIgnoreCase("Administrator")) {
                        flightManage.addFlight();
                        do {
                            // ask User want to continue or back to menu
                            System.out.println("______________________________________");
                            choiceSub = menu.getChoiceBackMenu(ask);
                            switch (choiceSub) {
                                case 1:
                                    flightManage.addFlight();
                                    break;
                            }
                        } while (choiceSub > 0 && choiceSub < ask.size());
                        break;
                    } else {
                        System.out.println("You must select Administrator(5) access to use the function");
                        break;
                    }

                case 2:

                    if (role.equalsIgnoreCase("User")) {

                        flightManage.makeReservation();
                        choiceSub = 0;
                        do {
                            // ask User want to continue or back to menu
                            System.out.println("______________________________________");
                            choiceSub = menu.getChoiceBackMenu(ask);
                            switch (choiceSub) {
                                case 1:
                                    flightManage.makeReservation();
                                    break;
                            }
                        } while (choiceSub > 0 && choiceSub < ask.size());
                        break;

                    } else {
                        System.out.println("You must select User(5) access to use the function");
                        break;
                    }

                case 3:
                    if (role.equalsIgnoreCase("User")) {
                        flightManage.checkIn();
                        choiceSub = 0;
                        do {
                            // ask User want to continue or back to menu
                            System.out.println("______________________________________");
                            choiceSub = menu.getChoiceBackMenu(ask);
                            switch (choiceSub) {
                                case 1:
                                    flightManage.checkIn();
                                    break;
                            }
                        } while (choiceSub > 0 && choiceSub < ask.size());
                        break;

                    } else {
                        System.out.println("You must select User(5) access to use the function");
                        break;
                    }

                case 4:
                    int subChoiceUpdate;
                    if (role.equalsIgnoreCase("Administrator")) {
                        do {
                            System.out.println("______________________________________");
                            subChoiceUpdate = menu.getChoiceManageFlight();
                            switch (subChoiceUpdate) {
                                case 1:
                                    flightManage.addCrew();
                                    do {
                                        System.out.println("______________________________________");
                                        // ask User want to continue or back to menu
                                        choiceSub = menu.getChoiceBackMenu(ask);
                                        switch (choiceSub) {
                                            case 1:
                                                flightManage.addCrew();

                                                break;
                                        }
                                    } while (choiceSub > 0 && choiceSub < ask.size());
                                    break;
                                case 2:
                                    flightManage.manageCrewAssignment();
                                    do {
                                        System.out.println("______________________________________");
                                        // ask User want to continue or back to menu
                                        choiceSub = menu.getChoiceBackMenu(ask);
                                        switch (choiceSub) {
                                            case 1:
                                                flightManage.manageCrewAssignment();
                                                break;
                                        }
                                    } while (choiceSub > 0 && choiceSub < ask.size());
                                    break;
                            }
                        } while (subChoiceUpdate >= 1 && subChoiceUpdate < 3);
                        break;

                    } else {
                        System.out.println("You must select Administrator(5) access to use the function");
                        break;
                    }

                case 5:
                    String temp;
                    temp = flightManage.administratorAccess(role);
                    if (temp != null) {
                        role = temp;
//                        System.out.println("DAY NE" + role);
                    } else {
                        System.out.println("You must select access rights to use the function");
                    }
                    break;
                case 6:
                    subChoiceUpdate = 0;
                    if (role.equalsIgnoreCase("Administrator")) {
                        do {
                            System.out.println("______________________________________");
                            subChoiceUpdate = menu.getChoiceFile();
                            switch (subChoiceUpdate) {
                                case 1:
                                    flightManage.saveToFileFlight();
                                    flightManage.saveToFilePassenger();
                                    flightManage.saveToFileCrewMember();

                                    choiceSub = 0;
                                    do {
                                        // ask User want to continue or back to menu
                                        System.out.println("______________________________________");
                                        choiceSub = menu.getChoiceBackMenu(ask);
                                        switch (choiceSub) {
                                            case 1:
                                                flightManage.saveToFileFlight();
                                                flightManage.saveToFilePassenger();
                                                flightManage.saveToFileCrewMember();
                                                break;
                                        }
                                    } while (choiceSub > 0 && choiceSub < ask.size());
                                    break;
                                case 2:
                                    flightManage.loadFromFileFlight();
                                    flightManage.loadFromFilePassenger();
                                    flightManage.loadFromFileCrewMember();

                                    choiceSub = 0;
                                    do {
                                        // ask User want to continue or back to menu
                                        System.out.println("______________________________________");
                                        choiceSub = menu.getChoiceBackMenu(ask);
                                        switch (choiceSub) {
                                            case 1:
                                                flightManage.loadFromFileFlight();
                                                flightManage.loadFromFilePassenger();
                                                flightManage.loadFromFileCrewMember();
                                                break;
                                        }
                                    } while (choiceSub > 0 && choiceSub < ask.size());
                                    break;
                            }
                        } while (subChoiceUpdate >= 1 && subChoiceUpdate < 3);
                    } else {
                        System.out.println("You must select Administrator(5) access to use the function");
                        break;
                    }

            }
        } while (choice > 0 && choice < listMenu.size());
    }
}
