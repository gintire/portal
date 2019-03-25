package com.gintire.java8.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.gintire.java8.vo.Apple;
import com.gintire.java8.vo.Java8Lamda;

public class Chapter2 {

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(apple.getColor()=="green") result.add(apple);
		}
		return result;
	}

	public static List<Java8Lamda> dofilter(List<Java8Lamda> java8Lamdas, Predicate<Java8Lamda> predicate) {
		List<Java8Lamda> result = new ArrayList<Java8Lamda>();
		for(Java8Lamda java8Lamda : java8Lamdas) {
			if(predicate.test(java8Lamda)) result.add(java8Lamda);
		}
		return result;
	}

	
}
