package hust.soict.globalict.aims.thread;

public class MemoryDaemon implements java.lang.Runnable{
	long memoryUsed = 0;
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while(true) {
			used = rt.totalMemory() - rt.freeMemory();
			if(used != memoryUsed) {
				System.out.print("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}
}