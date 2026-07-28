package Multithreading;

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"-count "+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }
        }
    }
}
public class ThreadCreationUsingThread{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}
