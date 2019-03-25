package java8test.ch3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gintire.java8.ex3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import com.gintire.java8.ex3.Apple;
import com.gintire.java8.ex3.Person;

public class ExecuteAroundPatternTest {
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
	public void sortApple() {
		List<Apple> appleList = Arrays.asList(new Apple("red", 100)
                , new Apple("green", 120)
                , new Apple("yellow", 90)
                , new Apple("black", 110));
		//Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
		appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(appleList);
		//appleList.sort(c);
	}
	
	@Test
	public void makePersons() {


		//persons.forEach(person->System.out.println(person.getName()));

		long starttime = System.currentTimeMillis();// 시작점 시간 저장 save time when your code started

		List<Person> pList = new ArrayList<Person>();
		for(Person p : persons) {
			if(p.getGender().equals("M"))  {
				pList.add(p);
			}
		}
		long endtime = System.currentTimeMillis(); // 모든 코드가 실행되고 시간 저장 save time when your code ended
		long externalLoopTime = endtime - starttime;
		long starttime2 = System.currentTimeMillis();// 시작점 시간 저장 save time when your code started
		List<Person> pList2 =
				persons.parallelStream()
						.filter(Person::isMale)
						.collect(Collectors.toList());
		long endtime2 = System.currentTimeMillis(); // 모든 코드가 실행되고 시간 저장 save time when your code ended
		long internalLoopTime = endtime2 - starttime2;

		System.out.println("외부 순환 : " + externalLoopTime);
		System.out.println("내부 순환 : "+internalLoopTime);
		/*Integer res =
				persons.stream()
				       .filter(d->{
				    	   System.out.println("filtering"+d.getGender());
				    	   return d.getGender().equals("M");
		              }).mapToInt(d->{
			             System.out.println("filtering"+d.getAge());
			             return d.getAge();
		              }).sum();
		assertThat(res).isEqualTo(132);*/
	}

	@Test
	public void minMax() {
		Comparator<Person> personComparator = Comparator.comparingInt(Person::getAge);

		Optional<Person> mostOldestPerson = persons.stream().collect(Collectors.maxBy(personComparator));

		IntSummaryStatistics ageStatistic = persons.stream().collect(Collectors.summarizingInt(Person::getAge));

		String personsName = persons.stream().map(Person::getName).collect(Collectors.joining(", "));

		//String personsName2 = persons.stream().collect(Collectors.joining());

		System.out.println(ageStatistic);
		System.out.println(mostOldestPerson);

		System.out.println(personsName);
		//System.out.println(personsName2);
	}
}
