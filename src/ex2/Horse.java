package ex2;

import java.util.concurrent.TimeUnit;

/**
 * Created by se4 on 15.08.16.
 */
public class Horse {
    String name;
    int speed;
    String color;
    boolean isMale;
    int age;
    int numberHorse;

    Constants my_const = new Constants();

    String GenName(){
        String RandName = my_const.getNameForRand();
        return RandName;
    }


    String GenColor(){
        String RandColor = my_const.getColorForRand();
        return RandColor;
    }


    void about(){
        String sex = (isMale) ? "Male  " : "Female" ; // тернарный оператор
        System.out.printf("name: %s || age: %d  || sex: %s || color: %s" , name, age , sex , color);

    }

    void ride(){
        about();
        System.out.println(" |");
        System.out.println("               riding at speed " + speed + "                      |");
        System.out.println("-------------------------------------------------------|");

    }

    void render(){
        int k=0;
        String[] gonka =  {" * ", "  ", "  ", "  ", "  ", "  ", "  ", "  " };

        for (int i = 0; i < gonka.length; i++) {

            gonka[i] = "*";
            k++;


            for (int j = 0; j < k; j++) {
                System.out.print(gonka[j] );

            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }
}
