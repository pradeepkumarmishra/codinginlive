package org.mishra.aop.model;

public class Triangle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}
	public void setNameExecption(String name) {
		this.name = name;
		throw new RuntimeException();
		
	}
	
	public String returnMethod(String name){
		System.out.println("calling return method..");
		this.name=name;
		return name;
	}
}
