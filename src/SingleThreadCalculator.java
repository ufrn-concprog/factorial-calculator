import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadCalculator {
	
	private static int[] numbers = { 1, 3, 5, 7, 9 };

	public static void main(String args[]) {
		ExecutorService executor =
			Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < numbers.length; i++) {
			Callable<Long> calculator = new FactorialCalculator(numbers[i]);
			Future<Long> factorial = executor.submit(calculator);
			try {
				System.out.print("Factorial of " + numbers[i] + ": ");
				System.out.print(factorial.get() + "\n");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
	}
}
