package telstra.assessment.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telstra.assessment.work.service.TriangleTypeImpl;




@RestController
@RequestMapping("/api")
public class TriangleTypeController {
	
	@Autowired
	private TriangleTypeImpl triangleTypeService;
	
    @RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
    public ResponseEntity<String> fetchTriangleType(@RequestParam("a")  Object sideLength1,@RequestParam("b")  Object sideLength2,@RequestParam("c")  Object sideLength3) throws IllegalArgumentException{
                    
                    try {
                                    Integer limit1 = new Integer(sideLength1.toString());
                                    Integer limit2 = new Integer(sideLength2.toString());
                                    Integer limit3 = new Integer(sideLength3.toString());
                                    
                                    return ResponseEntity.status(HttpStatus.OK)
                    .cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
                    .body(triangleTypeService.getTriangleType(limit1, limit2, limit3));
                    } catch (Exception e) {
                                      throw new IllegalArgumentException("Invalid Input");
                    }
                    
    }

	}