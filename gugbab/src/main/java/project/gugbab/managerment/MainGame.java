package project.gugbab.managerment;

import java.util.Scanner;

import project.gugbab.Menu2;
import project.gugbab.service.GugbabService;
import project.gugbab.serviceImpl.GugbabServiceImpl;

public class MainGame extends Thread {
//	private GugbabService dao = new GugbabServiceImpl();
	Menu2 me;
	private Scanner sc = new Scanner(System.in);
	GugbabService gs = new GugbabServiceImpl();
	String sId = "";
	int porksoupprice = 500; // 돼지국밥 가격
	int sundaegugbabprice = 600; // 순대국밥
	int porksoup, sundaegugbab = 0; // 팔아야하는 돼지, 순대 / 가게가 작을땐 5 ~ 6개로 생각 커지면 10개로 늘어날듯
	int buyporksoup, buysundaegugbab = 0; // 랜덤으로 손님이 구입할것
	int time;

	int max = 10;
	private int money = 0; // 시작시 돈
	private int evaluation = 10; // 가게 평가 안쓸수도 있음

	String[] people = { "어린아이", "어른", "노인", "진상손님" }; // 손님의 종류는 4명
	int p = 0; // 최대 받을수있는 손님수를 세야함

	int gameTime = 0; // 지정된 시간동안 조건 불만족시 실패하도록 하기위한 시간저장

	public int gaRun(String sId) throws InterruptedException {
		// tm.GameTimer();
		this.sId = sId;
		int sum = 0;
		int money = 0;

		while (p < 1) { // 작은 가게일때는 최대 6명만 손님을 받음
			try {
				clearScreen();
				peoples();
				System.out.println(randomPeople() + "손님이 가게를 방문했습니다");
				randomOder();
				join();
				mainMenu();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println("게임종료 !");
		sum += money;

		return money;
	}

	private String randomPeople() { // 어린아이, 어른, 노인 , 진상손님까지 랜덤출현
		return (people[(int) (4 * (Math.random()))]);
	}

	private void randomOder() { // 랜덤값을 줘서 0 ~ 3그릇을 시키게함 .. 문제는 두개중 하나는 무조건 주문을 해야하는데 가끔 돼지,수육 각각 0개씩 주문함
		this.buyporksoup = (int) ((Math.random() * 3));
		this.buysundaegugbab = (int) ((Math.random() * 3));

		if ((buyporksoup + buysundaegugbab) > 0 && (buyporksoup + buysundaegugbab) <= 8) {
			if (buyporksoup == 0 && buysundaegugbab >= 1) {
				System.out.println("10인분같은 순대국밥" + buysundaegugbab + "그릇 주세요");
			} else if (buysundaegugbab == 0 && buyporksoup >= 1) {
				System.out.println("150인분 같은 돼지국밥" + buyporksoup + "그릇 주세요");
			} else {
				System.out.println("배가 고프니 돼지국밥" + buyporksoup + "그릇이랑 순대국밥" + buysundaegugbab + "그릇 주세요");

			}
		}
	}

	public void setting() { // 시작할때 기본 세팅값, 돈과 평가도 0
		money = 0;
		evaluation = 0;
	}

	public void repurchase() { // 손님한테 재구입방지
		buyporksoup = -1;
		buysundaegugbab = 1;
	}

	public void mainMenu() throws InterruptedException {
		int sum = 0;
		int s = 0;
		Thread.sleep(1000);
		String t = ""
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n";
		for (int i = 0; i < t.length(); i++) {
			Thread.sleep(25);
			System.out.print(t.charAt(i));

		}
		while (s == 0) {
			System.out.println(
					"- - - - - - - - - - - - - - - - - - 메뉴 창 - - - - - - - - - - - - - - - - - - - - - - - -\n");
			System.out.println("				손님 평가	:" + evaluation);
			System.out.println("	(1) 국밥제조		(2) 국밥팔기			(3) 매출액 확인 ");
			System.out.println("	(4) 손님받기		(5) 상	점			(6) 게임종료");
			System.out.println(
					"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				clearScreen();
				makeGugbab();

			} else if (menu == 2) {
				clearScreen();
				buyGugbab();

			} else if (menu == 3) {
				clearScreen();
				checkMoney();

			} else if (menu == 4) {
				break;

			} else if (menu == 5) {
				clearScreen();
				store();

			} else if (menu == 6) {
				clearScreen();
				System.out.println("게임을 종료합니다.");
				gs.savingMoney(money, sId);
				p = 99;
				s = 99;
			} else {
				System.out.println("제대로 된 메뉴를 선택해주세요.");

			}

		}
	}

	private void makeGugbab() {
		int q = 0; // 입력하는 국밥 갯수
		int w = 0;

		while (w == 0) {
			System.out.println("1. 뚝배기에 돼지수육과 진한 육수넣고 돼지국밥 만들기");
			System.out.println("2. 뚝배기에 값싼순대와 돼지수육 조금 넣고 진한 육수넣고 순대국밥 만들기");
			System.out.println("3. 되돌아가기");
			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				clearScreen();
				System.out.println("돼지국밥을 얼마나 만드시겠어요?");
				q = sc.nextInt();
				if (q > 0 && q <= max) {
					if ((q + porksoup) >= 0 && (q + porksoup) <= 10) {
						porksoup += q;
						System.out.println("");
						System.out.println("⡀⠀⣴⢤⣬⣭⣤⣻⠿⠿⠷⠒⠒⠀⠈⣁⣠⡤⠤⠶⣺⣿⣿⣿⣿⣶⣶⣶⣶⣶⣾⣦⣤⣤⣀⠀⠀⠀⠀⠐⡶⠤⠀⠀⠀⠀⠀⠐⣶⣾");
						System.out.println("⣀⣤⠾⠋⠀⠀⠀⠀⠀⠀⠀⣠⣴⣞⣯⣭⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣾⣏⠀⠀⠀⣀⡄⠀⠀⠀⠈⠉");
						System.out.println("⣑⣒⣢⣤⢶⣶⣶⡶⢂⣴⣿⣿⣿⣿⣿⡿⠟⠋⠉⠉⠉⠀⠀⠀⠈⠁⠀⠉⠉⠉⠙⠛⠉⠈⣽⣿⣿⣿⣿⣮⡳⢦⡀⢻⣿⣦⣶⣵⣶⣶");
						System.out.println("⣿⡿⣿⣶⣿⣿⠏⣴⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠈⢿⣿⣿⣿⣦⡙⣿⡿⢻⣿⡿⠟⠃");
						System.out.println("⣿⣿⣿⣿⣿⡏⣼⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠤⠀⠀⠒⡤⠀⠋⢉⣤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣿⡜⣷⡄⠁⠀⢀⠀");
						System.out.println("⣿⣿⣿⣿⣿⠀⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠲⣶⠗⢲⣾⣿⣦⣤⣧⣭⣀⣀⣀⣤⠆⠄⠈⠀⠀⠀⠀⠀⠀⠘⡗⢻⣸⣿⠃⣤⣄⡀");
						System.out.println("⣿⣿⣿⣿⣿⡆⢹⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⢸⣿⣧⡾⢿⣿⣿⣯⣾⣯⡟⠁⠂⠀⠉⣀⠀⠀⠀⠀⠀⠀⢨⣿⣿⢀⣿⣿⣿");
						System.out.println("⣿⠿⢟⣋⣭⣾⣄⠹⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠊⠉⠉⠈⠻⠿⠛⠛⠻⣿⣿⡇⠀⠁⠀⠈⠁⠀⠀⠀⠀⠀⣼⣿⣟⣶⣿⣿⣿");
						System.out.println("⣶⣾⣿⣿⡿⠟⠹⢶⣌⠷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⡿⢤⡹⣿⣿⣿");
						System.out.println("⣿⡿⠟⠉⠀⡄⠀⢰⣿⣷⣦⣑⠢⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣿⣿⣿⣿⣷⣽⣿⣿⣿⣿");
						System.out.println("⠋⢀⠀⡇⠀⡄⠀⠸⣿⣿⣿⣿⣿⣶⣮⣽⣶⣤⣄⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣤⣤⣶⢾⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿");
						System.out.println("⠀⢸⠀⢣⠀⡇⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀");
						System.out.println("⡄⠈⡆⠘⡀⢰⠀⠀⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣜⠝⠋");
						System.out.println("⢁⠀⢡⠀⢣⠀⢣⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⢀⣠⡶");
						System.out.println("⠈⣄⡈⠀⠀⠃⠀⠳⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣵⠶⢛⣫⡵⠞");
						System.out.println("⠀⠘⠛⠛⠒⠒⠂⠤⢌⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⣭⣶⣿⣿⣷⣄⡀");
						System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣫⣯⣾⣿⣿⣿⣿⣿⣿⣿⡿⠿");
						System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣽⣮⣷⣿⣯⣾⣿⣿⣿⣿⣿⣿⣿⣿⢷⡠");
						System.out.println("뜨끈하고 든든한 돼지국밥을" + q + "그릇 담아뒀습니다.");
					} else {
						System.out.println(" 뚝배기가 부족합니다. ");
					}
				}
			} else if (menu == 2) {
				clearScreen();
				System.out.println("순대국밥을 얼마나 만드시겠어요?");
				q = sc.nextInt();
				sc.nextLine();
				if (q > 0 && q <= max) {
					if ((q + sundaegugbab) >= 0 && (q + sundaegugbab) <= 10) {
						sundaegugbab += q;
						System.out.println("⠀⠀⠀⠀⠀⣠⣿⣧⣀⣀⡀⠀⠀⠀⣀⣀⣠⣤⣾⣿⣿⡉⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⣟⣛⣛⣂⣤⣤⣭⣭⣭⣭⣉⣉⣛⣛⣛⠻⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⡿⢿⣛⣭⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣉⡙⠻⢿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠀⠀⠀⢸⣿⣿⠟⣩⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠁⠈⠙⠻⢿⡿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣈⠙⢿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠀⠀⠀⠀⡰⢡⣾⣿⣿⣿⣿⣿⡿⠛⠉⠀⠉⠋⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢩⡙⠛⠿⠿⢿⣿⣿⣿⣿⣿⣦⡈⢻⣿⣿");
						System.out.println("⠀⠀⠀⠀⠀⠀⢀⠀⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⢼⡇⠀⠈⠙⠅⠀⠀⠘⠃⠀⠀⠀⠀⠐⠉⠁⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⣆⢿⣿");
						System.out.println("⠀⠀⠀⠀⠀⠀⠈⡀⢻⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⠄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⡀⢹⢷⣦⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⢸⠇");
						System.out.println("⠀⠀⠀⠀⠀⠀⠀⡳⡈⠫⡀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣤⣤⠀⠀⠀⠀⠀⠁⠀⢀⣋⠁⠀⠩⠉⠗⡻⠋⠀⠀⠀⠀⠀⠀⠀⠛⣻⢏⡿⠀");
						System.out.println("⠀⠀⠀⠀⠀⣴⣞⣅⠙⣶⣄⡐⠄⠀⠀⠀⠀⠀⠀⠰⠚⠁⠀⢀⠀⠀⠀⠀⠀⠸⢏⣤⠄⠀⠀⠀⢀⠀⣥⢠⠀⠀⠀⠀⡠⣊⣵⠟⠁⠀");
						System.out.println("⠀⠀⠀⣴⣾⣿⣿⣿⡄⣿⣿⣿⣷⣦⣄⣀⠀⠐⠞⠛⠂⠀⠀⠈⠀⠀⠀⠀⠀⠈⠎⠁⠀⠀⠀⠀⠀⠀⠀⣀⠠⣐⣠⣶⣿⣿⠃⠀⠀⠀");
						System.out.println("⠀⠀⠀⢣⡁⠀⢮⠛⠓⣹⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣤⣤⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣤⣤⣴⣷⣿⣿⣿⣿⣿⣿⣿⣤⣶⣦⡀");
						System.out.println("⠀⢄⠀⠤⠝⣆⠀⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⡀⠀⣴⡿⡆⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠈⡼⣹⢷⡀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⠀⠀⠀⠐⢡⠏⢾⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("⣂⠀⠀⢠⢏⣊⣿⡿⣽⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
						System.out.println("뜨끈하고 든든한 순대국밥을" + q + "그릇 담아뒀습니다.");
					} else {
						System.out.println(" 뚝배기가 부족합니다. ");
					}
				}
			} else if (menu == 3) {
				break;
			} else {
				clearScreen();
				break;
			}

		}

	}

	private void buyGugbab() throws InterruptedException { // 국밥을 판매할때. 가장 넣기 쉬운 엔딩을 넣어둠
		if (buyporksoup >= 0 && buysundaegugbab >= 0) {
//			System.out.printf("돼지국밥 %s와 순대국밥%s를 주문했어요!\n", buyporksoup, buysundaegugbab);
			System.out.println("돼지국밥을 몇개 내어놓겠습니까?");
			int bps1 = sc.nextInt();
			sc.nextLine();
			System.out.println("순대국밥을 몇개 내어놓겠습니까?");
			int bps2 = sc.nextInt();
			sc.nextLine();

			if (bps1 <= porksoup && bps2 <= sundaegugbab) {

				if (bps1 == buyporksoup && bps2 == buysundaegugbab) {
					System.out.println("잘 먹겠습니다.");
					porksoup -= bps1;
					sundaegugbab -= bps2;
					money = (porksoupprice * bps1) + (sundaegugbabprice * bps2);
					evaluation += 5; // 똑바로 줬기때문에 평가가 증가함
					repurchase();

					if (evaluation > 50) {
						Thread.sleep(1000);
						String t = "평가도가 최상까지 올랐습니다. 가게는 매우 장사가 잘되어 프렌차이즈화가 되었습니다\n\n"
								+ "⠀⠀⣴⣶⣶⣶⣶⣶⣶⣶⢶⣶⠀⠀⠀⠀⢰⠶⣶⣶⣶⣶⢶⣶⣦⠀⠀⣶⣶⣶⡄⠀⠀⢰⣶⣶⣶⡶⣶⣶⣶⣶⣤⣶⣶⣶⣶⣶⣦⠀ \n"
								+ "⠀⢸⠉⠈⣶⠿⠖⠒⢶⡎⠀⢸⡇⠀⠀⠀⢸⠀⠉⣶⠖⠒⠾⠶⠟⠀⢀⡟⡈⠀⢻⡀⠀⢸⠉⠀⣶⠶⠒⠲⣿⠈⢸⡏⠉⣿⡇⠈⣿⠀\n"
								+ "⠀⢸⠀⠀⣿⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⢸⠀⠀⣿⠀⠀⠀⠀⠀⠀⡼⢡⣷⠀⠈⣧⠀⢸⠀⠀⣿⠀⠀⠀⣿⠀⢸⡇⠀⢸⠁⠀⣿⠀\n"
								+ "⠀⢸⠀⠀⣿⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⢸⠀⠀⠿⠤⠤⠤⠴⡆⢰⠃⣾⠋⣇⠀⠘⡆⢸⠀⠀⠿⠤⠤⠤⠏⠀⢸⡇⠀⢸⠀⠀⣿⠀\n"
								+ "⠀⢸⠀⠀⣿⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⢸⠀⠀⣶⡶⠶⣶⣤⠿⡟⠰⠿⠤⠼⠀⠀⢻⣸⠀⠀⣶⣶⢶⡀⠀⢴⡾⡇⠀⢸⠀⠀⣿⠀\n"
								+ "⠀⢸⠀⠀⣿⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⢸⠀⠀⣿⠀⠀⠀⠀⣸⢁⣤⣤⣤⣤⣤⠀⠘⣿⠀⠀⣿⠀⠀⣧⠀⠸⣆⡇⠀⣾⡇⠀⣿⠀\n"
								+ "⠀⢸⡀⠀⣿⣤⣤⣤⣤⠇⠀⢸⣧⣤⣤⣤⣼⠀⠀⣿⣤⣤⣤⣤⡇⣼⡇⠀⠀⠀⠘⡇⠀⢹⡀⠀⣿⠀⠀⠸⡄⠀⣻⡟⠛⣿⡟⠛⣷⠀\n"
								+ "⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠿⣿⣿⣿⣿⡿⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⡿⠀\n"

								+ "축하합니다 게임을 클리어하셨습니다.\n\n"
								+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n";
						for (int i = 0; i < t.length(); i++) {
							Thread.sleep(25);
							System.out.print(t.charAt(i));
						}
						me = new Menu2();
						me.gameOver();

					}

				} else if (bps1 == buyporksoup && bps2 < buysundaegugbab) {
					System.out.printf("순대국밥 주문 똑바로 받으세요 %d개만큼 없잖아요\n ", buysundaegugbab - bps2);
					porksoup -= bps1;
					sundaegugbab -= bps2;
					money += (porksoupprice * bps1) + (sundaegugbabprice * bps2);
					evaluation -= 10; // 제대로 주지 않았기에 평가가 감소함
					repurchase();

					if (evaluation < -1) {
						Thread.sleep(1000);
						String t = "평가도가 최하로 떨어져 가게가 망해서 폐업했습니다.\n\n" 
								+ "당신은 게임클리어에 실패했습니다.\n\n"
								+ "⠀⠀⠀⠀⠀⣀⣤⣶⣴⣤⣠⡀⠀⠀⠀⠀⠀⠀⣠⣤⢠⢐⡄⠀⠀⢀⣤⢀⡀⠀⠀⠀⢀⣤⡄⢀⠀⠀⡀⣄⣦⣶⣶⣶⣄⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢀⣼⣿⣿⠿⣿⣿⣿⣿⡆⠀⠀⠀⣠⣶⣿⡿⣾⣿⠁⡀⠀⣿⣿⣿⣎⡀⡴⣠⣿⡟⣿⢳⡇⢠⣿⣿⣿⢿⠛⠛⠛⠁⠋⠀⠀⠀\n"
								+ "⠀⠀⠀⣼⣿⡿⣡⡞⢸⣿⣿⠿⢟⡴⠀⣰⣿⣿⠋⣼⣿⣿⢸⡇⢸⣿⣿⣿⣿⢇⣱⣿⢟⣛⣻⢿⠀⣾⣿⣿⣑⣻⣤⣰⣶⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⢠⣿⣿⠃⣭⣤⣤⣦⣤⣤⡝⠶⢰⣿⣿⠧⢧⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣯⣿⣻⡇⠈⡿⡎⡇⣿⣿⣿⣿⣿⡿⡹⠟⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠸⣿⣿⣤⣈⣿⣿⣿⣿⣿⡿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⢿⣿⣿⣿⢯⣿⣯⣾⣷⢻⣿⣿⣿⡿⢟⣀⣄⣤⡎⣿⠀⠀⠀\n"
								+ "⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⢟⡵⠻⣿⣿⣏⡾⠀⢿⣿⣿⡏⢸⣿⣿⡇⣎⢿⣿⢯⢸⣿⣿⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⢣⡟⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠉⠙⠛⠉⠥⠈⠁⠀⠀⠈⠩⠌⠁⠀⠈⢉⡉⠵⠈⠛⠛⠣⢿⣃⣒⡳⠘⠿⠿⠿⠿⠜⠛⠛⠉⠭⠟⠛⠋⠑⠉⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⣠⣾⣿⣿⣷⣷⡄⠆⣰⣾⣷⠀⠀⠀⠀⣼⣿⣷⠀⢠⣦⣷⣿⣿⣿⣷⣗⢀⡤⢠⣷⣴⣶⡆⠒⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⣼⣿⣿⡿⢹⣿⣿⣿⠀⣿⣿⣿⢸⡇⠀⢰⣿⣿⡿⡀⣾⣿⣿⣻⣍⣉⣀⠀⠀⠀⢸⣿⡿⢋⡍⣾⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣸⣿⣿⣿⢧⢸⣿⣿⣿⡆⢸⣿⣿⡟⡿⢠⣿⣿⣿⣱⣧⣿⣿⣷⣶⣶⣴⣹⡇⠀⠀⣿⣿⠟⣘⣵⣿⣿⣿⢦⡾⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣿⣿⣿⣿⣼⣾⣿⣿⣿⢧⡾⣿⣿⣧⢡⣿⣿⣿⢳⡟⢸⣿⣿⣿⣟⡛⠃⠛⠁⢠⢸⣿⣿⣾⣿⣿⡿⣿⣕⠋⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢻⣿⣿⣿⣹⣿⣿⣿⡿⣼⠇⢿⣿⣿⣿⣿⣿⢣⡟⠀⣿⣿⣿⣯⣭⣵⣶⣾⣿⠀⣾⣿⣯⢿⣿⣿⣮⡮⠻⣆⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⢟⣽⣯⣤⣜⠏⣽⡿⣿⢣⣿⣶⡆⣿⣿⣿⣿⣿⣿⣿⣿⢯⡎⣿⣿⣿⣿⣿⢿⣿⣿⡅⣿⣇⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠐⠒⠛⠓⠚⠛⠛⠛⠛⠛⠻⠖⠶⠶⠿⠿⠿⠿⠾⠶⠶⠶⠾⠷⠶⠾⠻⠿⠞⠛⠛⠛⠛⠛⠋⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀\n" 
								+ "메인 화면으로 되돌아갑니다.\n\n"
								+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n";
						for (int i = 0; i < t.length(); i++) {
							Thread.sleep(25);
							System.out.print(t.charAt(i));
						}
						me = new Menu2();
						me.gameOver();

					}

				} else if (bps1 == buyporksoup && bps2 > buysundaegugbab) {
					System.out.printf("제가 돼지로 보이시나요 ?\n");
					porksoup -= bps1;
					sundaegugbab -= bps2;
					money += (porksoupprice * bps1) + (sundaegugbabprice * bps2);
					evaluation -= 10; // 원하는거 이상줬기때문에 평가가 감소함
					repurchase();

					if (evaluation < -1) {
						Thread.sleep(1000);
						String t = "평가도가 최하로 떨어져 가게가 망해서 폐업했습니다.\n\n" 
								+ "게임클리어에 실패했습니다.\n\n"
								+ "⠀⠀⠀⠀⠀⣀⣤⣶⣴⣤⣠⡀⠀⠀⠀⠀⠀⠀⣠⣤⢠⢐⡄⠀⠀⢀⣤⢀⡀⠀⠀⠀⢀⣤⡄⢀⠀⠀⡀⣄⣦⣶⣶⣶⣄⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢀⣼⣿⣿⠿⣿⣿⣿⣿⡆⠀⠀⠀⣠⣶⣿⡿⣾⣿⠁⡀⠀⣿⣿⣿⣎⡀⡴⣠⣿⡟⣿⢳⡇⢠⣿⣿⣿⢿⠛⠛⠛⠁⠋⠀⠀⠀\n"
								+ "⠀⠀⠀⣼⣿⡿⣡⡞⢸⣿⣿⠿⢟⡴⠀⣰⣿⣿⠋⣼⣿⣿⢸⡇⢸⣿⣿⣿⣿⢇⣱⣿⢟⣛⣻⢿⠀⣾⣿⣿⣑⣻⣤⣰⣶⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⢠⣿⣿⠃⣭⣤⣤⣦⣤⣤⡝⠶⢰⣿⣿⠧⢧⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣯⣿⣻⡇⠈⡿⡎⡇⣿⣿⣿⣿⣿⡿⡹⠟⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠸⣿⣿⣤⣈⣿⣿⣿⣿⣿⡿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⢿⣿⣿⣿⢯⣿⣯⣾⣷⢻⣿⣿⣿⡿⢟⣀⣄⣤⡎⣿⠀⠀⠀\n"
								+ "⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⢟⡵⠻⣿⣿⣏⡾⠀⢿⣿⣿⡏⢸⣿⣿⡇⣎⢿⣿⢯⢸⣿⣿⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⢣⡟⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠉⠙⠛⠉⠥⠈⠁⠀⠀⠈⠩⠌⠁⠀⠈⢉⡉⠵⠈⠛⠛⠣⢿⣃⣒⡳⠘⠿⠿⠿⠿⠜⠛⠛⠉⠭⠟⠛⠋⠑⠉⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⣠⣾⣿⣿⣷⣷⡄⠆⣰⣾⣷⠀⠀⠀⠀⣼⣿⣷⠀⢠⣦⣷⣿⣿⣿⣷⣗⢀⡤⢠⣷⣴⣶⡆⠒⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⣼⣿⣿⡿⢹⣿⣿⣿⠀⣿⣿⣿⢸⡇⠀⢰⣿⣿⡿⡀⣾⣿⣿⣻⣍⣉⣀⠀⠀⠀⢸⣿⡿⢋⡍⣾⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣸⣿⣿⣿⢧⢸⣿⣿⣿⡆⢸⣿⣿⡟⡿⢠⣿⣿⣿⣱⣧⣿⣿⣷⣶⣶⣴⣹⡇⠀⠀⣿⣿⠟⣘⣵⣿⣿⣿⢦⡾⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣿⣿⣿⣿⣼⣾⣿⣿⣿⢧⡾⣿⣿⣧⢡⣿⣿⣿⢳⡟⢸⣿⣿⣿⣟⡛⠃⠛⠁⢠⢸⣿⣿⣾⣿⣿⡿⣿⣕⠋⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢻⣿⣿⣿⣹⣿⣿⣿⡿⣼⠇⢿⣿⣿⣿⣿⣿⢣⡟⠀⣿⣿⣿⣯⣭⣵⣶⣾⣿⠀⣾⣿⣯⢿⣿⣿⣮⡮⠻⣆⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⢟⣽⣯⣤⣜⠏⣽⡿⣿⢣⣿⣶⡆⣿⣿⣿⣿⣿⣿⣿⣿⢯⡎⣿⣿⣿⣿⣿⢿⣿⣿⡅⣿⣇⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠐⠒⠛⠓⠚⠛⠛⠛⠛⠛⠻⠖⠶⠶⠿⠿⠿⠿⠾⠶⠶⠶⠾⠷⠶⠾⠻⠿⠞⠛⠛⠛⠛⠛⠋⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀\n" 
								+ "메인 화면으로 되돌아갑니다.\n\n"
								+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n\n";
						for (int i = 0; i < t.length(); i++) {
							Thread.sleep(25);
							System.out.print(t.charAt(i));
						}
						me = new Menu2();
						me.gameOver();

					}

				} else if (bps1 < buyporksoup && bps2 == buysundaegugbab) {
					System.out.printf("돼지국밥 주문 똑바로 받으세요 %d개만큼 없잖아요\n", buyporksoup - bps1);
					porksoup -= bps1;
					sundaegugbab -= bps2;
					money += (porksoupprice * bps1) + (sundaegugbabprice * bps2);
					evaluation -= 10; // 제대로 주지 않았기에 평가가 감소함
					repurchase();
					if (evaluation < -1) {
						Thread.sleep(1000);
						String t = "평가도가 최하로 떨어져 가게가 망해서 폐업했습니다.\n\n" 
								+ "게임클리어에 실패했습니다.\n\n"
								+ "⠀⠀⠀⠀⠀⣀⣤⣶⣴⣤⣠⡀⠀⠀⠀⠀⠀⠀⣠⣤⢠⢐⡄⠀⠀⢀⣤⢀⡀⠀⠀⠀⢀⣤⡄⢀⠀⠀⡀⣄⣦⣶⣶⣶⣄⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢀⣼⣿⣿⠿⣿⣿⣿⣿⡆⠀⠀⠀⣠⣶⣿⡿⣾⣿⠁⡀⠀⣿⣿⣿⣎⡀⡴⣠⣿⡟⣿⢳⡇⢠⣿⣿⣿⢿⠛⠛⠛⠁⠋⠀⠀⠀\n"
								+ "⠀⠀⠀⣼⣿⡿⣡⡞⢸⣿⣿⠿⢟⡴⠀⣰⣿⣿⠋⣼⣿⣿⢸⡇⢸⣿⣿⣿⣿⢇⣱⣿⢟⣛⣻⢿⠀⣾⣿⣿⣑⣻⣤⣰⣶⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⢠⣿⣿⠃⣭⣤⣤⣦⣤⣤⡝⠶⢰⣿⣿⠧⢧⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣯⣿⣻⡇⠈⡿⡎⡇⣿⣿⣿⣿⣿⡿⡹⠟⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠸⣿⣿⣤⣈⣿⣿⣿⣿⣿⡿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⢿⣿⣿⣿⢯⣿⣯⣾⣷⢻⣿⣿⣿⡿⢟⣀⣄⣤⡎⣿⠀⠀⠀\n"
								+ "⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⢟⡵⠻⣿⣿⣏⡾⠀⢿⣿⣿⡏⢸⣿⣿⡇⣎⢿⣿⢯⢸⣿⣿⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⢣⡟⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠉⠙⠛⠉⠥⠈⠁⠀⠀⠈⠩⠌⠁⠀⠈⢉⡉⠵⠈⠛⠛⠣⢿⣃⣒⡳⠘⠿⠿⠿⠿⠜⠛⠛⠉⠭⠟⠛⠋⠑⠉⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⣠⣾⣿⣿⣷⣷⡄⠆⣰⣾⣷⠀⠀⠀⠀⣼⣿⣷⠀⢠⣦⣷⣿⣿⣿⣷⣗⢀⡤⢠⣷⣴⣶⡆⠒⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⣼⣿⣿⡿⢹⣿⣿⣿⠀⣿⣿⣿⢸⡇⠀⢰⣿⣿⡿⡀⣾⣿⣿⣻⣍⣉⣀⠀⠀⠀⢸⣿⡿⢋⡍⣾⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣸⣿⣿⣿⢧⢸⣿⣿⣿⡆⢸⣿⣿⡟⡿⢠⣿⣿⣿⣱⣧⣿⣿⣷⣶⣶⣴⣹⡇⠀⠀⣿⣿⠟⣘⣵⣿⣿⣿⢦⡾⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣿⣿⣿⣿⣼⣾⣿⣿⣿⢧⡾⣿⣿⣧⢡⣿⣿⣿⢳⡟⢸⣿⣿⣿⣟⡛⠃⠛⠁⢠⢸⣿⣿⣾⣿⣿⡿⣿⣕⠋⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢻⣿⣿⣿⣹⣿⣿⣿⡿⣼⠇⢿⣿⣿⣿⣿⣿⢣⡟⠀⣿⣿⣿⣯⣭⣵⣶⣾⣿⠀⣾⣿⣯⢿⣿⣿⣮⡮⠻⣆⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⢟⣽⣯⣤⣜⠏⣽⡿⣿⢣⣿⣶⡆⣿⣿⣿⣿⣿⣿⣿⣿⢯⡎⣿⣿⣿⣿⣿⢿⣿⣿⡅⣿⣇⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠐⠒⠛⠓⠚⠛⠛⠛⠛⠛⠻⠖⠶⠶⠿⠿⠿⠿⠾⠶⠶⠶⠾⠷⠶⠾⠻⠿⠞⠛⠛⠛⠛⠛⠋⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀\n" 
								+ "메인 화면으로 되돌아갑니다.\n\n"
								+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n";
						for (int i = 0; i < t.length(); i++) {
							Thread.sleep(25);
							System.out.print(t.charAt(i));
						}
						me = new Menu2();
						me.gameOver();

					}

				} else if (bps1 > buyporksoup && bps2 == buysundaegugbab) {
					System.out.printf("제가 돼지로 보이시나요 ?\n");
					porksoup -= bps1;
					sundaegugbab -= bps2;
					money += (porksoupprice * bps1) + (sundaegugbabprice * bps2);
					evaluation -= 10; // 원하는거 이상줬기때문에 평가가 감소함
					repurchase();

					if (evaluation < -1) {
						Thread.sleep(1000);
						String t = "평가도가 최하로 떨어져 가게가 망해서 폐업했습니다.\n\n" 
								+ "게임클리어에 실패했습니다.\n\n"
								+ "⠀⠀⠀⠀⠀⣀⣤⣶⣴⣤⣠⡀⠀⠀⠀⠀⠀⠀⣠⣤⢠⢐⡄⠀⠀⢀⣤⢀⡀⠀⠀⠀⢀⣤⡄⢀⠀⠀⡀⣄⣦⣶⣶⣶⣄⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢀⣼⣿⣿⠿⣿⣿⣿⣿⡆⠀⠀⠀⣠⣶⣿⡿⣾⣿⠁⡀⠀⣿⣿⣿⣎⡀⡴⣠⣿⡟⣿⢳⡇⢠⣿⣿⣿⢿⠛⠛⠛⠁⠋⠀⠀⠀\n"
								+ "⠀⠀⠀⣼⣿⡿⣡⡞⢸⣿⣿⠿⢟⡴⠀⣰⣿⣿⠋⣼⣿⣿⢸⡇⢸⣿⣿⣿⣿⢇⣱⣿⢟⣛⣻⢿⠀⣾⣿⣿⣑⣻⣤⣰⣶⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⢠⣿⣿⠃⣭⣤⣤⣦⣤⣤⡝⠶⢰⣿⣿⠧⢧⣿⣿⣿⢸⡇⣿⣿⣿⣿⣿⣯⣿⣻⡇⠈⡿⡎⡇⣿⣿⣿⣿⣿⡿⡹⠟⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠸⣿⣿⣤⣈⣿⣿⣿⣿⣿⡿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⢿⣿⣿⣿⢯⣿⣯⣾⣷⢻⣿⣿⣿⡿⢟⣀⣄⣤⡎⣿⠀⠀⠀\n"
								+ "⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⢟⡵⠻⣿⣿⣏⡾⠀⢿⣿⣿⡏⢸⣿⣿⡇⣎⢿⣿⢯⢸⣿⣿⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⢣⡟⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠉⠙⠛⠉⠥⠈⠁⠀⠀⠈⠩⠌⠁⠀⠈⢉⡉⠵⠈⠛⠛⠣⢿⣃⣒⡳⠘⠿⠿⠿⠿⠜⠛⠛⠉⠭⠟⠛⠋⠑⠉⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⣠⣾⣿⣿⣷⣷⡄⠆⣰⣾⣷⠀⠀⠀⠀⣼⣿⣷⠀⢠⣦⣷⣿⣿⣿⣷⣗⢀⡤⢠⣷⣴⣶⡆⠒⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⣼⣿⣿⡿⢹⣿⣿⣿⠀⣿⣿⣿⢸⡇⠀⢰⣿⣿⡿⡀⣾⣿⣿⣻⣍⣉⣀⠀⠀⠀⢸⣿⡿⢋⡍⣾⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣸⣿⣿⣿⢧⢸⣿⣿⣿⡆⢸⣿⣿⡟⡿⢠⣿⣿⣿⣱⣧⣿⣿⣷⣶⣶⣴⣹⡇⠀⠀⣿⣿⠟⣘⣵⣿⣿⣿⢦⡾⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⣿⣿⣿⣿⣼⣾⣿⣿⣿⢧⡾⣿⣿⣧⢡⣿⣿⣿⢳⡟⢸⣿⣿⣿⣟⡛⠃⠛⠁⢠⢸⣿⣿⣾⣿⣿⡿⣿⣕⠋⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⢻⣿⣿⣿⣹⣿⣿⣿⡿⣼⠇⢿⣿⣿⣿⣿⣿⢣⡟⠀⣿⣿⣿⣯⣭⣵⣶⣾⣿⠀⣾⣿⣯⢿⣿⣿⣮⡮⠻⣆⠀⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⢟⣽⣯⣤⣜⠏⣽⡿⣿⢣⣿⣶⡆⣿⣿⣿⣿⣿⣿⣿⣿⢯⡎⣿⣿⣿⣿⣿⢿⣿⣿⡅⣿⣇⠀⠀⠀⠀⠀⠀\n"
								+ "⠀⠀⠀⠀⠀⠐⠒⠛⠓⠚⠛⠛⠛⠛⠛⠻⠖⠶⠶⠿⠿⠿⠿⠾⠶⠶⠶⠾⠷⠶⠾⠻⠿⠞⠛⠛⠛⠛⠛⠋⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀\n" 
								+ "메인 화면으로 되돌아갑니다.\n\n"
								+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n";
						for (int i = 0; i < t.length(); i++) {
							Thread.sleep(25);
							System.out.print(t.charAt(i));
						}
						me = new Menu2();
						me.gameOver();

					}

				}
			} else {
				System.out.println("국밥을 더 만들어야합니다.");
			}

		} else if (buyporksoup == -1 && buysundaegugbab == -1) {
			System.out.println("변경해주세요 ");
		}
	}

	private void checkMoney() {
		System.out.printf("현재 장사로 수익 :  %9d \n", money);
	}

	public void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}

	public void store() throws InterruptedException {
		boolean a = true;
		Thread.sleep(1000);
		String t = "상점으로 들어가는중입니다.\n"
				+ "━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━\n";
		for (int i = 0; i < t.length(); i++) {
			Thread.sleep(25);
			System.out.print(t.charAt(i));
		}
		while (a) {
			System.out.println(
					"- - - - - - - - - - - - - - - - - - 상 점 - - - - - - - - - - - - - - - - - - - - - - - -\n");
			System.out.println("(1) 조금 큰 가게로 확장하기	(2) 큰 가게로 확장하기	(3) 프렌차이즈화  (4) 돌아가기");
			System.out.println(
					"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				System.out.println("조금 큰 가게로 확장하기위해선 3000원을 넣어주셔야합니다\n");
				int mone = sc.nextInt();
				sc.nextLine();
				if (mone > money) {
					System.out.println("잔액이 부족합니다.");
				} else {
					money -= mone;
					System.out.println("확장이 완료되었습니다");
				}

			} else if (menu == 2) {
				System.out.println("조금 큰 가게로 확장하기위해선 4000원을 넣어주셔야합니다\n");
				int mone = sc.nextInt();
				sc.nextLine();
				if (mone > money) {
					System.out.println("잔액이 부족합니다.");
				} else {
					money -= mone;
					System.out.println("확장이 완료되었습니다");
				}

			} else if (menu == 3) {
				System.out.println("조금 큰 가게로 확장하기위해선 5000원을 넣어주셔야합니다\n");
				int mone = sc.nextInt();
				sc.nextLine();
				if (mone > money) {
					System.out.println("잔액이 부족합니다.");
				} else {
					money -= mone;
					System.out.println("확장이 완료되었습니다");
				}
				System.out.println("축하합니다. 당신은 게임을 클리어 하였습니다.");
				
				break;
			} else if (menu == 4) {
				a = false;
				break;
			}
		}
	}
	public void peoples() {
		System.out.println("⠀⢠⣤⠄⠀⠀⠀⠀⣴⣦⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀");
		System.out.println("⠀⣨⣯⠆⠀⠀⠀⣀⣽⠋⠀⠀⠀⢀⣠⣤⣤⣿⡿⠀⠀⠀⠀");
		System.out.println("⠰⣿⣿⠀⠀⠀⣰⣿⣿⡇⠀⠀⠀⣿⣷⣿⣿⢷⣄⣤⡦⠀⠀");
		System.out.println("⠘⣿⣿⠁⠀⠀⢿⣿⣿⣇⠀⠀⢀⣿⣿⡿⠃⠈⠉⠀⢠⠀⠀⠀");
		System.out.println("⠀⣏⠿⠀⠀⠀⢸⣿⣿⣿⣀⠀⠈⢿⣟⢿⡄⠀⠀⠀⠘⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀⣸⡟⣿⠃⠀⠀⠀⠀⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⣼⡏⢿⡇⠀⠀⠀⠛⠒⠛⠒⠀⠀⠀⠀⠀⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⣼⡿⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⠙⠒⠀⠀⠓⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		
	}

}
