package com.myclass;

/**
 * Created by vik24rus on 13.08.2016.
 */
public class B extends A {

    // ctrl+O
    @Override   //перезапись метода
    public void print(int i) {
        i++;
        super.print(i); //обращаемся к классу-родителю (суперу) - тому классу от которого мы Extends
    }
}
