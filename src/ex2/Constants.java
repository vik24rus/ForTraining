package ex2;

import java.util.Random;

/**
 * Created by se4 on 16.08.16.
 */

public class Constants {

    Random random = new Random();


    private String[] nameForRand = {"Cometa","Coller","Tometa","Nina  "};
    private String[] colorForRand = {"red  ","white","black"};

    public String getNameForRand(){
        return nameForRand[random.nextInt(3)];
    }

    public String getColorForRand(){
        return colorForRand[random.nextInt(2)];
    }


}

