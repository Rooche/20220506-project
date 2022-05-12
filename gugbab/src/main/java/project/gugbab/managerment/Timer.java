package project.gugbab.managerment;



public class Timer extends Thread {
	MainGame mg;
	int time =0; // 현재 진행 시간

	public void run() {
		mg = new MainGame();
		System.out.println("");
		while(true) {
			try {
				Thread.sleep(15000);
				time += 10; 
				System.out.println(time + "초 경과");

				if (time >= 10) {
					System.out.println("게임 시간이 끝났습니다.");
					mg.p = 99;
					break;
				}
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

