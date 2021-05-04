package model;

import java.io.Serializable;

public class Room implements Serializable {
    private String name;
    private int numberdayinhotel;
    private String typeRoom;
    private double roomPrice;
    private Person person;
    public Room() {
    }


    public Room(Person person, int numberdayinhotel, String typeRoom, double roomPrice) {
        this.person = person;
        this.numberdayinhotel = numberdayinhotel;
        this.typeRoom = typeRoom;
        this.roomPrice = roomPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room(String name, String typeRoom, double roomPrice) {
        this.name = name;
        this.typeRoom = typeRoom;
        this.roomPrice = roomPrice;
    }

    public Room(String name, int numberdayinhotel, String typeRoom, double roomPrice, Person person) {
        this.name = name;
        this.numberdayinhotel = numberdayinhotel;
        this.typeRoom = typeRoom;
        this.roomPrice = roomPrice;
        this.person = person;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNumberdayinhotel(int dayInHotel) {
        return numberdayinhotel;
    }

    public void setNumberdayinhotel(int numberdayinhotel) {
        this.numberdayinhotel = numberdayinhotel;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }
    public double getAmountMoney(){
        return numberdayinhotel * roomPrice;
    }
    public void showInfor(){
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s",name,numberdayinhotel,typeRoom,roomPrice,person);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", numberdayinhotel=" + numberdayinhotel +
                ", typeRoom='" + typeRoom + '\'' +
                ", roomPrice=" + roomPrice +
                ", person=" + person +
                '}';
    }
}
