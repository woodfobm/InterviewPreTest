import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.Math.toIntExact;

public class Rare {
	
    private static int nthMostRare(int[] elements, int n) throws NullPointerException{
    	// Link to solution:
    	// https://coderanch.com/t/690138/java/Code-Review-Find-Nth-Rarest
    	
    	// Arrays.stream makes a stream from a prim array
    	// .boxed transforms ints to Integers, since Map has Integer keys
    	// .collect collects results
    	// .groupingBy using an identity function
    	// Collectors.counting to count the number of Integers
    	Map<Integer, Long> map = Arrays.stream(elements).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    	
    	if (map.get(n) == null) {
    		throw new NullPointerException();
    	}
    	
    	// convert from Long to Integer
    	return toIntExact(map.get(n));
    		
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}
