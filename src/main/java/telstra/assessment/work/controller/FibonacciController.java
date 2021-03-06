package telstra.assessment.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import telstra.assessment.work.service.FibonnaciSeriesImpl;

@RestController
@RequestMapping("/api")
public class FibonacciController {

	@Autowired
	private FibonnaciSeriesImpl fibonacciService;

	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	public ResponseEntity<Long> getFibonacciNumber(@RequestParam("n") Object nthFibNum) throws IllegalArgumentException{
		try {
			Long fibonnaciNumber = new Long(nthFibNum.toString());

			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").body(fibonacciService.getFibonacci(fibonnaciNumber));
		} catch (NumberFormatException invalidinput) {

			throw new IllegalArgumentException("Invalid Input");
		}
	}
}