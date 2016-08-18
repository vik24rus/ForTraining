package com.myclass;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ArrayList https://www.youtube.com/watch?v=dQ1sxFvW73c ,Serialization https://www.youtube.com/watch?v=snw4Paafosg
 * https://www.youtube.com/watch?v=FvnJAlXiUB0&index=24&list=PLEvI1OiL1F3ctezdKwvJnQK2f_H8U0HqK конструкторы
 * https://www.youtube.com/watch?v=97bGpUbLGAM&index=25&list=PLEvI1OiL1F3ctezdKwvJnQK2f_H8U0HqK Exceptions
* Пример работы с @Override методами, перегружеными методами
 * this - это вроде обращение имнно к самому классу а не к объектам ???
 * пример меню
 * отказоустойчивая программа с несколькими независимыми потоками https://github.com/Cvazer/Tutorials/tree/master/Demo/Incaps-OOP/src/by/zti/main
* В идеале понять отличие статичного класса от абстрактного и от интерфейса
 * абстрактный класс - это класс не имеющий не одного объекта (экземпляра) этого класса
 * интерфейс - это практически как абстрактный класс только все методы в нем public
 * статичный класс - 1 класс 1 объект, все кто с ним работают должны быть статичны
 *
 * КАК НАЗЫВАЕТСЯ КОГДА ФУНКЦИЯ МОЖЕТ ПРИНИМАТЬ НЕОПРЕДЕЛННОЕ КОЛ-ВО ПАРАМЕТРОВ В СЕБЯ?
 * ОБРАБАТЫВАТЬ ИСКЛЮЧЕНИЯ

*/
// Так можно воспроизводить звук из инета
//
//        URL url = null;
//        try {
//            url = new URL("http://www.downloadfreesound.com/wp-content/uploads/2013/08/Beep1.wav" );
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        AudioClip ac = Applet.newAudioClip(url);
//        ac.play();

public class Main {

    public static Scanner scn = new Scanner(System.in);
    public static String com = "";
    public static String com2 = "";
    public static boolean isRunning = true;


    public static void main(String[] args) { //передача параметров
	    //C3 c = new C3(); демонстрация перезаписи метода
        //c.print(5);

        // сокращения
        // sout + Tab
        // souf
        // Ctrl+D копировать строчку вниз
        // shift + alt и стрелки вниз - вверх -- перетаскивает строку
        // psvm - создать main
        // fori
        // itar - цикл for для массива
        // iter - второй тип цикла для массивов foreach

        //int[] numbers = {1,2,3}; //массив - размер изменить нельзя
        //System.out.println(Arrays.toString(numbers)); // пример вывода

        //int[] numbers;
        //numbers = new  int [100];

//        int[][] cells;
//        cells = new  int [3][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//
//
//            }
//
//        }



        System.out.println("Program starts...\nType /help to see all commands");
        while (isRunning) {
            scn = new Scanner(System.in);
            System.out.println("----------------------||----------------------");
            System.out.print("Enter command: ");
            com = scn.next();
            checkCommand();

        }
        scn.close();
        System.out.println("Exit!");
    }

    public static void checkCommand() {
        switch (com.toLowerCase()) {

            case "/exit":
                isRunning = false;
                break;

            case "/help":
                System.out.println("/help - list of all commands");
                System.out.println("/exit - exit the program");
                System.out.println("/int <Integer> - pass next int to Integers thread");
                System.out.println("/str <String> - pass next string to Strings thread");
                System.out.println("/stats - all threads 'alive' status");
                System.out.println("/revive <'Integer','String'> - restarts named Thread");
                System.out.println("/auto_revive - switches auto revive thread option");

                break;

            case "/int":  //вложенные кейсы - РАБОТАЕТ! :)
                com2 = scn.next();
                    switch (com2.toLowerCase())
                    {
                        case "/int2":
                            System.out.println("int2");
                            break;
                        default:
                            System.out.println("nested default case!!");
                    }

                break;

            case "/str":
                break;

            case "/stats":
                break;

            case "/revive":

                break;

            case "/auto_revive":
                break;

            default:
                System.out.println("ERROR - Unknown command!");
                break;
        }
    }
}
