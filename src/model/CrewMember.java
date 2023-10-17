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
public class CrewMember {
    private Flight flight;
    private String role;
    private String name;
    private int yearOfExperient;
    private int age;
    private String status;
    private String crewMemberId;

    public CrewMember(String crewMemberId,Flight flight, String role, String name, int yearOfExperient, int age, String status) {
        this.flight = flight;
        this.role = role;
        this.name = name;
        this.yearOfExperient = yearOfExperient;
        this.age = age;
        this.status = status;
        this.crewMemberId = crewMemberId;
    }

    public String getCrewMemberId() {
        return crewMemberId;
    }

    public void setCrewMemberId(String crewMemberId) {
        this.crewMemberId = crewMemberId;
    }
    

    public CrewMember() {
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfExperient() {
        return yearOfExperient;
    }

    public void setYearOfExperient(int yearOfExperient) {
        this.yearOfExperient = yearOfExperient;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CrewMember{" + "flight=" + flight + ", role=" + role + ", name=" + name + ", yearOfExperient=" + yearOfExperient + ", age=" + age + ", status=" + status + '}';
    }
    public String toFileString(){
        String displayFN;
        if(flight.getFlightNumber()==null){
            displayFN = "N/A";
        }else{
            displayFN = flight.getFlightNumber();
        }
        return crewMemberId+", "+name+", "+role+", "+age+", "+yearOfExperient+", "+displayFN+", "+status;
    }
    
    
 
    
    
    
}
