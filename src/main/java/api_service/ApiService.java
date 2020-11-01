package api_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    protected RequestSpecification setUp() {
        return RestAssured.given()
                .baseUri("http://138.197.179.157/")
                .contentType(ContentType.JSON).log().uri().log().body();
    }
}
