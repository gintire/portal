package java8test.ch9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class DefaultMethod {
    @Test
    public void defaultMethod1() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        Assert.assertEquals(Arrays.asList(1,2,3,5,6), numbers);
    }

}
