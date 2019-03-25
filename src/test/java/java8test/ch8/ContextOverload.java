package java8test.ch8;

interface Task{
    public void execute();
}
public class ContextOverload {
    public static void doSomething(Runnable r) {r.run();}
    public static void doSomething(Task a) {a.execute();}

    public static void main(String[] args) {
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

        //doSomething(() -> System.out.println("Danger danger!!"));
    }
}
