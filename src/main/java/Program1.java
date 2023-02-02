import java.util.*;

public class Program1 {
    public static void main(String[] args)
    {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,3,2,1));
        boolean mask =checkOn(deque);
        System.out.println(mask ? "Последовательность цифр является полиндромом" : "Последовательность цифр не является полиндромом");
    }

    public static boolean checkOn(Deque<Integer> deque){
        boolean mask = true;
        List<Integer> list = new ArrayList<Integer>();
        for(Integer p :deque){
            list.add(p);
        }

        int size = deque.size();
        for(int i = 0; i < size/2; i++)
        {
            if(list.get(i) != list.get(size - 1 - i))
            {
                mask = false;
                break;
            }
        }
        System.out.println(list);
        return mask;
    }
}
