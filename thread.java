public class thread extends Thread{
    
    public void run() {
     System.out.println("thread 1 ");

    }
    void sleep(String string) {

        System.out.println(string);
    }
    public static void main(String[] args) {
        thread th=new thread();
        th.sleep("tota");
        th.start();
    }
 
}