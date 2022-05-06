package project.gugbab.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
