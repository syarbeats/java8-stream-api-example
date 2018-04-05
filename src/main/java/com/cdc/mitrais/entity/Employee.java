package com.cdc.mitrais.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	public int id;
	public String name;
	public int sal;
	
	public Employee(int id,String name,int sal  ){
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	
	public static List<Employee> getEmpList(){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Abraham", 2000));
		list.add(new Employee(2, "Buckham", 3000));
		list.add(new Employee(3, "Conny", 4000));
		list.add(new Employee(4, "Danzel", 5000));
		return list;
	}
} 