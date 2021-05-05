import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public boolean add(String name, String number) {
        phoneBook.put(number, name);
        return true;
    }

    public void get(String name) {
        for (Map.Entry<String, String> names : phoneBook.entrySet()) {
            if (names.getValue().equals(name)) {
                System.out.println(name + " " + names.getKey());
            }
        }
    }

}
