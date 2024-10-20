package com.hspedu.threadduse;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.start();
        dog.start();
        for (int i = 0;i<60;i++){
            System.out.println("main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat extends Thread {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("111" + ++count + "线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class Dog extends Thread {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("222" + ++count + "线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
