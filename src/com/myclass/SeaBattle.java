package com.myclass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by se4 on 14.08.16.
 */
public class SeaBattle {
    public static void main(String[] args) {
        
        char[] cells;
        cells = new  char [10];

        for (int i = 0; i < cells.length; i++) {
            cells[i]='.';
            
        }

        int position = 4;
        cells[position] = 'X';

        do {
            System.out.println(cells);
            Scanner scan = new Scanner(System.in); //еще есть BufferedReader
            String s;
            s = scan.nextLine();
            System.out.printf("Вы ввели: %s\n", s);

            int shoot = Integer.parseInt(s);

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
        }while (cells[position]=='X');
    }
}
