package exercise_3;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_04_DigitalClock {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(3);
		DigitalClock dg1 = new DigitalClock();
		
		exe.execute(() -> {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dg1.display();
				dg1.plusSecond(1);
			}
			
		});
		
		exe.execute(() -> {
			while(true) {
				
				try {
					Thread.sleep(1000 * 60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				dg1.plusMinute(1);
				System.out.println("1 Min Passed");
			}
			
		});
		
		exe.execute(() -> {
			while(true) {
				try {
					Thread.sleep(1000 * 60 * 60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				dg1.plusHour(1);
				System.out.println("1 Hour Passed");
			}
			
		});

	}

}

class DigitalClock{
	private int hour;
	private int minute;
	private int second;
	private String session;
	
	public DigitalClock() {
		LocalDateTime datetime = LocalDateTime.now();
		hour = datetime.getHour();
		minute = datetime.getMinute();
		second = datetime.getSecond();
		session = hour > 12 ? "AM" : "PM";
	}
	
	public void display() {
		System.out.printf("Time is %02d:%02d:%02d %s\n", hour, minute, second, session);
	}
	
	public void plusSecond(int sec) {
		this.second += sec;
		if(this.second == 60) {
			this.second = 0;
			plusMinute(1);
		}
	}
	
	public void plusMinute(int min) {
		this.minute += min;
		if(this.minute == 60) {
			this.minute = 0;
			plusHour(1);
		}
	}
	
	public void plusHour(int hour) {
		this.hour += hour;
		if(this.hour == 24) {
			this.hour = 0;
		}
	}
}


