package telstra.assessment.work.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import telstra.assessment.work.service.FibonnaciSeriesImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private FibonacciController fibonacciNumberController;

	@InjectMocks
	private FibonnaciSeriesImpl fibonnaciService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(fibonacciNumberController).build();
	}

	private String n = "12";

	@Test
	public void getFibonacciNumberPositive() throws Exception {
		given(this.fibonacciNumberController.getFibonacciNumber("10"))
				.willReturn((ResponseEntity<Long>) ResponseEntity.status(HttpStatus.OK)
						.cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body((Long) 144l));
		mockMvc.perform(get("/api/Fibonacci").param("n", n)).andExpect(status().isOk());

	}

	@Test
	public void testFibonacciNumberPositive() {
		assertEquals(144, fibonnaciService.getFibonacci(12));
	}

	@Test
	public void testFibonacciNumberNegative() {
		assertNotEquals(122, fibonnaciService.getFibonacci(12));
	}

	@Test
	public void testSuccessfulfibonacci() throws Exception {
		mockMvc.perform(get("/api/Fibonacci").param("n", n)).andExpect(status().isOk());
	}

}
