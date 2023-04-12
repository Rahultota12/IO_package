public class singleThread extends Thread{

    // Single task and single threads
    /* 
    @Override
    public void run() {
       System.out.println("singleThread.run()");
    }
    public static void main(String[] args) {
        singleThread th=new singleThread();
        th.run();
    }

    */

 //============================single task and multi thread============================================================
 
 

/* 
 @Override
 public void run() {
     System.out.println("multi Thread.run()");
 }
   public static void main(String[] args) {
    singleThread th=new singleThread();
    th.run();
    singleThread th1=new singleThread();
    th1.run();
   }

   */


   //===========================multi task and single thread=============================================================



   @Override
   public void run() {
       System.out.println("multi task and single thread.run()");
   }

   public void runing(){
       System.out.print("runing");
   }

   public static void main(String[] args) {
    singleThread th=new singleThread();
    th.start();
    th.runing();
   }

   
}