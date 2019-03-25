package java8test.ch8;

import com.gintire.java8.ex3.Person;
import org.assertj.core.api.AssertProvider;
import org.junit.Assert;
import org.junit.Test;

import java.security.acl.Permission;

public class FactoryPattern{
    @Test(expected = IllegalArgumentException.class)
    public void testCreatePerson() {
        Person person = PersonFactory.createPerson("wwww");
        Assert.assertTrue(person instanceof Man);
    }
}
