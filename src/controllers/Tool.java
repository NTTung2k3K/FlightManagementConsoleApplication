/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author tung
 */
public class Tool {
    // Using scanner for user input from keyboard

    static Scanner sc = new Scanner(System.in);

    /**
     * Get input String and check valid
     *
     * @param msg
     * @return
     */
    public String inputString(String msg) {
        String infor = "";
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();

                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor.trim();
    }

    /**
     * Get input Double and check valid
     *
     * @param msg
     * @return
     */
    public double inputDouble(String msg) {
        double infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
        return infor;
    }

    /**
     * Get input Integer and check valid
     *
     * @param msg
     * @return
     */
    public int inputInt(String msg) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
        return infor;
    }

    public int inputAge(String msg, int min, int max) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();

                if (infor >= min && infor <= max) {
                    return infor;
                } else {
                    System.out.println("Age must in range (" + min + "-" + max + ")");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
    }

    public int inputEOY(String msg, int min, int max, int age) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                int validEOY = age - 18;

                switch (validEOY) {
                    case 0:
                        if (infor == 0) {
                            return infor;

                        } else {
                            System.out.println("You have no experience, You must input 0");
                            continue;
                        }
                    case 1:
                        if (infor <= 1 && infor >= 0) {
                            return infor;
                        } else {
                            System.out.println("Your maximum experience is 1");
                            continue;
                        }
                    default:
                        if (infor >= min && infor <= validEOY) {
                            return infor;
                        } else {
                            System.out.println("Experience must in range (" + min + "-" + validEOY + ")");
                            continue;
                        }
                }

//
//                if  {
//                    return infor;
//                } else {
//                    System.out.println("You have no experience, You must input 0");
//                    continue;
//                }
//                } else 
//                } else if (infor < min && infor > max) {
//                    System.out.println("Experience must in range (" + min + "-" + (age - 18) + ")");
//                    continue;
//                } else {
//                    return infor;
//                }
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
    }

    public Integer inputInteger(String msg) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                return infor;

            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
                return null;
            }
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        boolean isLeapYear = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
        if (year >= 1 && month >= 1 && month <= 12) {
            switch (month) {
                case 1: 
                case 3: 
                case 5: 
                case 7: 
                case 8: 
                case 10: 
                case 12:
                    return (day >= 1 && day <= 31);
                case 4:
                case 6: 
                case 9:
                case 11: 
                    return (day >= 1 && day <= 30);
                case 2: 
                    if (isLeapYear) {
                        return (day >= 1 && day <= 29);
                    } else {
                        return (day >= 1 && day <= 28);
                    }
            }
        }
        return false;
    }

    public LocalDateTime inputDate(String msg) {
        String infor;
        LocalDateTime respond = null;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {

                    if (infor.length() == 10) {
                        String[] date = infor.split("/");
                        int day = Integer.parseInt(date[0]);
                        int month = Integer.parseInt(date[1]);
                        int year = Integer.parseInt(date[2]);
                        if (isValidDate(day, month, year)) {
                            respond = LocalDateTime.of(year, month, day, 0, 0);
                            break;
                        } else {
                            System.out.println("The date is not valid");
                            return null;
                        }
                    } else {
                        System.out.println("Input is not correct form (dd/mm/yyyy)");
                        return null;

                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date");
                return null;
            }
        }
        return respond;
    }

    public LocalDateTime inputDateNotNull(String msg) {
        String infor;
        LocalDateTime respond = null;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {

                    if (infor.length() == 10) {
                        String[] date = infor.split("/");
                        int day = Integer.parseInt(date[0]);
                        int month = Integer.parseInt(date[1]);
                        int year = Integer.parseInt(date[2]);
                        if (isValidDate(day, month, year)) {
                            respond = LocalDateTime.of(year, month, day, 0, 0);
                            break;
                        } else {
                            System.out.println("The date is not valid");
                        }
                    } else {
                        System.out.println("Input is not correct form (dd/mm/yyyy)");
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date");
                sc.nextLine();
            }
        }
        return respond;
    }

    public String inputCity(String msg) {
        String infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                    continue;
                } else if (!infor.matches("^[^\\d]+$")) {
                    System.out.println("City name do not contain number");
                    continue;
                } else {
                    return infor;
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date");
                sc.nextLine();
            }
        }
    }

    public boolean isValidTime(int hour, int minutes) {
        return hour >= 0 && hour <= 24 && minutes >= 0 && minutes <= 60;
    }

    public LocalDateTime inputTime(String msg) {
        String infor;
        LocalDateTime respond;
        while (true) {
            System.out.print(msg);
            try {
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {
                    if (infor.length() == 5) {
                        String[] time = infor.split(":");
                        int hour = Integer.parseInt(time[0]);
                        int minutes = Integer.parseInt(time[1]);
                        if (isValidTime(hour, minutes)) {
                            respond = LocalDateTime.of(1, 1, 1, hour, minutes);
                            break;
                        } else {
                            System.out.println("The input must follow the format hh(0-23) and mm(0-59)");
                            return null;
                        }
                    } else {
                        System.out.println("Input is not correct form (hh:mm)");
                        return null;
                    }
                }

            } catch (Exception e) {
                System.out.println("The input must follow the format hh(0-23) and mm(0-59)");
                return null;
            }

        }
        return respond;
    }

    public String inputPhoneNumber(String msg) {
        String infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {
                    if (infor.length() == 10 && infor.matches("^[0-9]+$")) {
                        break;
                    } else {
                        System.out.println("Phone number is max-length(10) and only accept number");
                        return null;

                    }
                }

            } catch (Exception e) {
                System.out.println("Phone number is max-length(10) and only accept number");
                return null;
            }
        }
        return infor.trim();
    }

    public String inputIdNumber(String msg) {
        String infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if (infor.equals("")) {
                    System.out.println("Input is not a blank");
                } else {
                    if (infor.length() == 12 && infor.matches("^[0-9]+$")) {
                        break;
                    } else {
                        System.out.println("Citizen identification card number is max-length(12) and only accept number");
                        return null;

                    }
                }

            } catch (Exception e) {
                System.out.println("Citizen identification card number is max-length(12) and only accept number");
                return null;
            }
        }
        return infor.trim();
    }

}
