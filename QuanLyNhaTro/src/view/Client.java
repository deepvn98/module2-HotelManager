package view;

import controller.ManagerHotel;
import model.Person;
import model.Room;
import storage.FileManagerPerson;
import storage.FileManagerRoom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        FileManagerRoom managerRoom = FileManagerRoom.getINSTANCE("Sáng");
        FileManagerPerson managerPerson = FileManagerPerson.getINSTANCE("Sáng");
        ArrayList<Person> persons = new ArrayList<>();
        try {
           persons = managerPerson.readFile("person.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            rooms = managerRoom.readFile("room.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ManagerHotel hotel = new ManagerHotel("Sáng",rooms,persons);
//  Thêm người vào mảng người
//        hotel.addPerson( nhapTTPerson());
//        try {
//            managerPerson.writeFile(persons);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (Person p:persons
//             ) {
//            System.out.println(p);
//        }
//Thêm room vào mảng room
//        hotel.addRoom(nhapTTRoom());
//        try {
//            managerRoom.writeFile(rooms);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (Room r:rooms
             ) {
            System.out.println(r);
        }
    }
    public static Person nhapTTPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int age = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = scanner2.nextLine();
        Person person = new Person(name,age,id);
        return person;
    }
    public static Room nhapTTRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Room name: ");
        String name = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Type Room: ");
        String typeRoom = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter PriceRoom: ");
        double price = scanner2.nextDouble();
        Room room = new Room(name,typeRoom,price);
        return room;
    }
}
