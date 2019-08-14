/*
package Lesson5;

public class lesson5 {

    static final int size = 10000000;
    static final int h = size / 2;

    //2) Заполняют этот массив единицами;
    //3) Засекают время выполнения: long a = System.currentTimeMillis();
    //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //5) Проверяется время окончания метода System.currentTimeMillis();
    //6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
    //Отличие первого метода от второго:
    //Первый просто бежит по массиву и вычисляет значения.
    //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    //Пример деления одного массива на два:
    //
    //System.arraycopy(arr, 0, a1, 0, h);
    //System.arraycopy(arr, h, a2, 0, h);
    //Пример обратной склейки:
    //
    //System.arraycopy(a1, 0, arr, 0, h);
    //System.arraycopy(a2, 0, arr, h, h);
    //Примечание:
    //System.arraycopy() – копирует данные из одного массива в другой:
    //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
    //По замерам времени:
    //Для первого метода надо считать время только на цикл расчета:
    //
    //for (int i = 0; i < size; i++) {
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //}
    //
    //Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
    public void firstMetod()
    {
        //1) Создают одномерный длинный массив, например:
        float[] arr = new float[size];
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        //3) Засекают время выполнения:
        long a = System.currentTimeMillis();
        //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        //5) Проверяется время окончания метода System.currentTimeMillis();
        //В консоль выводится время работы:
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void secondMetod()
    {
        //1) Создают одномерный длинный массив, например:
        float[] arr = new float[size];
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        //3) Засекают время выполнения:
        long a = System.currentTimeMillis();


        //////////////////////////////////////////////////////////
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++)
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++)
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////////////////////////


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void thirdMetod()
    {
        //1) Создают одномерный длинный массив, например:
        float[] arr = new float[size];
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        //3) Засекают время выполнения:
        long a = System.currentTimeMillis();


        //////////////////////////////////////////////////////////
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
       // Thread t1 = new Thread(new MyRunnableClasss(a1));
        //Thread t2 = new Thread(new MyRunnableClasss(a1));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////////////////////////


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void forthMetod()
    {
        //1) Создают одномерный длинный массив, например:
        float[] arr = new float[size];
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        //3) Засекают время выполнения:
        long a = System.currentTimeMillis();


        //////////////////////////////////////////////////////////
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
        Thread t1 = new Thread(new MyThread(a1));
        Thread t2 = new Thread(new MyThread(a1));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////////////////////////


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public static void main(String[] args) {
        lesson5 les5 = new lesson5();
        //1. Необходимо написать два метода
        System.out.println("Первый метод");
        les5.firstMetod();
        System.out.println("Второй метод");
        les5.secondMetod();
        System.out.println("Третий метод");
        les5.thirdMetod();
        System.out.println("Четвертый метод");
        les5.forthMetod();
    }
}*/
