package org.example.pattern.builder;

public class Person {

	public static final int MAN = 0;
	public static final int WOMAN = 0;

	private int id;
	
	private String name;
	
	private int age;
	
	private long userNum;
	
	private int level;
	
	private int gender ;
	
	private String userDes;
	
	private String country;
	
	private String province;
	
	private String city;
	
	public Person(Builder builder){
		this.id = builder.id;
		this.age = builder.age;
		this.name = builder.name;
		this.userNum = builder.userNum;
		this.level = builder.level;
		this.gender = builder.gender;
		this.userDes = builder.userDes;
		this.country = builder.country;
		this.province = builder.province;
		this.city = builder.city;
	}
	
	
	public static class Builder {
		
		private int id;
		
		private String name;
		
		private int age;
		
		private long userNum;
		
		private int level;
		
		private int gender ;
		
		private String userDes;
		
		private String country;
		
		private String province;
		
		private String city;
		
		public Builder(){
			
		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setUserNum(long userNum) {
			this.userNum = userNum;
			return this;
		}

		public Builder setLevel(int level) {
			this.level = level;
			return this;
		}

		public Builder setGender(int gender) {
			this.gender = gender;
			return this;
		}

		public Builder setUserDes(String userDes) {
			this.userDes = userDes;
			return this;
		}

		public Builder setCountry(String country) {
			this.country = country;
			return this;
		}

		public Builder setProvince(String province) {
			this.province = province;
			return this;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}

	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", userNum=" + userNum + ", level=" + level + ", gender="
				+ gender + ", userDes=" + userDes + ", country=" + country
				+ ", province=" + province + ", city=" + city + "]";
	}
	
	
}
