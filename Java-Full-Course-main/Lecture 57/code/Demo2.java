import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class Demo2{

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6};
        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new  SumTask(arr, 0, arr.length-1 );
        int result = pool.invoke(task);

        System.out.println(result); 

        pool.shutdown();
    }
}


class SumTask extends RecursiveTask<Integer>{

    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute(){
        //base
        if(end - start <= 2){
            int sum =0;
            for(int i = start; i<=end; i++)sum+=arr[i];
            return sum;
        }

        //main logic
        int mid = (start+end)/2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid+1, end);


        // int sum1 = leftTask.compute();
        // int sum2 = rightTask.compute();

        // return sum1 + sum2;

        leftTask.fork();
        int sum2 = rightTask.compute();
        int sum1 = leftTask.join();

        return sum1+sum2;
        
    }

}