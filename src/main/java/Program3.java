import java.util.*;

public class Program3 {
    public static void main(String[] args)
    {
        Deque<String> d1 = new ArrayDeque<>(Arrays.asList("{", "(", ")", "}", "[", "]"));
        Deque<String> d2 = new ArrayDeque<>(Arrays.asList("{", "(", "(", "}", "[", "]"));
        String text1 = "Строка является правильной";
        String text2 = "Строка является не правильной";
        System.out.print(d1);
        System.out.println(validate(d1) ? text1 : text2);
        System.out.print(d2);
        System.out.println(validate(d2) ? text1 : text2);
    }

    public static boolean validate(Deque<String> deque){
        if(deque.size() % 2 != 0) return false;
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("}", "{");
        dictionary.put(")", "(");
        dictionary.put("]", "[");
        Deque<String> list = new ArrayDeque<>();
        int i = 0;
        for(String p :deque){
            if(i == 0)
            {
                if(dictionary.get(p) != null) return false;
                else list.addLast(p);
            }
            if(i != 0)
            {
                if(list.size() != 0)
                {
                    if(list.getLast() == dictionary.get(p))
                        list.removeLast();
                    else list.addLast(p);
                }
                else list.addLast(p);
            }
            i++;
        }
        if(list.size() == 0) return true;
        else return false;
    }
}
