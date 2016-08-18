package ex3;

import java.util.Scanner;

/**
 * Created by se4 on 16.08.16.
 */
public class Player {

    int getShoot(){
        System.out.println("Куда стрелять?");
        Scanner scan = new Scanner(System.in); //еще есть BufferedReader
        String s;
        s = scan.nextLine();
        System.out.printf("Вы ввели: %s\n", s);

        int shoot = Integer.parseInt(s);
        return shoot;
    }

}
