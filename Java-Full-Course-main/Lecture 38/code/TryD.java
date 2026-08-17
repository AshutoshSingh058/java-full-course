import java.util.function.*;
import java.util.*;

public class TryD{

    public static void main(String[] args){
        // Function<Integer, Integer> square = x ->x*x;

        // System.out.println(square.apply(5));

        // Consumer<Integer> print = x-> System.out.println(x);
        // print.accept(15);

        // Function<Integer, Integer> eqn =x->((x+2)*3);
        Function<Integer,Integer> add2 = x-> x+2;
        Function<Integer,Integer> multiply3 =x -> x*3;

        int ans = multiply3.apply(add2.apply(5));
        int ans2 = add2.andThen(multiply3).apply(5);

        Function<Integer, Integer> ansFunc = add2.andThen(multiply3);
        int ans3 = ansFunc.apply(5);

    }
}