public class threadName extends Thread {

    @Override
    public void run() {
        System.out.println("Thread task " +Thread.currentThread().getName());
    }
    public static void main(String[] args) {
          System.out.println("thread  " +Thread.currentThread().getName());

          threadName tn=new threadName();
          tn.setName("tota");
          tn.start();
    }
}
