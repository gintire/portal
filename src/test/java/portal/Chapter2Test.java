package portal;

//import static org.assertj.core.api.AbstractObjectAssert.isEqualToComparingFieldByField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.gintire.java8.ex2.Chapter2;
import com.gintire.java8.vo.Apple;
import com.gintire.java8.vo.Java8Lamda;

public class Chapter2Test {

	List<Apple> inventory = new ArrayList<Apple> ();
	List<Object> expect = new ArrayList<> ();
	
	List<Java8Lamda> Java8Lamdas = new ArrayList<>();
	
	@Before
	public void init() {
		inventory = Arrays.asList(
				new Apple(1, "green", 150)
				, new Apple(2, "red", 120)
				, new Apple(3, "green", 200)
				, new Apple(4, "red", 200)
				, new Apple(5, "green", 100)
				, new Apple(6, "red", 100));
		
		Java8Lamdas = Arrays.asList(
				new Java8Lamda("john", 30)
				, new Java8Lamda("gsjohn", 29)
				, new Java8Lamda("jogshn", 28)
				, new Java8Lamda("johngs", 27)
				, new Java8Lamda("jokkhn", 32)
				, new Java8Lamda("joaahn", 26)
				);
	}
	
	@Test
	public void tes2t() {
		List<String> expect = Arrays.asList("1", "2", "3", "4");
		List<String> actual = Arrays.asList("1", "2", "3", "4");
		
		//assertThat(actual, is(expect));
	}
	
	@Test
	public void test3() {
		Apple a = new Apple(1, "green", 150);
		Apple b = new Apple(1, "green", 150);
		
		assert(a.equals(b));
	}
	
	@Test
	public void test4() {
		expect = Arrays.asList(
				new Apple(1, "green", 150)
				, new Apple(3, "green", 200)
				, new Apple(5, "green", 100));
		List<Apple> actual = Chapter2.filterGreenApples(inventory);
		
		//assertThat(actual).isEqul;
	}
	
	@Test
	public void test() {
		expect = Arrays.asList(
				new Apple(1, "green", 150)
				, new Apple(3, "green", 200)
				, new Apple(5, "green", 100));
		List<Apple> actual = Chapter2.filterGreenApples(inventory);
		
		//assertThat(actual, is(expect));
	}

	@Test
	public void test5() {
		List<Java8Lamda> expects = Arrays.asList(
				new Java8Lamda("john", 30)
				, new Java8Lamda("jokkhn", 32)
				);
		//List<Java8Lamda> actual = Chapter2.filterJava8Lamdas(Java8Lamdas, new NameFilter());
		
		List<Java8Lamda> actuals = Chapter2.dofilter(Java8Lamdas, new Predicate<Java8Lamda>(){
			@Override
			public boolean test(Java8Lamda p) {
				return p.getAge() > 29;
			}
		});
		
		//assertThat(new Java8Lamda(1,"hp", 30)).isEqualToComparingFieldByField(new Java8Lamda(1,"hp", 30));
	}
	
	Runnable r1 = () -> System.out.println("Hello world");
	Runnable r2 = new Runnable() {
		public void run() {
			System.out.println("Hello World 2");
		}
	};
	public static void process(Runnable r) {
		r.run();
	}
	
	@Test
	public void test6() {
		process(r1);
		process(r2);
		process(() -> System.out.println("Hello world 3"));
	}
}
