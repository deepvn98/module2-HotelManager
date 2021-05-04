package controller;

import model.Person;
import model.Room;
import storage.FileManagerRoom;
import view.Client;

import java.io.IOException;
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

    public void addPersonAtRoom(String id, int dayInHotel) throws IOException {
        getPersonByID(id);
        if (getPersonByID(id) == null) {
            System.err.print("Không tồn tại");
        }
        if (getPersonByID(id) != null) {
            getRoom();
            if (getRoom() != null) {
                getRoom().setNumberdayinhotel(dayInHotel);
                getRoom().setPerson(getPersonByID(id));
                FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
                fileManagerRoom.writeFile(rooms);
            }
        }

    }

    //    thêm người vào mảng người
    public ArrayList<Person> addPerson(Person person) {
        persons.add(person);
        return persons;
    }

    //    Tìm người trong mảng người bằng id
    public Person getPersonByID(String id) {
        Person person = null;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equalsIgnoreCase(id)) {
                person = persons.get(i);
                return person;
            }
        }
        return null;
    }

    //    Thêm phòng vào mảng phòng
    public ArrayList<Room> addRoom(Room r) {
        rooms.add(r);
        return rooms;
    }

    //    Tìm phòng trống
    public Room getRoom() {
        Room room = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getPerson() == null) {
                room = rooms.get(i);
                return room;
            }
        } return null;
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
