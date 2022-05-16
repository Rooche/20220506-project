//package project.gugbab.managerment;
//
//
//
//public class GameTimer extends Thread {
//	
//	
////	@Override
////	public void run() {
////		for(int i=5; i>=1; i--){
////	//		if(T07_ThreadGame.inputCheck==true){
////				return;
////			}
////			System.out.println(i);
////			try {
////				Thread.sleep(1000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////		}
////		System.out.println("시간이 초과되어 당신이 졌습니다.");
////		System.exit(0);
////	}
////}
////	
//	
//	----------------------------------------------------------------------------
//	
//}
//	
////    JLabel la;
////    JLabel la1;
////    JLabel la2;
////    int min, sec;
////    int day=1;
////    
////    void ThreadTimerEx(){
////        this.setTitle("하루 2분");
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        this.setLayout(new BorderLayout(10,10));
////        MyThread th = new MyThread();
////        la=new JLabel();
////        la1=new JLabel();
////        la2=new JLabel();
////        
////        la.setFont(new Font("Gothic", Font.PLAIN, 50));
////        
////        la1.setFont(new Font("Gothic", Font.ITALIC, 20));
////        la1.setOpaque(true);// 색 설정
////        Color color = new Color(255,0,0);
////        la1.setForeground(color);
////        
////        la2.setFont(new Font("Gothic", Font.ITALIC, 20));
////        
////        this.add("Center",la);
////        this.add("North",la1);
////        this.add("West",la2);
////        
////        this.setLocationRelativeTo(null);
////        this.setSize(400,200);
////        this.setVisible(true);
////        this.setAlwaysOnTop(true); // 프레임 항상 위에 있게
////        th.start();
////    }
////    
////    public int time() {
////    	return min;
////    }
////    
////    public int day() {
////    	return day;
////    }
////    
////    
////    class MyThread extends Thread{
////        public void ru(){
////            int n=0;
////
////            while(true){
////            	n++;
////            	sec  = n % 60;
////                min  = n / 60 % 60;
////                
////                if(min==0) {
////                	la1.setText(String.format(" "));
////                }
////                if(min==1) {
////                	la1.setText(String.format("  "));
////                }
////                if(min==2) {
////                	n=0;
////                	day++;
////                }
////                la2.setText(String.format("        " + day +" 일차"));
////                //la.setText(Integer.toString(n++));
////            	la.setText(String.format("  %02d:%02d", min, sec));
////                try{
////                    sleep(1000);
////                }
////                catch(Exception e){
////                    return;
////                }
////            }
////        }
////    }
////	
////	
////	
//	
//	
//	
////----------------------------------------------------------------------------------------------
//	
//	
////	private  int i =0;
////	
////	public void run() {
////		while(true) {
////			try {
////				showSec();
////				sleep(100000);
////			}catch(InterruptedException e) {
////				e.printStackTrace();
////			}
////
////		}
////	}
////	
////	private void showSec() {
////
////		}
//
