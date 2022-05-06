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
			System.out.println("회원가입을 시작합니다.");
			System.out.println("이름을 입력해주세요");
			vo.setName(sc.nextLine());
			System.out.println("사용하실 ID를 입력해주세요.");
			vo.setUserId(sc.nextLine());
			System.out.println("비밀번호를 입력해주세요.");
			vo.setPassword(sc.nextLine());
			System.out.println("비밀번호를 재확인하겠습니다.");
			while(true) {
				String ps2 = sc.nextLine();
				if(password.equal(ps2)) {
					vo.setPassword(ps2);
					break;
				} else {
					System.out.println("입력하신 비밀번호가 틀렸습니다 다시 입력해주세요.");
				}
			}
			int n = gs.insertGugbab(vo);
			if(n !=0) {
				System.out.println("정상적으로 가입이 되었습니다.");
			}else {
				System.out.println("다시 가입해주세요");
			}
		}

}
