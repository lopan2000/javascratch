package langfeatures.serialization;

import java.io.*;
import java.util.PriorityQueue;

/**
 * Password field is transient to avoid serialization
 */
public class Serialization {

    public static void main(String[] args) throws Exception {

        User user = new User("Jason", "pw123");
        System.out.println(user);

        String filename = "user.ser";
        serialize(user, filename);
        deserialize(filename);
    }

    private static void serialize(User user, String filename) {
        System.out.println("Serializing...");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./src/langfeatures/serialization/" + filename))) {
            oos.writeObject(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserialize(String filename) {
        System.out.println("Deserializing...");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            User user = (User) ois.readObject();
            ois.close();
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class User implements Serializable {

        private static final long serialVersionUID = 1L;

        private String username;
        private transient String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}

