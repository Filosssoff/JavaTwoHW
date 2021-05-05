import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class JavaTwoHW3 {

    public static void main(String[] args) {
        ArrayList <String> wordsList = new ArrayList<>();
        wordsList.add("Word1");
        wordsList.add("I");
        wordsList.add("do");
        wordsList.add("not");
        wordsList.add("know");
        wordsList.add("what");
        wordsList.add("should");
        wordsList.add("I");
        wordsList.add("write");
        wordsList.add("here");
        wordsList.add("Let");
        wordsList.add("this");
        wordsList.add("be");
        wordsList.add("something");
        wordsList.add("not");
        wordsList.add("so");
        wordsList.add("random");
        wordsList.add("that");
        wordsList.add("I");
        wordsList.add("wrote");
        wordsList.add("to");
        wordsList.add("this");
        wordsList.add("list");

        writeUnique(wordsList);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Testo1", "123");
        phoneBook.add("Testo1", "234");
        phoneBook.add("Testo2", "456");
        phoneBook.add("Testo2", "457");
        phoneBook.add("Testo3", "426");
        phoneBook.add("Testo4", "356");
        phoneBook.get("Testo1");
        phoneBook.get("Testo2");
        phoneBook.get("Testo3");
        phoneBook.get("Testo4");

    }

    public static void writeUnique (ArrayList<String> arrayList) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(arrayList);
        ArrayList<String> setList = new ArrayList<>();
        setList.addAll(set);

        for (int ind = 0; ind < setList.size(); ind++) {
            int counter = 0;
            for (int ind2 = 0; ind2 < arrayList.size(); ind2++) {
                if (setList.get(ind) == (arrayList.get(ind2))) counter++;
            }
            System.out.println(setList.get(ind) + " " + counter);
        }

    }

    public static void countWords (ArrayList<String> arrayList) {

    }
}
