package controller;

import model.Person;
import model.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHotel {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Person> persons;

    public ManagerHotel() {
    }

    public ManagerHotel(String name, ArrayList<Room> rooms, ArrayList<Person> persons) {
        this.name = name;
        this.rooms = rooms;
        this.persons = persons;
    }
    public void addPersonAtRoom(){

    }
//    thêm người vào mảng người
    public ArrayList<Person> addPerson(Person person){
        persons.add(person);
        return persons;
    }
//    Thêm phòng vào mảng phòng
    public ArrayList<Room> addRoom(Room r){
        rooms.add(r);
        return rooms;
    }
//    Thêm người vào phòng
    public void addPersonatRoom(Person person){
       for (int i = 0; i< rooms.size();i++){
           if (rooms.get(i).getPerson() == null){
               rooms.get(i).setPerson(person);
               break;
           }
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}
