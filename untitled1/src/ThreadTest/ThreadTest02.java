package ThreadTest;

public class ThreadTest02 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        Thread thread1 = new Thread(t3);
        Thread thread2 = new Thread(t3);
        thread1.start();
        thread2.start();
    }

}

//涉及多线程共享资源，采用Runnable
class T3 implements Runnable {
    private int num = 10000;
    @Override
    public  void run() {
        while(num>0){
            synchronized(this){
                num = num -1000;
                System.out.println("当前线程名字：" + Thread.currentThread().getName()+" "+num);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
