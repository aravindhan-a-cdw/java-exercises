package exercise_3;

public class D5_08_Thread {

	public static void main(String[] args) {
		StringBuffer strMain = new StringBuffer("A");
		
		ThreadExtended thread1 = new ThreadExtended(strMain);
		ThreadExtended thread2 = new ThreadExtended(strMain);
		ThreadExtended thread3 = new ThreadExtended(strMain);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}


class ThreadExtended extends Thread{
	
	StringBuffer str;
	
	public ThreadExtended(StringBuffer str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		
		synchronized(str) {
			
			for(int index = 0; index < 100; ++index) {
				System.out.println(str);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("End of 100 prints");
			char first = str.charAt(0);
			first++;
			str.setCharAt(0, first);
			System.out.println(str);
			
		}
	}
}
