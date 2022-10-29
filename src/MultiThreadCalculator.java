import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Concurrent calculation of the factorial of a set of numbers
 * using multiple threads (more specifically, within a thread pool)
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class MultiThreadCalculator {
	/** Number of threads to use */
	private static final int NUM_THREADS = 3;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 7, 9 };

		ExecutorService executor =
			Executors.newFixedThreadPool(NUM_THREADS);
		
		List<Future<Long>> results = new ArrayList<>();

		for (int number : numbers) {
			Callable<Long> calculator = new FactorialCalculator(number);
			Future<Long> factorial = executor.submit(calculator);
			results.add(factorial);
		}
		
		int i = 0;
		try {
			for (Future<Long> result : results) {
				System.out.print("Factorial of " + numbers[i] + ": ");
				System.out.print(result.get() + "\n");
				i++;
			}
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}
