package telstra.assessment.work.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import telstra.assessment.work.service.TriangleTypeImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleTypeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private TriangleTypeController triangleTypeController;

	@InjectMocks
	private TriangleTypeImpl triangleTypeImplService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(triangleTypeController).build();
	}

	@Test
	public void testSuccessfulWordsReversal() throws Exception {
		mockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
				.andExpect(status().is(200));
	}

	@Test
	public void triangleTypePositiveTest() throws Exception {
		given(this.triangleTypeController.fetchTriangleType("1", "1", "1"))
				.willReturn((ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK)
						.cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body("Equilateral"));
		mockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
				.andExpect(status().isOk());
	}

	@Test
	public void testForTriangleTypeEquilateral() {
		assertEquals("Equilateral", triangleTypeImplService.getTriangleType(2, 2, 2));
	}

	@Test
	public void testForTriangleTypeScalene() {
		assertEquals("Scalene", triangleTypeImplService.getTriangleType(2, 3, 4));
	}

	@Test
	public void testForTriangleTypeIsosceles() {
		assertEquals("Isosceles", triangleTypeImplService.getTriangleType(1, 2, 2));
	}
}