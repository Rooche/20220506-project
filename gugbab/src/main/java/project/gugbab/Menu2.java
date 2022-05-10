package project.gugbab;

import java.util.Scanner;

import lombok.Data;
import project.gugbab.managerment.Gugbab;
import project.gugbab.managerment.MainGame;
import project.gugbab.service.GugbabService;
import project.gugbab.service.GugbabVO;
import project.gugbab.serviceImpl.GugbabServiceImpl;

@Data
public class Menu2 {
	GugbabVO vo = new GugbabVO();
	Scanner sc = new Scanner(System.in);
	Gugbab gb = new Gugbab();
	MainGame mg = new MainGame();

	GugbabService gs = new GugbabServiceImpl();
	String sId;

	public void run() throws InterruptedException { // 실행메소드
		mainMenu();
	}

	public int mainMenu() throws InterruptedException {
		boolean a = true;
		while (a) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("				국밥집	 타이쿤 								");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			String s = "당신은 작은가게의 국밥집 사장이며 가게의 부흥을 위해 열심히 국밥을 팔아야합니다\n\n" + "게임 클리어를 위해서는 가게를 프렌차이즈화 해야한다.\n\n"
					+ "국밥을 열심히 팔아 돈을 벌고 그 돈으로 가게를 확장합니다\n\n" + "(단, 진상손님은 돈을 내지 않음. )\n\n"
					+ "지정된 시간안에 가게를 확장하지 못한다면 게임은 실패입니다.\n\n";

			for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
				Thread.sleep(25);
				System.out.print(s.charAt(i));
			}
			System.out.println("┏━━━━━━━━━━━━━━┓");
			System.out.println("   국 밥 타 이 쿤  ");
			System.out.println(" 1. 회 원 가 입   ");
			System.out.println(" 2. 로  그  인    ");
			System.out.println(" 3. 종	료 		");
			System.out.println("┗━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();

			if (menu == 1) {
				gb.insertGugbab();

			} else if (menu == 2) {
				System.out.println("ID를 입력해주세요.");
				sId = sc.next();
				System.out.println("비밀번호를 입력해주세요.");
				String sPassword = sc.next();

				int result = gs.login(sId, sPassword);

				if (result == 1) {
					gs.savingMoney(subMenu(sId), sPassword);
				} else {
					continue;
				}
				break;

			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
		return 0;
	}

	private int subMenu(String sId) throws InterruptedException {

		boolean b = true;
		while (b) {
//			int money = 0;
			System.out.println("┏━━━━━━━━━━━━━━┓");
			System.out.println(" 1. 게 임 시 작   ");
			System.out.println(" 2. 정 보 변 경    ");
			System.out.println(" 3. 종	료 		");
			System.out.println("┗━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();

			if (menu == 1) {
				mg.gaRun(sId);

				break;
			} else if (menu == 2) {
				menu = mainUser(sId);
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		return 0;
	}

	private int mainUser(String sId) throws InterruptedException {
		boolean c = true;
		while (c) {

//			int money = 0;
			System.out.println("┏━━━━━━━━━━━━━━┓");
			System.out.println(" 1. 비밀번호 변경  ");
			System.out.println(" 2. 계  정  삭 제 ");
			System.out.println(" 3. 뒤 로 가 기	");
			System.out.println("┗━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();

			if (menu == 1) {
				int result = gs.updateGugbab(sId);
				if (result == 1) {
					System.out.println("비밀번호 변경 성공");
				} else {
					System.out.println("비밀번호 변경 실패");
				}
				continue;
			} else if (menu == 2) {
				gs.deleteGugbab(sId);
				System.out.println("계정을 삭제했습니다.");
				return mainMenu();
			} else if (menu == 3) {
				c = false;
				break;
			}

		}

		return 0;
	}
	
	public void gameRun() {
		
	}
	
	public void gameOver() throws InterruptedException {
		subMenu(sId);
	}
	

}
