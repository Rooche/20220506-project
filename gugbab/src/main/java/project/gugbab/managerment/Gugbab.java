package project.gugbab.managerment;

import java.util.Scanner;
import project.gugbab.service.GugbabService;
import project.gugbab.service.GugbabVO;
import project.gugbab.serviceImpl.GugbabServiceImpl;

public class Gugbab {

	GugbabService gs = new GugbabServiceImpl();
	GugbabVO vo = new GugbabVO();
	Scanner sc = new Scanner(System.in);

	public void insertGugbab() {
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠛⠛⠛⠛⠛⠻⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠠⠼⠿⠋⠁⠹⠿⢿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⢠⣤⣾⠀⠀⠂⠀⠀⠀⠄⠉⠻⠠⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠙⠏⠠⠀⠀⠀⠁⠀⠀⣠⣶⣧⡀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⡒⠀⠀⠀⠈⠆⢀⠘⠀⡀⠋⠉⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠉⠀⠈⠁⠀⠈⠛⠀⢁⠀⢀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⢘⡀⠀⠀⣀⠆⠂⠄⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⣀⣀⣀⣀⣀⣁⣀⣀⣀⣠⣠⣀⣀⣀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⠛⡏⡏⢹⠟⢋⠛⢿⠉⣿⠛⠋⠙⠛⠉⣿⠋⣉⠙⡏⢹⣿⣿⠛⠛⠛⡏⢹⡟⢉⡉⠻⡏⢹⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢀⡇⡃⢸⡀⠻⠃⣸⠀⣿⠃⢤⡄⢹⠀⡟⠀⠉⠀⠃⢸⣿⣿⣿⠟⢰⡇⠘⣃⠘⠃⣠⡇⢸⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣠⣾⡇⡇⢸⣿⠀⣾⣿⣀⣿⠓⠂⠐⣛⠀⣿⡆⣀⣧⣄⣸⣿⣟⢁⣴⣿⡇⢸⣿⠀⢙⣛⡃⢸⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣧⣼⣿⣤⣤⣤⣤⣼⣿⣿⣿⣿⣤⣿⣧⣤⣤⣤⣤⣿⣿⣿⣿⣿⣧⣼⣿⣤⣤⣤⣤⣼⣿⣿⣿⣿⣿");
		System.out.println("");
		System.out.println("게임을 시작하려면 회원가입을 해야합니다");
		System.out.println("회원가입을 시작합니다.");
		System.out.println("사용하실 ID를 입력해주세요.");
		vo.setUserId(sc.nextLine());
		System.out.println("이름을 입력해주세요");
		vo.setName(sc.nextLine());
		System.out.println("비밀번호를 입력해주세요.");
		vo.setPassword(sc.nextLine());

		int n = gs.insertGugbab(vo);
		if (n != 0) {
			System.out.println("정상적으로 가입이 되었습니다.");
		} else {
			System.out.println("다시 가입해주세요");
		}
	}

	public void login() {
		System.out.println("아이디를 입력해주세요.");
		vo.setUserId(sc.next());
		System.out.println("비밀번호를 입력해주세요");
		vo.setPassword(sc.next());
	}

}
