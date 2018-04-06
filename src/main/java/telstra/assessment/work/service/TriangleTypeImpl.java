package telstra.assessment.work.service;

import org.springframework.stereotype.Service;

@Service
public class TriangleTypeImpl {
	
	public String  getTriangleType(int triangleside1,int triangleside2,int triangleside3) {

		if(triangleside1==triangleside2 && triangleside2==triangleside3) {
			return "Equilateral";
		}
		else if (triangleside1 == triangleside2 || triangleside2 == triangleside3 || triangleside1 == triangleside3) {
			return "Isosceles";
		}
		else {
			return "Scalene";
		}
	}

}