//package project.gugbab;
//
//import java.util.Scanner;
//import project.gugbab.managerment.Gugbab;
//import project.gugbab.managerment.MainGame;
//
//public class Menu {
//
//	private Scanner sc = new Scanner(System.in);
//	private Gugbab gb = new Gugbab();
//	private MainGame mg = new MainGame();
//
//
//	private void mainTitle() throws InterruptedException {
//		
//		boolean b = true;
//		while (b) {
//			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┓");
//			System.out.println("	국  밥  타  이  쿤 	");
//			System.out.println("	1. 회  원  가  입  	");
//			System.out.println("	2. 로   그    인  	");
//			System.out.println("	3. 종	     료 		");
//			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┛");
//			int menu = sc.nextInt();
//			if (menu == 1) {
//				gb.insertGugbab();
//			} else if (menu == 2) {
//				gb.login();
//				break;
//			} else if(menu == 3) {
//				System.out.println("게임을 종료합니다.");
//				break;
//			}
//		}
//	}
//	
//	while (b) {
//		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┓");
//		System.out.println("	1. 게  임  시  작		");
//		System.out.println("	2. 종		  료		");
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┛");
//		int submenu = sc.nextInt();
//		if (submenu == 1) {
//			mg.game();
//		} else if (submenu == 2) {
//			System.out.println("게임을 종료합니다.");
//			break;
//		}
//	}
//
////	private int realGame(String sid) throws InterruptedException {
////		boolean a = true;
////	private void mainMenu() {
////		boolean b = false;
////		do {
////			mainTitle();
////			System.out.println("선택하세요.");
////			int job = sc.nextInt();
////			switch (job) {
////			case 1:
////				gb.insertGugbab();
////			case 2:
////				gb.login();
////				break;
////			case 3:
////				b = true;
////				System.out.println("시스템 종료");
////				break;
////
////			}
////		} while (!b);
////	}
//
//	public void run() throws InterruptedException {
//		mainTitle();
//	}
//}
