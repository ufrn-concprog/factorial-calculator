import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Long> {
	private int number;
	
	public FactorialCalculator(int number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		return factorial(number);
	}

	private long factorial(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return number * factorial(number-1);
		}
	}
}
