package project.gugbab.service;

import lombok.Data;

@Data
public class GugbabVO {
	private String userId;
	private String name;
	private String password;
	
	
	@Override
	public String toString() {
		System.out.print(userId + " : ");
		System.out.print(name + " : ");
		System.out.print(password + " : ");
		
		return null;
	}
	
}
