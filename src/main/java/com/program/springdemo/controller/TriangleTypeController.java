package com.program.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.program.springdemo.service.TriangleTypeImpl;

@RestControllerAdvice
public class TriangleTypeController {
    
	
	
	@Autowired 
	TriangleTypeImpl triangleTypeImpl;
	
	
	public ResponseEntity<String> getTriangleBasedOnSide(@RequestParam int triangleside1, @RequestParam int triangleside2,@RequestParam int triangleside3)
	{
		
		//String typeOfTriangle=triangleTypeImpl.getTriangleSide(int triangleside1,int triangleside2,int triangleside3);
		
		return null;
		
	}
}
