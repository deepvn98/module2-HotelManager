package storage;

import model.Person;

import java.io.*;
import java.util.ArrayList;

public class FileManagerPerson {
    private String name;
    private static FileManagerPerson INSTANCE;

    public FileManagerPerson(String name) {
        this.name = name;
    }
    public static FileManagerPerson getINSTANCE(String name) {
        if (INSTANCE == null){
            INSTANCE = new FileManagerPerson(name);
        }return INSTANCE;
    }
//  Ghi File
    public void writeFile(ArrayList<Person> persons) throws IOException {
        File file = new File("Person.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(persons);
        objectOutputStream.close();
        fileOutputStream.close();
    }
//    Đọc file tạo ra một mảng người
    public ArrayList<Person> readFile(String file) throws IOException, ClassNotFoundException {
        if (file.length()>0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            ArrayList<Person> pesons = (ArrayList<Person>) obj;
            objectInputStream.close();
            fileInputStream.close();
            return pesons;
        }else {
            return new ArrayList<>();
        }
    }
}
