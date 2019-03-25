package java8test.ch8;

import org.junit.Test;

public class Shadow {
    private int myIntVar = 0;
    public int shadowTheVar() {
        int myIntVar = 5;

        System.out.println(myIntVar);

        System.out.println(this.myIntVar);

        return this.myIntVar;
    }
    @Test
    public void checkShadowVar() {
        new Shadow().shadowTheVar();
    }
    A_Class a = new A_Class();
    @Test
    public void sol1() {
        a.printA();
        a.printB();
        System.out.println(a.var);
        System.out.println(SuperClass.var);
    }
}
interface SuperClass {
    int var =100;
}
class A_Class implements SuperClass {
    int var = 99;
    public void printA() {
        System.out.println(var);
    }
    public void printB() {
        System.out.println(this.var);
    }
}