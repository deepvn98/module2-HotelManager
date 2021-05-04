package storage;

import model.Room;

import java.io.*;
import java.util.ArrayList;

public class FileManagerRoom {
    String name;
    private static FileManagerRoom INSTANCE;

    private FileManagerRoom(String name) {
        this.name = name;
    }
//    Tạo ra duy nhất một đối tượng
    public static FileManagerRoom getINSTANCE(String name){
        if (INSTANCE == null){
            INSTANCE = new FileManagerRoom(name);

        }return INSTANCE;
    }
//    viết File
    public void writeFile(ArrayList<Room> rooms) throws IOException {
        File file = new File("room.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(rooms);
        objectOutputStream.close();
        outputStream.close();
    }
//    Đọc file tạo ra một mảng rooms
    public ArrayList<Room> readFile(String file) throws IOException, ClassNotFoundException {
        File f = new File(file);
        if(!f.exists()) f.createNewFile();
        if ( file.length()> 0){
            FileInputStream  fileInputStream = new FileInputStream(file);
            if (fileInputStream != null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                if (objectInputStream != null){
                Object obj = objectInputStream.readObject();
                ArrayList<Room> rooms = (ArrayList<Room>) obj;
                objectInputStream.close();
                fileInputStream.close();
                return rooms;}
            }
            return new ArrayList<>();
        }else {
            return new ArrayList<>();
        }
    }
}
