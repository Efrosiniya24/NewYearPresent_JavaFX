package Model.User;

import java.io.*;
import java.util.List;

public class SerializatorAuthorization {
    public static void serialization(List<User> users) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("LoginPassword");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static List<User> deserialization() throws IOException, ClassNotFoundException {
        List<User> users = null;
        try (FileInputStream fileInputStream = new FileInputStream("LoginPassword");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            users = (List<User>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return users;
    }
}
