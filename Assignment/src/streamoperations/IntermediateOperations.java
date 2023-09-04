package streamoperations;

import java.util.Arrays;
import java.util.List;

public class IntermediateOperations {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		System.out.print("ODD NUMBERS : [");
		list.stream().filter(x->x%2==1).forEach(x->{
			System.out.print(x);
			if(x!=5) {
				System.out.print(",");
				}
			if(x==5) {
				System.out.println("]");
			}

			});
		System.out.print("SQUARES [");
		list.stream().filter(x->x%2==1).forEach(x->{
			System.out.print(x*x);
			if(x!=5) {
				System.out.print(",");
				}
			if(x==5) {
				System.out.println("]");
			}

			});




		Integer[] numbers = {1, 2, 3, 4, 5};
		int sum = Arrays.stream(numbers)
	            .filter(n -> n % 2 != 0) // Filter odd numbers
	            .map(n -> n * n)         // Square each number
	            .reduce(0, Integer::sum); // Calculate the sum

	        System.out.println("SUM: " + sum);

	}

}
