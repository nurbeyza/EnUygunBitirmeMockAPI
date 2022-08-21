package MockAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MockAPIrestAssured {

    Response response;


    public MockAPIrestAssured(){
        baseURI="https://lgoqg.mocklab.io/";
    }
    @Test(priority = 1)
    public void getallGrocery(){
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://lgoqg.mocklab.io/allGrocery")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        String body=response.getBody().asString();
        System.out.println(body);
    }


    @Test(priority = 2)
    public void getNameGrocery(){

        response= given()
                .accept(ContentType.JSON)
                .pathParam("allGrocery","apple")
                .when()
                .get("allGrocery/{allGrocery}")
                .then()
                .statusCode(200)
                .extract().response();
        String body=response.getBody().asString();
        System.out.println(body);

    }



    @Test(priority = 3)
    public void addGrocery(){

        response = given()
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("{\r\n    \"name\": \"fish\",\r\n    \"status\": \"sold\"\r\n}")
                .when()
                .post("https://lgoqg.mocklab.io/allGrocery")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();


    }
}
