public class ThreadAssignment {

    static class Counter {
        void count() {
            
            int n=351;
            while(n--){
            System.out.println(n);
            }
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            
            synchronized (counter){
            counter.count();
            System.out.println("FINISH!");
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }   
        System.out.println("done!");
    }
}
