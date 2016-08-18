package for_test;

import java.util.concurrent.TimeUnit;

class Cc implements Runnable {
    public void run() {
        int k = 0;
        String[] gonka = {" 1 ", " 2 ", " 3 "};

        for (int i = 0; i < gonka.length; i++) {

            //gonka[i] = "*";
            k++;


            for (int j = 0; j < k; j++) {
                System.out.print(gonka[j]);

            }



        }

    }
}