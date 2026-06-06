package com.practice;
//single level inheritance
public class Main{
	private String name;
	private int age;
	public void setName(String name) {
		this.name=name;
	}
	
	Main(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void eating() {
		System.out.println("eating");
	}
	public void printDetails() {
		System.out.println(name);
		System.out.println(age);
	}
}