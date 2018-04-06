package telstra.assessment.work.service;

import org.springframework.stereotype.Component;

@Component
public class FibonnaciSeriesImpl {

	private static final long LEN_MIN = 0;

	public long getFibonacci(long fibonnaciNumber){

		if (fibonnaciNumber < FibonnaciSeriesImpl.LEN_MIN) {

			throw new IllegalArgumentException(
					String.format("Length was less than %d. [%d]", FibonnaciSeriesImpl.LEN_MIN, fibonnaciNumber));
		}
		int fibFirstNum = 1;
		int fibSecondNum = 0;

		for (int i = 0; i <= fibonnaciNumber; i++) {
			int fibNum = fibFirstNum + fibSecondNum;
			fibFirstNum = fibSecondNum;
			fibSecondNum = fibNum;
		}
		return fibFirstNum;

	}
}
