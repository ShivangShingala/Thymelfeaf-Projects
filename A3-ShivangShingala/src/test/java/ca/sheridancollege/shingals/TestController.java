package ca.sheridancollege.shingals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import ca.sheridancollege.shingals.beans.Discussion;
import ca.sheridancollege.shingals.beans.EmployeeRegistration;
import ca.sheridancollege.shingals.database.DatabaseAccess;

@SpringBootTest
@AutoConfigureMockMvc
public class TestController {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void testLoadingViewDiscussionsPage() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
	public void testInsertDiscussion() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		Discussion d = new Discussion();
	    d.setName("Extension Cord");
		d.setDatee("27/10/2020");
		d.setThread("Hello, my name is Shivang");	
	}
	
	@Test
	public void testInsertDiscussionToDatabase() {
		Discussion d = new Discussion();
		int origSize = da.getAllDiscussions().size();
		da.insertDiscussion(d);
		int newSize = da.getAllDiscussions().size();
		assertThat(newSize).isEqualTo(origSize + 1);
	}
	
	@Test
	public void testUserRegistration() {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		EmployeeRegistration ne = new EmployeeRegistration();
	    ne.setUsername("Vatsal");
		ne.setPassword("pass2");
		ne.setAuthority("employee");	
	}
	
	
	
}
