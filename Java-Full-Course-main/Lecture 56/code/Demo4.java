import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

public class Demo4 {
   public static void main(String[] args) {
        // ThreadPoolExecutor executor = 
        // new ThreadPoolExecutor(2, 
        //                       5,
        //                       10 ,
        //                       TimeUnit.SECONDS, 
        //                       new ArrayBlockingQueue<>(2));

        // // ExecutorService executor2 = Executors.newFixedThreadPool(2);

        
        // for(int i = 1; i<=5; i++) {
        //     int taskId = i;

        //     executor.execute(() -> {
        //         System.out.println("Task " + taskId + " is perfromed by " +
        //             Thread.currentThread().getName()
        //         );

        //         try {
        //             Thread.sleep(2000);
        //         }
        //         catch(Exception e) {}
        //     });
        // }

        // executor.shutdown();

        // ExecutorService executor = Executors.newFixedThreadPool(3);
        // ExecutorService executor = Executors.newCachedThreadPool();
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newScheduledThreadPool(2);
        // ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        // executor.schedule(() -> {
        //     System.out.println("Task executed after 3 seconds");
        // }, 3, TimeUnit.SECONDS);
        
        for(int i=0; i<5; i++){
            int taskId = i;
            executor.execute(()-> {
                System.out.println("Task "+ taskId + " is performed by "+ Thread.currentThread()    .getName());
            });
        }
        executor.shutdown();

        // ThreadPoolExecutor executor = new ThreadPoolExecutor(
        //                                 2,
        //                                 5, 
        //                                 10, 
        //                                 TimeUnit.SECONDS, 
        //                                 new ArrayBlockingQueue<>(5) 
        //                             ); 
        
        // for(int i=1; i<=5; i++){
        //     int taskId = i;

        //     executor.execute(()->{
        //         System.out.println("Task "+ taskId+ " by "+ Thread.currentThread().getName());
        //         try{
        //             Thread.sleep(3000);
        //         }
        //         catch(Exception e){}
        //     });

        // }
        // executor.shutdown();
   } 
}