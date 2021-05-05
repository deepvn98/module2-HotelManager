package controller;

import model.Person;
import model.Room;
import storage.FileManagerPerson;
import storage.FileManagerRoom;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerHotel {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Person> persons = new ArrayList<>();

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
                persons.remove(getPersonByID(id));
                FileManagerPerson fileManagerPerson = FileManagerPerson.getINSTANCE("Sáng");
                fileManagerPerson.writeFile(persons);
                FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
                fileManagerRoom.writeFile(rooms);
            }
        }

    }

    //    thêm người vào mảng người
    public ArrayList<Person> addPerson(Person person) throws IOException {
        persons.add(person);
        FileManagerPerson fileManagerPerson = FileManagerPerson.getINSTANCE("Sáng");
        fileManagerPerson.writeFile(persons);
        return persons;
    }
//    Tìm người trong mảng người
    public boolean findPersonInPersons(String id){
        boolean check = false;
        for (int i = 0; i< persons.size();i++){
            if (persons.get(i).getId().equalsIgnoreCase(id)){
                check = true;
                return check;
            }
        }return check;
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
    public ArrayList<Room> addRoom(Room r) throws IOException {
        rooms.add(r);
        FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
        fileManagerRoom.writeFile(rooms);
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
        }
        return null;
    }

    //    Xoá người trong phòng
    public void removePersonAtRoom(String id) throws IOException {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getPerson()!=null){
                if (rooms.get(i).getPerson().getId().equals(id)) {
                    rooms.get(i).setNumberdayinhotel(0);
                    rooms.get(i).setPerson(null);
                    FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
                    fileManagerRoom.writeFile(rooms);
                }
            }else {
                System.out.println("không có người này trong khách sạn");
            }

        }
    }

    //    Tính tiền khách ở trọ
    public void getAmountMoney(String id) throws IOException {
        double money = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getPerson()!=null){
                if (rooms.get(i).getPerson().getId().equalsIgnoreCase(id)) {
                    money = rooms.get(i).getAmountMoney();
                    rooms.get(i).setPerson(null);
                    rooms.get(i).setNumberdayinhotel(0);
                    FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
                    fileManagerRoom.writeFile(rooms);
                    System.out.println("Số tiền phải thanh toán là:" + money);
                    break;
                }
            }
        }
    }
//   Kiểm tra có người trong phòng không
    public boolean getPersonAtRoom(String id) {
        boolean check = false;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getPerson()!=null){
                if (rooms.get(i).getPerson().getId().equals(id)) {
                    check = true;
                    return check;
                }
            }
        }return check;
    }
//    sửa thông tin người trong phòng
    public void editPersonAtRoom(String id,Person person,int numberInRoom){
        for (int i = 0; i< rooms.size();i++){
            if (rooms.get(i).getPerson().getId().equals(id)){
                rooms.get(i).setPerson(person);
                rooms.get(i).setNumberdayinhotel(numberInRoom);
                FileManagerRoom fileManagerRoom = FileManagerRoom.getINSTANCE("Sáng");
                try {
                    fileManagerRoom.writeFile(rooms);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
    public void showPerson(){
        if (persons.size()<=0){
            System.out.println("Hiện tại không có người đăng ký thuê phòng");
        }
        if (persons.size()>0){
            for (Person p:persons
            ) {
                System.out.println(p.toString());
            }
        }

    }
    public void showRoom(){
        for (Room r:rooms
        ) {
            System.out.println(r.toString());
        }
    }

}
