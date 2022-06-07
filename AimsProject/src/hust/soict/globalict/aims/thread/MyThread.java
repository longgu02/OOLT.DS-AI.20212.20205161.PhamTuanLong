package hust.soict.globalict.aims.thread;

public class MyThread extends Thread{
	public void run() {
        for(int i = 0 ; i < 5; i++) {
        	System.out.println(i);
        	try {
        		Thread.sleep(1000);
        	}catch(InterruptedException e) {
        		// Add later
        	}
        }
	}
}
 