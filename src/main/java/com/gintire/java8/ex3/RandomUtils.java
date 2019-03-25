package com.gintire.java8.ex3;

import me.xdrop.jrand.JRand;



public class RandomUtils {

	   public static Person createRandomPerson() {return  PersonFactory.createRandomPerson();}
	   public static MyCard createRandomCard() {return  CardFactory.createRandomCard();}

	   static class PersonFactory {
	       private PersonFactory(){}
	       public static Person createRandomPerson() {
	           Person instance = new Person();
	           instance.setAge(JRand.age().gen());
	           instance.setName(JRand.name().gen());
	           instance.setGender(JRand.gender().gen());
	           return instance;
	       }
	   }
	   static class CardFactory {
	   	private CardFactory(){}
	   	public static MyCard createRandomCard() {
			MyCard instance = new MyCard();
			instance.setCard_number(JRand.cardNo().gen());
			instance.setCardType(JRand.cardType().gen());
			instance.setCvv(JRand.cvv());
			instance.setExpiry_date(JRand.expiryDate());
			instance.setIssue_date(JRand.issueDate());
			return instance;
		}
	   }
	}
