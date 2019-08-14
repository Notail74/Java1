package Lesson3;

import java.util.HashMap;

// Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
public class Main {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "Volkswagen","BMW","Audi","Mersedes - benz", "Honda","Subaru","Lexus","Ford","Jeep","Mersedes - benz","Honda","Subaru"};
        HashMap<String, Integer> service = new HashMap<>();
        for (String car : cars) {
            Integer carsInMap = service.get(car);
            if (carsInMap == null) {
                service.put(car, 1);
            } else {
                service.put(car, carsInMap + 1);
            }
        }
        System.out.println(service);

//Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
        Phonebook book = new Phonebook();
        book.addContact("Василий", "346588");
        book.addContact("Роман", "985887");
        book.addContact("Максим", "248556");
        book.addContact("Олег", "588669");
        book.addContact("Олег", "133528");

        book.findAndPrint("Василий");
        book.findAndPrint("Роман");
        book.findAndPrint("Максим");
        book.findAndPrint("Олег");
    }



}
