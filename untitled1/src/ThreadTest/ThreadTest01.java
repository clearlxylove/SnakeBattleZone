package ThreadTest;

import java.util.Random;
import java.util.Scanner;

public class ThreadTest01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t2.setDaemon(true);
        t1.start();
        t2.start();

    }
}

class T1 extends Thread {
    Random random = new Random();
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            int randomNum = random.nextInt(101);
            System.out.println(randomNum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class T2 extends Thread {
    T1 t1 = new T1();
    Scanner sc = new Scanner(System.in);

    public T2(T1 t1){
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            char key = sc.next().toUpperCase().charAt(0);
            if(key == 'Q'){
                t1.setLoop(false);
                System.out.println("t1已退出");
            }
        }
    }
}