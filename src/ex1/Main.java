package ex1;

/**
 * Created by se4 on 15.08.16.
 */
public class Main {
    public static void main(String[] args) {




        Cat cat1 = new Cat(3,"Tom",true);
        Cat cat2 = new Cat(5,"Myrka",false);

        Cat tempCat = cat1; // создали ссылку которая временно будет хранить ссылку на Тома

        cat1 = cat2; // Том в памяти остался но ссылки на него теперь нет, обе ссылки ссылаются на Мурку


        System.out.println(cat2.toString());

    }
}
