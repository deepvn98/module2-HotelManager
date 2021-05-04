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
        FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("sáng");
        FileManagerPerson fileManagerPerson = FileManagerPerson.getINSTANCE("sáng");
        ArrayList<Person> persons = new ArrayList<>();
        try {
            persons = fileManagerPerson.readFile("person.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            rooms = fileManagerRoom.readFile("room.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ManagerHotel hotel = new ManagerHotel("Sáng", rooms, persons);

//        Thêm phòng và người thêu vào dánh sách
        menuAddPersonAndRoom(hotel,fileManagerRoom,fileManagerPerson,persons,rooms);
//        Gọi phương thức thêm người vào phòng
        menuhotelManager(hotel,rooms);
//        for (Room r : rooms
//        ) {
//            System.out.println(r);
//        }

    }

    public static void menuAddPersonAndRoom(ManagerHotel hotel,
                                            FileManagerRoom fileManagerRoom,
                                            FileManagerPerson fileManagerPerson,
                                            ArrayList<Person> persons,
                                            ArrayList<Room> rooms) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1: Để thêm người muốn thuê trọ:");
        System.out.println("Nhập 2: Để thêm mới phòng trọ:");
        System.out.println("Nhập 3: Để thoát menu:");

        int number = 0;
        boolean check = true;
        do {
            System.out.print(" Nhập vào lựa chọn của bạn:");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.print(" Nhập số lượng người muốn thuê trọ: ");
                    Scanner scanner1 = new Scanner(System.in);
                    number = scanner1.nextInt();
                    int arr[] = new int[number];
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("Người thứ " + (i + 1));
                        System.out.println();
                        hotel.addPerson(nhapTTPerson());
                        try {
                            fileManagerPerson.writeFile(persons);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print(" Nhập số lượng phòng trọ: ");
                    Scanner scanner2 = new Scanner(System.in);
                    number = scanner2.nextInt();
                    int arr[] = new int[number];
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("Phòng thứ " + (i + 1));
                        System.out.println();
                        hotel.addRoom(nhapTTRoom());
                        try {
                            fileManagerRoom.writeFile(rooms);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                }
                case 3: {
                    check = false;
                    break;
                }
            }
        } while (check);

    }

    //    Menu
    public static void menuhotelManager(ManagerHotel hotel,ArrayList<Room>rooms) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhấn 1: thêm người vào phòng");
        System.out.println("Nhấn 2: ");
        System.out.println("Nhấn 3: Xoá thông tin khách trọ ");
        System.out.println("Nhấn 4: hiển thị thông tin khách trọ:");
        System.out.println("Nhấn 5: tính tiền khách phải trả:");
        System.out.println("Nhấn 5: Thoát menu:");
        boolean check = true;
        do {
            System.out.print("Nhập sự lựa chọn:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Nhập id khách hàng:");
                    String id = scanner1.nextLine();
                    System.out.print("Số ngày khách muốn ở: ");
                    Scanner scanner2 = new Scanner(System.in);
                    int dayInHotel = scanner2.nextInt();
                    try {
                        hotel.addPersonAtRoom(id, dayInHotel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    for (Room r : rooms
                    ) {
                        System.out.println(r);
                    }
                    break;
                }
                case 5: {
                    check = false;
                    break;
                }
            }
        } while (check);
    }

    //    Nhâp thông tin người
    public static Person nhapTTPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int age = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = scanner2.nextLine();
        Person person = new Person(name, age, id);
        return person;
    }

    //    Nhập thông tin room
    public static Room nhapTTRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Room name: ");
        String name = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Type Room: ");
        String typeRoom = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter PriceRoom: ");
        double price = scanner2.nextDouble();
        Room room = new Room(name, typeRoom, price);
        return room;
    }
}
