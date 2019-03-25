package java8test.ch8;

import com.gintire.java8.ex3.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PersonFactory {
   /* public static Person createPerson(String gender) {
        if(gender=="M")
            return new Man();
        else if(gender=="F")
            return new Woman();
        else throw new RuntimeException("No SEX "+gender);
    }*/
   final static Map<String, Supplier<Person>> map = new HashMap<>();
   static {
       map.put("M", Man::new);
       map.put("F", Woman::new);
   }
   public static Person createPerson(String gender) {
       Supplier<Person> supplier = map.get(gender);
       if(supplier!=null) return supplier.get();
       throw new IllegalArgumentException("No SEX "+gender);
   }
}
