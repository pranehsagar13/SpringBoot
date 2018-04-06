package telstra.assessment.work.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertNotEquals;
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

import telstra.assessment.work.service.ReverseWordsImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReverseWordsControllerTest {

	private String sentence = "how are you";

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ReverseWordsController reverseWordsController;

	@InjectMocks
	private ReverseWordsImpl reverseWordsServices;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(reverseWordsController).build();
	}

	@Test
	public void reverseWordsPositiveTest() throws Exception {
		given(this.reverseWordsController.reverseWords("how are you"))
				.willReturn((ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK)
						.cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body("woh era uoy"));
		mockMvc.perform(get("/api/ReverseWords").param("sentence", "how are you")).andExpect(status().isOk());
	}

	@Test
	public void testSuccessfulWordsReversal() throws Exception {
		mockMvc.perform(get("/api/ReverseWords").param("sentence", sentence)).andExpect(status().isOk());
	}
	
	@Test
	public void testNotSuccessfulWordsReversal() throws Exception {
		mockMvc.perform(get("/api/ReverseWords").param("sentence", "null")).andExpect(status().isOk());
	}
	
	@Test
	public void testFailureScenario() throws Exception {
		assertNotEquals("test",reverseWordsServices.getReverseWordsfromString(sentence) );
	}


}