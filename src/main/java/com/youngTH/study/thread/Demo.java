package com.youngTH.study.thread;

import org.junit.Test;

/**
 * @author YoungTH
 * @date 2019/2/18
 */
public class Demo {
    @Test
    public void fun0(){

//        com.youngTH.study.thread.demo

        Thread thread = new Thread(() -> {
            System.out.println("MyThead-start");
            System.out.println("MyThead-end");
        });
        thread.start();
    }

    @Test
    public void fun1() throws InterruptedException {
        int i=0;
        while (i<100) {
            i++;
            new Thread(() -> {
                System.out.println("MyThead-start");
                System.out.println("MyThead-end");
            }).start();
            System.out.println("This is main thread");
            Thread.sleep(100);
        }
    }

    @Test
    public void fun2(){
        MyThread1 my1 = new MyThread1();
        Thread t1 = new Thread(my1);
        Thread t2 = new Thread(my1);
        Thread t3 = new Thread(my1);
        Thread t4 = new Thread(my1);
        Thread t5 = new Thread(my1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    @Test
    public void fun3(){
        MyThread2 my2 = new MyThread2();
        Thread t1 = new Thread(my2);
        Thread t2 = new Thread(my2);
        Thread t3 = new Thread(my2);
        Thread t4 = new Thread(my2);
        Thread t5 = new Thread(my2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    @Test
    public void fun4() throws InterruptedException {
        Demo demo = new Demo();
        MyThread3 myThread3_1 = new MyThread3(demo);
        MyThread3 myThread3_2 = new MyThread3(demo);
        myThread3_1.setName("a");
        myThread3_2.setName("b");
        myThread3_1.start();
        Thread.sleep(1000);
        myThread3_2.start();
    }


    public synchronized void testException1() {
        int i=0;
        while(i<10){
            i++;
            if(i==5){
                try {
                    Integer.parseInt("a");
                }catch (Exception e){
                }
            }
            System.out.println("this is testException1"+">>>>"+i);
        }
    }

    public synchronized void testException2(){
        System.out.println("this is testException2");
    }

}

class MyThread1 extends Thread{
    private int i=5;
    @Override
    public void run() {
        super.run();
        System.out.println("i="+(i--)+" threadName="+Thread.currentThread().getName());
    }
}
class MyThread2 extends Thread{
    private int i=5;
    @Override
    public void run() {
        super.run();
        i--;
        System.out.println("i="+i+" threadName="+Thread.currentThread().getName());
    }
}
class MyThread3 extends Thread{
    private Demo demo;
    public MyThread3(Demo demo){
        this.demo=demo;
    }
    @Override
    public void run() {
        if(Thread.currentThread().getName().equalsIgnoreCase("a")){
            demo.testException1();
        }else{
            demo.testException2();
        }
    }
}