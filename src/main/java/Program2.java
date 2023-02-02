import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Program2 {
    public static void main(String[] args)
    {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(sum(d1, d2));
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        int first = 0;
        int second = 0;
        Deque<Integer> result = new ArrayDeque<>();
        for(int i = 0; i <= d1.size()+1; i++)
        {
            int var = d1.pollFirst();
            first += var * Math.pow(10, i);
        }

        for(int i = 0; i <= d2.size()+1; i++)
        {
            int var = d2.pollFirst();
            second += var * Math.pow(10, i);
        }
        int res = first + second;
        boolean mask = false;
        while(!mask)
        {
            double ost = (res%10);
            if(res == 0)mask = true;
            else{
                res = res / 10;
                result.addLast((int)(ost));
            }
        }
        return result;
    }
}
