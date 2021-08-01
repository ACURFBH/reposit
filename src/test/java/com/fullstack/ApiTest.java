package com.fullstack;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {
	
	@Test
	public void dummyTest() {
		RestAssured.baseURI = "";
		Response res = RestAssured.given()
				.baseUri("https://hub.dummyapis.com")
				.contentType("application/json")
				.get("/employee?noofRecords=10&idStarts=1001");
		
		System.out.println(res.jsonPath().get("[1].id"));
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asString());
		Assert.assertEquals(res.jsonPath().get("id[0]"), 1001);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
}
