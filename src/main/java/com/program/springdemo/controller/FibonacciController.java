package com.program.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.program.springdemo.service.FibonnaciSeriesImpl;

@RestControllerAdvice
public class FibonacciController {

	@Autowired
	FibonnaciSeriesImpl fibonnaciSeriesImpl;

	@GetMapping("/api/Fibonacci")
	public ResponseEntity<?> getFibonacciSequence(@RequestParam long Fibonacci) {

		long[] fibonaciResults = fibonnaciSeriesImpl.getFibonacci(Fibonacci);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body(fibonaciResults);

	}

}


