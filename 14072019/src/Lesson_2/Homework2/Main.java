package Lesson_2.Homework2;

public class Main {
 //   Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо
//        бросить исключение MyArraySizeException.
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива
//        преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException –
//        с детализацией, в какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 public static void main(String[] args) {
  Object[][] arr;
  int sum = 0;
  try {
   arr = initArray(4,4);
  } catch (MyArraySizeException e) {
   e.printStackTrace();
   return;
  }
  for (int i = 0; i < arr.length; i++)
   for (int j = 0; j < arr[i].length; j++) {
    try {
     sum += (int) arr[i][j];
    } catch (RuntimeException e) {
     throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "]не тип int." );
    }
   }
  System.out.println("Сумма массива = " + sum);
 }

 public static Object[][] initArray(int row, int col) throws MyArraySizeException {
  if (row != 4 || col != 4) {
   throw new MyArraySizeException("Массив должен быть 4х4.");
  }
  return new Object[][]{{1,5,4,3},{1,2,3,4}};
 }
}