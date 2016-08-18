package ex3;

import java.util.Scanner;



/**
 * Created by se4 on 16.08.16.
 */
public class Field {

    public static final int SIZE = 10;
    char[] cells = new  char [SIZE];
    Ship ship;

     void init(){
         for (int i = 0; i < cells.length; i++) {
             cells[i]='.';

         }
     }

     void setShip(Ship ship){
         this.ship = ship;
         cells[ship.position] = 'X' ;

     }

     void doShoot(int shoot){

             switch (cells[shoot]){
                 case '.':
                     System.out.println("Вы промазали");
                     cells[shoot]= '*';
                     break;
                 case 'X':
                     System.out.println("Потоплен");
                     cells[shoot]= '-';
                     System.out.println(cells);
                     break;
                 case '*':
                     System.out.println("Уже стреляли");
                     break;
                 default:
                     System.out.println("Error");
                     break;
             }
     }

     void show(){
         System.out.println(cells);
     }

     boolean GameRun(){
        if (cells[ship.position] == 'X'){
            return true;
        }else {
            return false;
        }


     }


}
