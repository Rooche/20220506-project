package project.gugbab.managerment;

import java.util.Scanner;

import project.gugbab.service.GugbabService;
import project.gugbab.serviceImpl.GugbabServiceImpl;

public class MainGame {
//	private GugbabService dao = new GugbabServiceImpl();
	private Scanner sc = new Scanner(System.in);

	public void game() throws InterruptedException {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("				국밥집	 타이쿤 								");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String s = "당신은 작은가게의 국밥집 사장이며 가게의 부흥을 위해 열심히 국밥을 팔아야합니다\n\n" + "게임 클리어를 위해서는 가게를 프렌차이즈화 해야한다.\n\n"
				+ "국밥을 열심히 팔아 돈을 벌고 그 돈으로 가게를 확장합니다\n\n" 
				+ "(단, 진상손님은 돈을 내지 않음. )\n\n"
				+ "지정된 시간안에 가게를 확장하지 못한다면 게임은 실패입니다.\n\n";

		for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
			Thread.sleep(25);
			System.out.print(s.charAt(i));
		}
		Thread.sleep(100);
		System.out.println("\n");
		System.out.println("게임을 시작합니다!!");

		while (true) {
			// 게임 시작 상태창 ? 메뉴 ?
			System.out.println(
					"- - - - - - - - - - - - - - - - - - 메뉴 창 - - - - - - - - - - - - - - - - - - - - - - - -\n");
			System.out
					.println("                 (1) 가게 오픈           (2) 상점           (3) 자산 확인       (4) 종료하기    ");
			System.out.println(
					"- - - - - - - - - - - - - - - - - - 메뉴 창 - - - - - - - - - - - - - - - - - - - - - - - -\n");
			int numenu = sc.nextInt();

			if (numenu == 1) {
				
			}
			
			if(numenu == 2) {
				
			}
			
			if(numenu == 3) {
				System.out.println("현재 자산을 보여줍니다.");
				System.out.println("");
			}
			if(numenu == 4) {
				System.out.println("현재 실행하고있는 데이터를 종료합니다.");
				break;
			}
		}
	}
}
