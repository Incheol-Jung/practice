package com.example.practice.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplatePostman {

	@Autowired
	private RestTemplate restTemplate;

	// public RestTemplatePostman() {
	// 	SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
	// 	factory.setConnectTimeout(1000);
	// 	factory.setReadTimeout(1000);
	// 	this.restTemplate = new RestTemplate(factory);
	// }

	// public RestTemplatePostman(RestTemplate restTemplate) {
	// 	this.restTemplate = restTemplate;
	// }

	public String getStatus(String statusCode) {
		String getURI = "http://localhost:9090/employees/" + statusCode;
		String response = "fail";
		try {
			response = this.restTemplate.getForObject(getURI, String.class);
			System.out.println(response);
		}
		catch (HttpClientErrorException ex) {
			System.out.println("-------- catch 1. --------" + ex);
		}
		catch (HttpServerErrorException ex) {
			System.out.println("-------- catch 1. --------" + ex);
		}
		catch (HttpStatusCodeException ex) {
			System.out.println("-------- catch 1. --------" + ex);
		} 
		catch (RestClientException ex) {
			System.out.println("-------- catch 2. --------" + ex);
		}
		catch (RuntimeException ex) {
			System.out.println("-------- catch 3. --------" + ex);
		}

		return response;
	}

	// public static void main(String[] args) {
	// 	RestTemplatePostman restTemplatePostman = new RestTemplatePostman();
	// 	String status = restTemplatePostman.getStatus("200");
	// 	System.out.println("status = " + status);
	// }
}
