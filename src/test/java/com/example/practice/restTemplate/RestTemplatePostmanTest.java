package com.example.practice.restTemplate;

import static org.mockito.BDDMockito.*;

import java.net.SocketTimeoutException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.practice.resttemplate.RestTemplatePostman;

// @ExtendWith(SpringExtension.class)
@SpringBootTest
class RestTemplatePostmanTest {
	// @MockBean
	// RestTemplate restTemplate;
	
	@Autowired
	RestTemplatePostman restTemplatePostman;

	@Test
	@DisplayName("이름을 리턴한다.")
	public void testGet() {
		// given
		// given(restTemplate.getForObject(anyString(), any())).willThrow(RuntimeException.class);
		// given(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(),
		// 	eq(new ParameterizedTypeReference<String>() {}))).willThrow(ResourceAccessException.class);
		// RestTemplatePostman restTemplatePostman = new RestTemplatePostman(restTemplate);

		// when
		String status = restTemplatePostman.getStatus("timeout");

		// then
		Assertions.assertEquals(status, "success");
	}
}
