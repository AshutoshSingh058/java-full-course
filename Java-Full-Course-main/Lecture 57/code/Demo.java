import java.util.*;
import java.util.concurrent.CompletableFuture;



public class Demo{

    public static void main(String[] args){
        // CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()-> 10)
        //                                 .thenApply(result -> result*2)
        //                                 .thenApply(result ->result*3);

        // CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(()-> 10)
        //                                 .thenAccept(result ->System.out.println(result));

        // CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(()-> 10)
        //                                 .thenRun(() -> System.out.println("Done"));


        // try{
        //     System.out.println(f1.get());
        // }
        // catch(Exception e) {}

        
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()-> 10)
                                        .thenApply(result ->result*3);

        
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(()-> 5)
                                        .thenApply(result ->result*3);


        CompletableFuture<Void> result = f1.thenCombine(f2, (a,b)-> a+b)
                                            .thenAccept(r -> System.out.println(r));

    }
}