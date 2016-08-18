package ex1;

/**
 * Created by se4 on 14.08.16.
 *
 * 17-Sep-2011 09:01:16 :%LINK-I-Up:  g1
 *  15 fduecnf 18 14
 */
public class Cat {
    int age;
    String name;
    double weight;
    boolean isMail;
    Tail tail;         // композиция - кошка без хвоста сучществовать не может - объект не может быть без внешнего объекта
    Talisman talisman; //агрегация - кошка может быть

//    Cat(){
//
//    }
    //ctl+o добавить перегруженые методы
    //alt+insert комбинация добавить конструтор, перегруженные методы...


    public Cat(int age, String name, boolean isMail) {
        this.age = age;
        this.name = name;
        this.isMail = isMail;

        System.out.println();

    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", isMail=" + isMail +
                ", tail=" + tail +
                ", talisman=" + talisman +
                '}';
    }

    public Cat(int age, String name, double weight, boolean isMail, Tail tail, Talisman talisman) {
        this.age = age; //this отличить параметр метода от поля в классе
        this.name = name;
        this.weight = weight;
        this.isMail = isMail;
        this.tail = tail;
        this.talisman = talisman;
    }

    void voice(){
        System.out.println("Мяу");
    }

    void sleep(){
        System.out.println("mrrr");
    }
}
