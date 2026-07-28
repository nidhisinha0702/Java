package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running using runnable interface");
    }
}
public class ThreadCreationUsingRunnable {
    public static void main(String[] args) {
        MyTask mt = new MyTask();
        Thread t1 = new Thread(mt);
        t1.start();
        //with lambda expression
        Runnable r = () ->{
            System.out.println("Thread with lambda expression");
        };
        Thread t2 = new Thread(r);
        t2.start();
        //runnable with executorservice
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(()->{
            System.out.println("Task executed by executor");
        });

        executor.shutdown();
    }
}
