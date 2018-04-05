package com.program.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.program.springdemo.service.ReverseStringImpl;

@RestControllerAdvice
public class ReverseStringController {
    
	@Autowired
	ReverseStringImpl reverseStringImpl;
	
	@GetMapping("/api/ReverseWord")
	public ResponseEntity<String> getReverseString(@RequestParam String ReverseWord) {
		
		String reverseResultedString=reverseStringImpl.getReverseWordsfromString(ReverseWord);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body(reverseResultedString);
	}
}
