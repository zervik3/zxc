import java.io.*;


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }


    public static void serializePerson(Person person, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
        }
    }


    public static Person deserializePerson(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Person) ois.readObject();
        }
    }


    public static void main(String[] args) {
        try {

            Person person = new Person("Alice", 30);
            String filename = "person.ser";


            serializePerson(person, filename);
            System.out.println("Serialized person: " + person);


            Person deserializedPerson = deserializePerson(filename);
            System.out.println("Deserialized person: " + deserializedPerson);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
