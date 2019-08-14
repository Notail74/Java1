package Lesson3;

import java.util.HashMap;

public class Cars {
    //Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
    public static void main(String[] args) {
        //2 решение ДЗ
        String[] cars = {"Volvo", "VAG", "BMW", "Volvo"};
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
    }
}
