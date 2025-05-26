package Multithread;

public class ThreadDeadlock {

	public static void main(String[] args) throws InterruptedException {
		// WAP to create a deadlock scenario programmatically
		Object ob1 = new Object();
		Object ob2 = new Object();
		Object ob3 = new Object();
		
		Thread t1 = new Thread(new SyncThread(ob1, ob2), "t1");
		Thread t2 = new Thread(new SyncThread(ob2, ob3), "t2");
		Thread t3 = new Thread(new SyncThread(ob3, ob1), "t3");
		
		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();

	}

}

class SyncThread implements Runnable{
	private Object obj1;
	private Object obj2;
	
	public SyncThread(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on "+obj1);
		synchronized(obj1) {
			System.out.println(name + " acquiring lock on "+obj1+ " inside sync block");
			work();
			System.out.println(name + " acquiring lock on "+obj2+" inside sync block");
			synchronized(obj2) {
				System.out.println(name + " acquiring lock on "+obj2+" inside nested sync block");
				work();
			}
			System.out.println(name + " released lock on "+obj2);
		}
		System.out.println(name + " released lock on "+obj1);
		System.out.println(name + " finished execution ");
	}
	
	private void work() {
		try {
			Thread.sleep(30000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
