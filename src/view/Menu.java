/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.CrewMember;
import model.Flight;
import model.Reservation;

/**
 *
 * @author tung
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public int getChoiceBackMenu(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                            Back To Menu                               +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceManageFlight() {
        ArrayList<String> listInfor = new ArrayList<>();
        listInfor.add("Add Crew member");
        listInfor.add("Assign Crew member");
        listInfor.add("Back to Main menu");

        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+         Manage Crew        +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+-----+----------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceFile() {
        ArrayList<String> listInfor = new ArrayList<>();
        listInfor.add("Save To File");
        listInfor.add("Load From File");
        listInfor.add("Back to Main menu");

        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+------------------------------------------------+");
                System.out.println("+         Crew management and assignments        +");
                System.out.println("+-----+------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-41s|", ++i, infor));
                }
                System.out.println("+-----+------------------------------------------+");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public String getChoiceRoleCrew() {
        ArrayList<String> listInfor = new ArrayList<>();
        listInfor.add("Pilot");
        listInfor.add("Flight attendants");
        listInfor.add("Ground staff");

        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+         Select Role        +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+-----+----------------------+");
                System.out.println("You can input 0 to back");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0) {
                        return null;
                    }

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        String role = "";
        if (choice == 1) {
            role = "Pilot";
        } else if (choice == 2) {
            role = "Flight attendants";
        } else {
            role = "Ground staff";
        }
        return role;
    }

    public int getChoice(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                      Flight Management System                         +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceAsk(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+       Continue Input       +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+----------------------------+");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceAskMakeReservation(ArrayList<String> listInfor, ArrayList<Flight> listFlight) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                 Would you like to make a reservation                  +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                try {
                    choice = sc.nextInt();
                                    
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    
                   
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public Flight getRefChoice(ArrayList<Flight> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;

                if (listInfor.isEmpty()) {
                    System.out.println("+-----------------------------------------------------------------------+");
                    System.out.println("+                             List Flight                               +");
                    System.out.println("+-----------------------------------------------------------------------+");
                    System.out.println("+                                                                       +");
                    System.out.println("+                            No Flight Found                            +");
                    System.out.println("+                                                                       +");
                    System.out.println("+-----------------------------------------------------------------------+");
                    return null;
                } else {
                    for (Flight flight : listInfor) {
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
                        if ((!flight.getStatus().equalsIgnoreCase("DONE"))&&quantityPilot >= 1 && quantityGroundStaff >= 1 && quantiyFlightAttendants >= 1) {
                            flight.setStatus("READY");
                        }
                    }

                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                                     List Flight                                                                             +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    System.out.println("+ Number | Flight Number |    Departure City    |     Arrival City     |   Departure Time   +   Arrival Time   |  Available Seat  +  Max Seats  +    Status   +");
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");
                    i = 0;
                    Collections.sort(listInfor, new Comparator<Flight>() {
                        @Override
                        public int compare(Flight o1, Flight o2) {
                            return o1.getDepartureTime().toLocalDate().compareTo(o2.getDepartureTime().toLocalDate());
                        }
                    });
                    for (Flight flight : listInfor) {
                        System.out.println(String.format("+%8d|%15s|%22s|%22s|%20s|%18s|%18s|%13s|%12s +", ++i, flight.getFlightNumber(), flight.getDepartureCity().toUpperCase(), flight.getDestinationCity().toUpperCase(),
                                flight.getDepartureTime().toString(), flight.getArrivalTime().toString(), flight.getAvailableSeats(), flight.getMaxSeats(), flight.getStatus().toUpperCase()));
                    }
                    System.out.println("+--------+---------------+----------------------+----------------------+--------------------+------------------+------------------+-------------+-------------+");

                }
                System.out.println("You can input 0 to back");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");
                }
                try {
                    choice = sc.nextInt();
                    if (choice == 0) {
                        return null;
                    }
                    if( listInfor.get(choice - 1).getStatus().equalsIgnoreCase("DONE")){
                        System.out.println("The flight has done, Please choose another flight");
                        continue;
                    }
                    if (listInfor != null && listInfor.size() == 1 && listInfor.get(0).getAvailableSeats() == 0) {
                        System.out.println("Please cancel your booking because your flight is fully booked");
                        continue;
                    }
                    
                    if (listInfor != null && listInfor.size() == 1 && listInfor.get(0).getStatus().equalsIgnoreCase("DONE")) {
                        System.out.println("Please cancel your booking because your flight has DONE");
                        continue;
                    }
                     if (listInfor != null && listInfor.get(choice-1).getStatus().equalsIgnoreCase("DONE")) {
                        System.out.println("Please choose another flight, The flight has DONE5");
                        continue;
                    }
           
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be Integer");
                    sc.nextLine();

                }
            }
        }
        return listInfor.get(choice - 1);
    }

    public CrewMember getRefChoiceCrewMember(ArrayList<CrewMember> listInfor, Flight flight) {
        int choice = 0;
        

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;

                if (listInfor.isEmpty()) {
                    System.out.println("+-----------------------------------------------------------------------+");
                    System.out.println("+                          List Crew Memeber                            +");
                    System.out.println("+-----------------------------------------------------------------------+");
                    System.out.println("+                                                                       +");
                    System.out.println("+                              No Crew Yet                              +");
                    System.out.println("+                                                                       +");
                    System.out.println("+-----------------------------------------------------------------------+");
                    return null;
                } else {
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                             List Crew Memeber                                                           +");
                    System.out.println("+--------+------------------+------------------------+-----------+-------------------+----------------------+-------------+---------------+");
                    System.out.println("+ Number |  Crew Member Id  |          Name          |    Age    | Year Of Experient |          Role        +   Status    + Flight Number +");
                    System.out.println("+--------+------------------+------------------------+-----------+-------------------+----------------------+-------------+---------------+");
                    
                    Collections.sort(listInfor, new Comparator<CrewMember>() {
                        @Override
                        public int compare(CrewMember o1, CrewMember o2) {
                            return o1.getFlight().getFlightNumber().compareTo(o2.getFlight().getFlightNumber());
                        }
                    });
                    for (CrewMember crewMember : listInfor) {
                        System.out.println(String.format("+%8d|%18s|%24s|%11s|%19s|%22s|%13s|%14s +", ++i, crewMember.getCrewMemberId(), crewMember.getName().toUpperCase(), crewMember.getAge(), crewMember.getYearOfExperient(), crewMember.getRole().toUpperCase(), crewMember.getStatus().toUpperCase(),
                                crewMember.getFlight() == null ? "NOT" : crewMember.getFlight().getFlightNumber().toUpperCase()));
                    }
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------+");

                }
                System.out.println("You can input 0 to back");

                if (listInfor.size() == 0) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");
                }
                try {
                    choice = sc.nextInt();
                    if (choice == 0) {
                        return null;
                    }

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        System.out.println("Your choice must be in range");
                        continue;
                    }
                    if (listInfor.get(choice - 1).getStatus().equalsIgnoreCase("assigned")) {
                        System.out.println("Assign Failed, Crew has been assigned for flight(" + listInfor.get(choice - 1).getFlight().getFlightNumber() + ")");
                        continue;
                    }
                    return listInfor.get(choice - 1);

                } catch (Exception e) {
                    System.out.println("Your choice must be Integer");
                    sc.nextLine();
                }
            }
        }
    }

    public int getChoiceAdmin(String roleNow) {
        ArrayList<String> listInfor = new ArrayList<>();
        listInfor.add("Administrator");
        listInfor.add("User");
        listInfor.add("View data by admin");
        listInfor.add("Back to Main menu");

        int choice = 0;
//        System.out.println("DAY LA "+roleNow);
        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+------------------------------------------------+");
                System.out.println("+                   Accessed by                  +");
                System.out.println("+-----+------------------------------------------+");

                for (String infor : listInfor) {

                    String displayInfor = infor;
                    if (roleNow.equalsIgnoreCase("Administrator") && infor.equalsIgnoreCase("Administrator")) {
                        displayInfor = "Administrator  (Now)";
                    } else if (roleNow.equalsIgnoreCase("User") && infor.equalsIgnoreCase("User")) {
                        displayInfor = "User  (Now)";
                    }
                    System.out.println(
                            String.format("|%3s  | %-41s|", ++i, displayInfor));
                }
                System.out.println("+------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");
                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceAdminMenu(ArrayList<Flight> listFlight, ArrayList<Reservation> listReservation, ArrayList<CrewMember> listCrewMember) {

        ArrayList<String> listInfor = new ArrayList<>();
        listInfor.add("Print List Flight");
        listInfor.add("Print List Reservation");
        listInfor.add("Print List Crew Member");
        listInfor.add("Back to Main menu");

        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------------+");
                System.out.println("+            Data Center           +");
                System.out.println("+-----+----------------------------+");

                for (String infor : listInfor) {
                    String displayInfor = infor;
                    System.out.println(
                            String.format("|%3s  | %-27s|", ++i, displayInfor));
                }
                System.out.println("+-----+----------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");
                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

}
