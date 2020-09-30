import Mistakes.*;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;
    final String nameSurNameRegEx = "^[а-яА-яa-zA-Z\\-]*$";
    final String phoneRegEx = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    final String emailRegEx = "^(.+)@(.+)$";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws RuntimeException {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Неверный формат. Образец: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[0].matches(nameSurNameRegEx)) {
            throw new FioException("Ошибка! Введите корректное Имя!");
        }
        if (!components[1].matches(nameSurNameRegEx)) {
            throw new FioException("Ошибка! Введите корректную Фамилию");
        }
        if (!components[2].matches(emailRegEx)) {
            throw new MailFormatException("Ошибка! Введите корректный email!");
        }

        if (!components[3].matches(phoneRegEx)) {
            throw new PhoneFormatException("Ошибка! Введите корректный номер телефона!");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
        System.out.println("Работник успешно добавлен!");

    }

    public void listCustomers() throws EmptyListException {
        if (storage.isEmpty()) {
            throw new EmptyListException("Список работников пуст!");
        }
        storage.values().forEach(System.out::println);
    }
    
    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new ParameterCheckException("Ошибка! В базе нет такой записи для удаления!");
        }
    }

    public int getCount() {
        return storage.size();
    }
}