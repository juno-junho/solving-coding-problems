import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> mapTest = new HashMap<>();

        mapTest.put(1,"Hello");
        mapTest.put(3,"World");
        mapTest.put(100,"Java");
        mapTest.put(2, "apple");

        Iterator<Map.Entry<Integer, String>> iterator = mapTest.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next);
            System.out.println("integer : " + next.getKey() + " String : " + next.getValue() );
        }
        System.out.println(mapTest.keySet());
        System.out.println(mapTest.values());


        char[] chars = {'a','b','c','1','2','3'};

        String str = new String(chars);
        IntStream charStream = str.chars();
        // character로 출력
        charStream.forEach(i -> System.out.println((char)i));
        Stream<Character> characterStream = str.chars().mapToObj(i -> (char) i);


                
    }

}
