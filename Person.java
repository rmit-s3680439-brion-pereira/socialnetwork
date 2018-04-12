//package SocialMedia;

//Author: Abhilash

import java.util.*;

public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private String status;
	public List<Integer> friend=null;	
	public Dependents dependents=null;
	
	public Person() {
		
	}
	public Person(Integer id, String name,Integer age,String status)
	{
		this.id=id;
		this.name=name;
		this.status=status;
		
	}
	public Integer getID(){
		return id;
	}
	
	public void setID(Integer id ) {
		this.id=id;
	}
	
	public String getName() {
	return name;	
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	
	@Override
	public String toString() {
		return "Person[id="+id+",name="+name+",age="+age+",status="+status+",friend="+friend+",dependents="+dependents+"]";
	}
}

