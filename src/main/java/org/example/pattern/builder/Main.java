package org.example.pattern.builder;

public class Main {

	public static void main(String[] args) {
		
		Person jake = new Person.Builder().setId(100)
				.setAge(20)
				.setName("Jake")
				.setLevel(12)
				.setGender(Person.MAN)
				.setUserNum(156464612)
				.setUserDes("patient and careful")
				.setCity("wuhan")
				.setProvince("hubei")
				.build();
		
		System.out.println(jake);
		
	}

}
