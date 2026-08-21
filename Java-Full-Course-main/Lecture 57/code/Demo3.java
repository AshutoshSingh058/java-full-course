import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3 {

    public static void main(String [] args){
        // Thread t1 = Thread.startVirtualThread(()->{
        //     System.out.println(Thread.currentThread() + " hi t1");
        // });

        // try{
        //     t1.join();
        // }
        // catch(Exception e){}

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for(int i=0; i<5; i++){
            executor.submit(()->{
                System.out.println(Thread.currentThread() + " hi");
            });
        }

        try{
            Thread.sleep(3000);

        }
        catch(Exception e){};

        executor.shutdown();

    }


}