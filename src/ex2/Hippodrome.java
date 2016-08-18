package ex2;


import java.util.Random;
import java.util.Scanner;


/**
* Создал vik24rus. 17.08.2016
 * В учебных целях
*
 */

public class Hippodrome {

    ///////////для менюшки
    public static Scanner scn = new Scanner(System.in);
    public static String com = "";
    public static boolean isRunning = true;
    ///////////для менюшки

    static Bookmaker bookmaker = new Bookmaker();
    static Player player = new Player();
    public static Scanner scngame = new Scanner(System.in); //считывание ввода ставок и номеров лошадей

    static Horse[] horses = new Horse[10]; //сгенерирован массив для объектов лошадей
    static Random random = new Random();

    Sound sound ;



    public static void main(String[] args) {

        Thread myThready = new Thread()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Sound.playSound("/home/vik24rus/IdeaProjects/my_class/src/ex2/sounds/main_theme.wav").join();
            }
        };
        myThready.start();	//Запуск потока

        System.out.println("!!!Super horse racing 1992!!!\nType help to see all commands");
        while (isRunning) {

            scn = new Scanner(System.in);

            System.out.print("Enter command: ");
            com = scn.next();
            checkCommand();

        }
        scn.close();
        scngame.close();
        myThready.stop();
        System.out.println("Вы заработали: " + bookmaker.ALLWIN);
        System.out.println("!!!Super horse racing 1992!!!");

    }

    public static void checkCommand() {
        switch (com.toLowerCase()) {

            case "exit":
                isRunning = false;
                break;

            case "about":
                System.out.println("*********************************************");
                System.out.println("     Делайте ставки, теряйте деньги          ");
                System.out.println("Сделал vik24rus в 2016 году в учебных целях  ");
                System.out.println("*********************************************");
                System.out.println("___________________________________________________________\n" +
                        "___________________________________________________________\n" +
                        "_______________________________________________AIgg________\n" +
                        "__________________________________________gggggggggg_______\n" +
                        "_______________________________________gggggggggggggg______\n" +
                        "____________________________________ggggggggggggggggggg____\n" +
                        "__________ggg____ggggggg__________gggggggggggg_____ggggg___\n" +
                        "_______ggggggggggggggggggggggggggggggggggggggg_____________\n" +
                        "______gggggg__ggggggggggggggggggggggggggggggg______________\n" +
                        "_____gggggg___gggggggggggggggggggggggggggggg_______________\n" +
                        "_____ggggg____ggggggggggggggggggggggggggggg________________\n" +
                        "_____gggg_____Xgggggggggggggggggggggggggggg________________\n" +
                        "____gg_________ggggggggggggggggggggggggggg_________________\n" +
                        "_______________gggggggg_gggggggggggggggggg_________________\n" +
                        "___________gggggggggggg_____________ggggggX________________\n" +
                        "__________hggg____gggg________________ggggg________________\n" +
                        "__________ggR_____ggg___________________gggg_______________\n" +
                        "__________gg_____gggg___________ggg__ggggggggg_____________\n" +
                        "_________ggg______ggg____________gggggg____ggg_____________\n" +
                        "_______gggg_________ggE______________________gg____________\n" +
                        "_______gg____________ggg______________________gg___________\n" +
                        "______________________gggT_____________________ggg_________\n" +
                        "_______________________gggg_____________________ggg________\n" +
                        "___________________________________________________________\n" +
                        "___________________________________________________________\n" +
                        "___________________________________________________________ ");
                break;

            case "help":
                System.out.println("go");
                System.out.println("money");
                System.out.println("bankmoney"); // букмекерские деньги
                System.out.println("history"); //история забегов и потери/получения денег
                System.out.println("help");
                System.out.println("about");
                System.out.println("exit");


                break;
            case "bankmoney":

                System.out.println("Денег у букмекера: " + bookmaker.BookmakerMoney());

                break;

            case "go":

                bookmaker.checkMoney();
                go();

                break;

            case "money":
                System.out.println("Баланс: " + player.viewMoney());
                break;

            case "history":
                bookmaker.seeHistory();
                break;

            default:
                System.out.println("ERROR - Unknown command!");
                break;
        }
    }

    static void go(){

        boolean b1 = true;
        while (b1) {
            System.out.println("У вас: " + player.viewMoney());
            System.out.println("Делайте ставку" );
            try {
                player.giveRate(scngame.nextInt());
                b1 = false;
            }
            catch (java.util.InputMismatchException e) {
                scngame.nextLine();
            }
        }

        boolean b2 = true;
        while (b2) {

            System.out.println("Номер лошади на которую ставите: ");

            try {

                player.giveNumber_win_horse(scngame.nextInt());
                b2 = false;


            }
            catch (java.util.InputMismatchException e) {
                scngame.nextLine();

            }

        }




        for (int i = 0; i < horses.length; i++) { //генерируем свойства лошадей
            horses[i] = new Horse();
            horses[i].name  = horses[i].GenName();
            horses[i].color  = horses[i].GenColor();
            horses[i].age = 4 + random.nextInt(5);
            horses[i].speed = 10 + random.nextInt(30);
            horses[i].speed = horses[i].speed + random.nextInt(6);
            horses[i].isMale = random.nextBoolean();
            horses[i].numberHorse = i ;

        }


        for (int i = 0; i < horses.length; i++) { //еще раз рандом,чтобы исключить одинаковые скорости у лошадей
            for (int j = 9 ; j > i ; j--  ) {     //берем первую ячейку массива и сравниваем с другими,берем вторую и сравниваем.....
                if (horses[i].speed == horses[j].speed) {

                    horses[i].speed = 1 + random.nextInt(5) - random.nextInt(2);
                }
            }
        }


        for (int i = 0; i < horses.length; i++) { //еще раз рандом,чтобы исключить одинаковые скорости у лошадей
            for (int j = 9 ; j > i ; j--  ) {     //берем первую ячейку массива и сравниваем с другими,берем вторую и сравниваем.....
                if (horses[i].speed == horses[j].speed) {

                    horses[i].speed = 1 + random.nextInt(5) - random.nextInt(2);
                }
            }
        }




//        for (int i = 0; i < horses.length; i++) { //проверочка на одинаковые скорости
//            for (int j = 9 ; j > i ; j--  ) {
//                if (horses[i].speed == horses[j].speed) {
//
//                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                }
//            }
//        }




//        for (Horse horse : horses) {
//            horse.ride();
//        }

        bookmaker.MoneyForPlayer(); //считыает, что полагается отдать или забрать у игрока



    }



}
