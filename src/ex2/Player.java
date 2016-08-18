package ex2;

/**
 * Created by se4 on 16.08.16.
 */
public class Player {

    static double money = 1000; //наличка на руках

    static public int rate ;

    static public int number_win_horse; //по мнению игрока


    double viewMoney(){
        return money;
    }

    double giveMoney(double win){
        return money= money + win;
    }

    void giveRate(int rate){
        this.rate=rate;
    }

    void giveNumber_win_horse(int number_win_horse){
        this.number_win_horse = number_win_horse;

    }

    int giveNumber_win_horse(){
        return number_win_horse;
    }

    public void playerLoos() {
        money = money - rate;
    }
}
