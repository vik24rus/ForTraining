package ex2;

import static ex2.Hippodrome.horses;

/**
 * Created by se4 on 16.08.16.
 */
public class Bookmaker {

    double money = 10000;
    int numberRealWinHorse = 0;
    int max_speed;
    int ALLWIN;
    static Player player = new Player();

    static Hippodrome hippodrome;
    Sound sound;

    double[]history_win_lose = new double [1000]; // история ставок
    int history_count = 0;

    void MoneyForPlayer(){

        checkMoney();

//////////////////////////////////////////////////////////////////
        for (int i = 0; i < horses.length; i++){
            System.out.println("Номер лошади: " + (horses[i].numberHorse +1) + " || Cкорость в забеге: "  + horses[i].speed);

        }
////////////////////////////////////////////////////////////////////
        max_speed = horses[0].speed;

        for (int i = 0; i < horses.length; i++){                //определим лошадь победительницу

            if(horses[i].speed > max_speed)
            {
                max_speed = horses[i].speed;
                numberRealWinHorse = horses[i].numberHorse;


            }
        }

//        for (int i = 0; i < horses.length; i++) {  //не хватает моих знаний многопооточности для одновременного вывода лошадей в консоль
//            horses[i].render();
//            System.out.println();
//        }


        for (int i = 0; i < horses.length; i++){

            if(horses[i].speed == 0)
            {
                System.out.println("К сожалению лошаде с номером" + horses[i].numberHorse + " прострелили колена и она не участвовала в гонке");
                System.out.println("И еще к большему сожалению она не сможет стать искателем приключений");
            }
        }

       if( (numberRealWinHorse + 1) == player.giveNumber_win_horse()){
           System.out.println("YOUR WIN!!!");
           System.out.println("Победила лошадь с номером: " + (numberRealWinHorse + 1));
           player.giveMoney(player.rate * 2);
           money = money - (player.rate * 2);

           history_count++;
           ALLWIN = ALLWIN + ( player.rate * 2 ) ;
           history_win_lose[history_count] = player.viewMoney() - (player.rate * 2);
           Sound.playSound("/home/vik24rus/IdeaProjects/my_class/src/ex2/sounds/viktory.wav").join();


       }else{
           System.out.println("YOUR LOOS");
           System.out.println("Победила лошадь с номером: " + (numberRealWinHorse + 1));
           System.out.println("Вы ставили на номер: " + player.giveNumber_win_horse());
           money = money + (player.rate * 2);
           player.playerLoos();

           history_count++;

           ALLWIN = ALLWIN -  player.rate  ;
           history_win_lose[history_count] = player.viewMoney() - (player.rate * 2) ;
           Sound.playSound("/home/vik24rus/IdeaProjects/my_class/src/ex2/sounds/lose.wav").join();
       }
        checkMoney();
    }

    double BookmakerMoney(){
        return money;
    }

    void seeHistory(){

        for (int i = 0; i < history_win_lose.length; i++) {
            if (history_win_lose[i] == 0){
                continue;
            }else{
                System.out.println(" ||" + i + " Баланс: "  + history_win_lose[i] + " || Ставка была: " + (player.viewMoney() - history_win_lose[i]));

            }

        }
        System.out.println("Итого: " + ALLWIN);

    }

    void checkMoney(){
        if (player.rate * 2 > money){
            hippodrome.isRunning = false;
            System.out.println("У букмекера кончились деньги");

        }else{
            hippodrome.isRunning = true;
        }


        if (money <= 0){
            hippodrome.isRunning = false;
        }else{
            hippodrome.isRunning = true;
        }

        if (player.viewMoney() <= 0){
            hippodrome.isRunning = false;
            System.out.println("У Вас кончились деньги");
        }else{
            hippodrome.isRunning = true;
        }
    }
}
