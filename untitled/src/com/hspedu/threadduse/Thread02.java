package com.hspedu.threadduse;

public class Thread02 {
    public static void main(String[] args) {
        People people= new People();
        Thread thread = new Thread(people);
        thread.start();
    }
}

class People implements Runnable {
    int count = 0;
    @Override
    public void run() {

        while (true){
            System.out.println("666" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
