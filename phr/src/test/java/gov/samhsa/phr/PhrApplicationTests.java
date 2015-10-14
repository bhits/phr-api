package gov.samhsa.phr;

import gov.samhsa.phr.config.PhrApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhrApplication.class)
@WebAppConfiguration
public class PhrApplicationTests {

/*	private MockMvc mockMvc;

	@Mock
	private IExHubDataService iExHubDataService;

	@InjectMocks
	private PatientHealthDataController sut;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(this.sut).build();
	}*/
	@Test
	public void contextLoads() {
	}

}
