package com.deloitte.deloitte;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@TestInstance(Lifecycle.PER_CLASS)
public class TestWebService extends DeloitteApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	 @BeforeAll
	 public void setup() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	 }
	 
	 public void testWebServiceForUser() throws Exception{
		 mockMvc.perform(get("/loginUser")).andExpect(status().isOk())
		 .andExpect(content().contentType("application/json;charset=UTF-8"))
		 .andExpect(jsonPath("$.emailId").value("p@g.com"))
		 .andExpect(jsonPath("$.password").value("153"));
	 }
	 
	 public void testWebServiceForRegisterUsers() throws Exception{
		 mockMvc.perform(get("/registerUser")).andExpect(status().isOk())
		 .andExpect(content().contentType("application/json;charset=UTF-8"))
		 .andExpect(jsonPath("$emailID").value("p@g.com"))
		 .andExpect(jsonPath("$.password").value("123"))
		 .andExpect(jsonPath("$.name").value("prasad"));

	 }

	
	
}
