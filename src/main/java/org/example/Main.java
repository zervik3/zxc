public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Добавление новой записи
        Person person1 = new Person("John Doe", 25);
        personDAO.addPerson(person1);
        System.out.println("Person added: " + person1);

        // Обновление записи
        personDAO.updatePerson(person1.getId(), "John Updated", 30);
        System.out.println("Person updated: " + person1);

        // Получение всех записей
        System.out.println("All persons:");
        personDAO.getAllPersons().forEach(System.out::println);

        // Удаление записи
        personDAO.deletePerson(person1.getId());
        System.out.println("Person deleted");

        // Закрытие DAO
        personDAO.close();
    }
}
