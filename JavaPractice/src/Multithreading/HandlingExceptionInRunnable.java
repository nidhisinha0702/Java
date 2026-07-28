package Multithreading;

class MyRunnable implements Runnable{
    @Override
    public void run() throws ArithmeticException{
        try{
            int result = 10/0;
        }catch(ArithmeticException ai){
            System.out.println("Exception handled inside runnable");
        }
    }
}
public class HandlingExceptionInRunnable {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
    }
}
