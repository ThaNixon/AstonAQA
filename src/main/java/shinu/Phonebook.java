package shinu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> book =  new HashMap<>();

    public void add(String surname, String phone) {
        List<String> phones = book.get(surname);
        if (phones == null) {
            phones = new ArrayList<>();
            book.put(surname, phones);
        }
        phones.add(phone);
    }

    public void get(String surname) {
        if (book.containsKey(surname)) {
            System.out.println("Фамилия: " + surname + " | Номера: " + book.get(surname));
        } else {
            System.out.println("Фамилия " + surname + " не найдена в справочнике.");
        }
    }
}

