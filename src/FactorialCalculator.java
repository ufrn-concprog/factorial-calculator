import java.util.concurrent.Callable;

/**
 * Calculator of the factorial of a number, implemented as a
 * <code>Callable</code> object to run upon a thread able to
 * return the calculated factorial
 * @see java.util.concurrent.Callable
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class FactorialCalculator implements Callable<Long> {
	/** Number to calculate factorial */
	private int number;

	/**
	 * Parameterized constructor
	 * @param number Number to calculate factorial
	 */
	public FactorialCalculator(int number) {
		this.number = number;
	}

	/**
	 * Task to run upon a thread
	 * @return Factorial of a given number
	 */
	@Override
	public Long call() {
		return factorial(this.number);
	}

	/**
	 * Recursively calculates the factorial of a given number
	 * @param number Number to calculate factorial
	 * @return Factorial of the number
	 */
	private long factorial(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return number * factorial(number-1);
		}
	}
}
