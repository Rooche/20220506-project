package project.gugbab.service;

import lombok.Data;

@Data
public class GugbabVO {
	private String userId;
	private String name;
	private String password;
	private int Money;
	
	public GugbabVO() {
		
	}
	
	
	public GugbabVO(String userId, String name, String password, int money) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.Money = money;
	}
	
	
	@Override
	public String toString() {
		return " 아이디 : " + userId + ", 이름 :" + name + ", 비밀번호 : " + password + ", 돈 : " + Money + "]";
	}





	
}
