package java8test.ch6;

import com.gintire.java8.ex3.MyCard;
import com.gintire.java8.ex3.Person;
import com.gintire.java8.ex3.RandomUtils;
import me.xdrop.jrand.model.money.CardType;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDataByStream {
    private final static Logger LOG = Logger.getGlobal();
    private List<Person> persons;
    @Before
    public void init() {
        persons = Stream.iterate(1, i->1)
                .limit(10)
                .map(i-> RandomUtils.createRandomPerson())
                .collect(Collectors.toList());
    }
    @Test
    public void sumAge() {
        int sum = persons.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println(sum);
    }

    @Test
    public void reducingAge() {
        int sum = persons.stream().collect(Collectors.reducing(0, Person::getAge, Integer::sum));
        System.out.println(sum);
    }

    @Test
    public void totalAge() {
        int sum = persons.stream().map(Person::getAge).reduce(Integer::sum).get();
        System.out.println(sum);
    }
    @Test
    public void totalAge2() {
        int sum = persons.stream().mapToInt(Person::getAge).sum();
        System.out.println(sum);
    }

    @Test
    public void groupby1() {
        Map<String, List<Person>> divPersonByAge =
                persons.stream()
                       .collect(Collectors.groupingBy(p->{
                            if(p.getAge() <=20) return "young";
                            else if (p.getAge() >20 && p.getAge() <=40) return "old";
                            else return "die";
                        }));
        System.out.println(divPersonByAge);
    }

   /* @Test
    public void groupby2() {
        persons.stream().collect(Collectors.groupingBy(new Function<Person, Object>() {
            @Override
            public Object apply(Person person) {
                return null;
            }
        }))
    }*/

    @Test
    public void groupby3() {
        Map<Boolean, List<Person>> collect = persons.stream().collect(
                Collectors.partitioningBy(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return person.getGender() == "M";
                    }
                })
        );
        System.out.println(collect);
    }

    @Test
    public void refactoringTest() {
        int a = 10;
        //람다로 표현
        /*Runnable r1 = () -> {
            int a = 2;      // 컴파일 에러
            System.out.println(a);
        }*/
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
    }
}
