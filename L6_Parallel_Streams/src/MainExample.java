import java.util.Arrays;
import java.util.List;

public class MainExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		list.parallelStream()
		.forEach(number->System.out.println(number+" "+Thread.currentThread().getName()));
	}

}
