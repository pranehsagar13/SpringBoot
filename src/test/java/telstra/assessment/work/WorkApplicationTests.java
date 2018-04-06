package telstra.assessment.work;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import telstra.assessment.work.controller.FibonacciController;
import telstra.assessment.work.controller.ReverseWordsController;
import telstra.assessment.work.controller.TriangleTypeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {
	
	
	@Autowired
	private FibonacciController fibonacciNumberController;
	@Autowired
	private ReverseWordsController reverseWordsController;
	@Autowired
	private TriangleTypeController triangleTypeController;
	
	@Test
	public void contextLoads() {
		assertNotNull(fibonacciNumberController);		
		assertNotNull(reverseWordsController);
		assertNotNull(triangleTypeController);
			}
	
	@Test
    public void test()
    {
		
    }

}
